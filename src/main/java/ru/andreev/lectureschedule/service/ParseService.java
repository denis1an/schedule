package ru.andreev.lectureschedule.service;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import ru.andreev.lectureschedule.domain.Lesson;
import ru.andreev.lectureschedule.enums.TypeOfLesson;

import java.io.IOException;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;

public class ParseService {

    public List<Lesson> readSchedule(String url){
        Document document = getDocument(url);
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
            int[] numOfWeek = new int[20];
            int j = 0;
            for (int i = 1; i < weeks.length() - 1; i++) {
                int index = weeks.indexOf(',', i);
                if(index == -1){
                    index = weeks.indexOf('н',i);
                }
                numOfWeek[j++] = Integer.parseInt(weeks.substring(i,index));
                i = index + 1;
            }
            lesson.setNumOfWeek(numOfWeek);

            lessons.add(lesson);
        }

        return lessons;
    }
    
    private Document getDocument(String url){
        Document document = null;
        try {
            document = Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return document;
    }
}
