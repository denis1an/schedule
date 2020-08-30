package ru.andreev.lectureschedule.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import ru.andreev.lectureschedule.enums.Department;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "class")
public class Group extends AbstractEntity {

    @Column
    private Department department;

    @Column
    private int numOfCourse;

    @Column
    private String numOfGroup;

    @OneToMany(mappedBy = "group", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Lesson> lessons;

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public int getNumOfCourse() {
        return numOfCourse;
    }

    public void setNumOfCourse(int numOfCourse) {
        this.numOfCourse = numOfCourse;
    }

    public String getNumOfGroup() {
        return numOfGroup;
    }

    public void setNumOfGroup(String numOfGroup) {
        this.numOfGroup = numOfGroup;
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }
}
