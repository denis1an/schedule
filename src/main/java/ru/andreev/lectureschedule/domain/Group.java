package ru.andreev.lectureschedule.domain;

import ru.andreev.lectureschedule.enums.Department;

import java.util.List;

public class Group extends AbstractEntity {
    private Department department;

    private int numOfCourse;

    private String numOfGroup;

    private List<Lesson> lessons;
}
