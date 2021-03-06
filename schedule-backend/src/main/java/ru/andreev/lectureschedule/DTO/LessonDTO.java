package ru.andreev.lectureschedule.DTO;

import java.util.List;

public class LessonDTO {

    private String name;
    private String teacher;
    private String type;
    private String dayOfWeek;
    private String audience;
    private int numOfLesson;
    private String startOfLesson;
    private String endOfLesson;

    private List<String> dates;

    public List<String> getDates() {
        return dates;
    }

    public void setDates(List<String> dates) {
        this.dates = dates;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public String getAudience() {
        return audience;
    }

    public void setAudience(String audience) {
        this.audience = audience;
    }

    public String getStartOfLesson() {
        return startOfLesson;
    }

    public void setStartOfLesson(String startOfLesson) {
        this.startOfLesson = startOfLesson;
    }

    public String getEndOfLesson() {
        return endOfLesson;
    }

    public void setEndOfLesson(String endOfLesson) {
        this.endOfLesson = endOfLesson;
    }

    public int getNumOfLesson() {
        return numOfLesson;
    }

    public void setNumOfLesson(int numOfLesson) {
        this.numOfLesson = numOfLesson;
    }
}
