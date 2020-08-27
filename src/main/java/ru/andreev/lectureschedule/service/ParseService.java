package ru.andreev.lectureschedule.service;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import ru.andreev.lectureschedule.domain.Lesson;

import java.io.IOException;

public class ParseService {

    public void readSchedule(String url){
        Document document = getDocument(url);

        Elements elements = document.getElementsByClass("pair");
        for (Element element : elements){
            Lesson lesson = new Lesson();

            lesson.setName(element.getElementsByTag("strong").text());
            lesson.setTeacher(element.getElementsByClass("teacher").text());
            lesson.setAudience(element.getElementsByClass("aud").text());
            lesson.setNumOfLesson(Integer.parseInt(element.attr("pair")));
            lesson.setType(element.getElementsByClass("type").text());
            lesson.setNumOfWeek(element.getElementsByClass("weeks").text());
        }
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
