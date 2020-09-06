package ru.andreev.lectureschedule.DTO;

import ru.andreev.lectureschedule.enums.Course;
import ru.andreev.lectureschedule.enums.EFaculty;

import javax.validation.constraints.NotBlank;

public class GroupDTO {

    @NotBlank
    private String numOfGroup;

    @NotBlank
    private EFaculty EFaculty;

    @NotBlank
    private Course course;

    private Boolean isScheduleExist;

    public String getNumOfGroup() {
        return numOfGroup;
    }

    public void setNumOfGroup(String numOfGroup) {
        this.numOfGroup = numOfGroup;
    }

    public EFaculty getEFaculty() {
        return EFaculty;
    }

    public void setEFaculty(EFaculty EFaculty) {
        this.EFaculty = EFaculty;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Boolean getScheduleExist() {
        return isScheduleExist;
    }

    public void setScheduleExist(Boolean scheduleExist) {
        isScheduleExist = scheduleExist;
    }
}
