package ru.andreev.lectureschedule.DTO;

import ru.andreev.lectureschedule.enums.TypeOfLesson;

import java.time.DayOfWeek;

public class LessonDTO {

    private Long id;
    private String name;
    private String teacher;
    private TypeOfLesson type;
    private DayOfWeek dayOfWeek;
    private int numOfLesson;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public void setType(TypeOfLesson type) {
        this.type = type;
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(DayOfWeek dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public int getNumOfLesson() {
        return numOfLesson;
    }

    public void setNumOfLesson(int numOfLesson) {
        this.numOfLesson = numOfLesson;
    }
}