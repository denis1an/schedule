package ru.andreev.lectureschedule.DTO;

import ru.andreev.lectureschedule.enums.Course;
import ru.andreev.lectureschedule.enums.Department;

public class GroupDTO {
    private String numOfGroup;
    private Department department;
    private Course course;

    public String getNumOfGroup() {
        return numOfGroup;
    }

    public void setNumOfGroup(String numOfGroup) {
        this.numOfGroup = numOfGroup;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
