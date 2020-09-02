package ru.andreev.lectureschedule.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import ru.andreev.lectureschedule.enums.Course;
import ru.andreev.lectureschedule.enums.Department;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "class")
public class Group extends AbstractEntity {

    @Column
    private Department department;

    @Column
    private Course course;

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

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
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
