package ru.andreev.lectureschedule.domain;

import ru.andreev.lectureschedule.enums.TypeOfLesson;

import java.time.DayOfWeek;

public class Lesson extends AbstractEntity {

    private int[] numOfWeek;

    private DayOfWeek dayOfWeek;

    private int numOfLesson;

    private String name;

    private String teacher;

    private TypeOfLesson type;

    private String audience;

    public int[] getNumOfWeek() {
        return numOfWeek;
    }

    public void setNumOfWeek(int[] numOfWeek) {
        this.numOfWeek = numOfWeek;
    }

    public void setNumOfWeek(String numOfWeek){
        //todo
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(Integer dayOfWeek) {
        this.dayOfWeek = DayOfWeek.of(dayOfWeek);
    }

    public int getNumOfLesson() {
        return numOfLesson;
    }

    public void setNumOfLesson(int numOfLesson) {
        this.numOfLesson = numOfLesson;
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

    public TypeOfLesson getType() {
        return type;
    }

    public void setType(String type){
        if(type.equals("(Лабораторная работа)")){
            this.type = TypeOfLesson.LABORATORY_WORK;
        }else if(type.equals("(Практические занятия)")){
            this.type = TypeOfLesson.PRACTICAL_LESSON;
        } else {
            this.type = TypeOfLesson.LECTURE;
        }
    }

    public void setType(TypeOfLesson type) {
        this.type = type;
    }

    public String getAudience() {
        return audience;
    }

    public void setAudience(String audience) {
        this.audience = audience;
    }
}
