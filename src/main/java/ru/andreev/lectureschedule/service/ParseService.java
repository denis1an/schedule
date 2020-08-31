package ru.andreev.lectureschedule.service;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;
import ru.andreev.lectureschedule.domain.Lesson;
import ru.andreev.lectureschedule.enums.TypeOfLesson;

import java.io.File;
import java.io.IOException;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;

@Service
public class ParseService {

    @Deprecated
    public List<Lesson> readSchedule(){
        Document document = getDocument();
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
    
    private Document getDocument(){
        Document document = null;
        File file = new File("/Users/denisandreev/IdeaProjects/lecture-schedule/src/main/resources/tmp/index.html");
        try {
            document = Jsoup.parse(file,"UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return document;
    }
}
