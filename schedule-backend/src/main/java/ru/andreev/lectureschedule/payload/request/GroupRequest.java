package ru.andreev.lectureschedule.payload.request;

import ru.andreev.lectureschedule.enums.Course;
import ru.andreev.lectureschedule.enums.EFaculty;

import javax.validation.constraints.NotBlank;

public class GroupRequest {
    @NotBlank
    EFaculty faculty;

    @NotBlank
    Course course;

    @NotBlank
    String name;

    public EFaculty getFaculty() {
        return faculty;
    }

    public void setFaculty(EFaculty faculty) {
        this.faculty = faculty;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
