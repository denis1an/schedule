package ru.andreev.lectureschedule.payload.request;

import javax.validation.constraints.NotBlank;

public class GroupRequest {
    @NotBlank
    String faculty;  // todo test with enums, maybe it works

    @NotBlank
    String course; // todo same

    @NotBlank
    String name;

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
