package ru.andreev.lectureschedule.service;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;
import ru.andreev.lectureschedule.entity.Faculty;
import ru.andreev.lectureschedule.entity.Group;
import ru.andreev.lectureschedule.entity.Lesson;
import ru.andreev.lectureschedule.enums.EFaculty;
import ru.andreev.lectureschedule.enums.TypeOfLesson;

import java.io.IOException;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ParseService {
    public Faculty readGroupsOfFaculty(String input){
        Faculty faculty = new Faculty();
        faculty.setEFaculty(stringToEnum(input.substring(0,input.indexOf(','))));

        int i = input.indexOf(";");
        faculty.setNumber(input.substring(input.indexOf(',') + 1, i ));

        Map<String,String> groupNames = new HashMap<>();
        for(i = i + 1; i < input.length(); i++){
            int j = input.indexOf(',',i);
            int k = input.indexOf(';',i);
            String code = input.substring(i,j);
            String groupName = input.substring(j + 1,k);

            groupNames.put(groupName,code);
            i = k;
        }
        faculty.setGroupsNum(groupNames);
        return faculty;
    }

    public List<Lesson> readSchedule(String codeFaculty, String codeGroup){
        Document document = getDocument(codeFaculty, codeGroup);
        Elements elements = document.getElementsByClass("pair");
        List<Lesson> lessons  = new ArrayList<>();
        for (Element element : elements){
            Lesson lesson = new Lesson();
            lesson.setName(element.getElementsByTag("strong").text());
            lesson.setTeacher(element.getElementsByClass("teacher").text());
            lesson.setAudience(element.getElementsByClass("aud").text());
            lesson.setNumOfLesson(Integer.parseInt(element.attr("pair")));

            int dayOfWeek = Integer.parseInt(element.attr("weekday"));
            lesson.setDayOfWeek(DayOfWeek.of(dayOfWeek));

            String typeString = element.getElementsByClass("type").text();
            if(typeString.equals("(Лабораторная работа)")){
                lesson.setType(TypeOfLesson.LABORATORY_WORK);
            }else if(typeString.equals("(Практические занятия)")){
                lesson.setType(TypeOfLesson.PRACTICAL_LESSON);
            } else {
                lesson.setType(TypeOfLesson.LECTURE);
            }
            String weeks = element.getElementsByClass("weeks").text();

            List<Integer> numOfWeek = new ArrayList<>();
            for (int i = 1; i < weeks.length() - 1 ; i++) {
                int index = weeks.indexOf(',',i);
                if(index == -1){
                    index = weeks.indexOf('н', i);
                }
                numOfWeek.add(Integer.parseInt(weeks.substring(i,index)));
                i = index + 1;
            }
            lesson.setNumOfWeek(numOfWeek);
            lessons.add(lesson);
        }

        return lessons;
    }

    private EFaculty stringToEnum(String nameFaculty){
        EFaculty faculty;
        switch (nameFaculty){
            case "ИСИТ":
                faculty = EFaculty.ISIT;
                break;
            case "ИКСС":
                faculty = EFaculty.IKSS;
                break;
            case "РТС":
                faculty = EFaculty.RTS;
                break;
            case "ФфП":
                faculty = EFaculty.FFP;
                break;
            case "ЦЭУБИ":
                faculty = EFaculty.TSEUBI;
                break;
            case "ГФ":
                faculty = EFaculty.GF;
                break;
            case "ИНО":
                faculty = EFaculty.INO;
                break;
            case "Институт магистратуры":
                faculty = EFaculty.MAGISTRACY;
                break;
            default:
                throw new  IllegalArgumentException();
        }
        return faculty;
    }

    private Document getDocument(String codeFaculty, String codeGroup){
        String URL_PARSE_SCHEDULE = "https://cabinet.sut.ru/raspisanie_all_new?type_z=1" +
                "?faculty=" + codeFaculty +
                "&kurs=0" +
                "&group=" + codeGroup  +
                "&ok=%D0%9F%D0%BE%D0%BA%D0%B0%D0%B7%D0%B0%D1%82%D1%8C&group_el=0";
        Document document = null;
         try {
            document = Jsoup.connect(URL_PARSE_SCHEDULE).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return document;
    }
}
