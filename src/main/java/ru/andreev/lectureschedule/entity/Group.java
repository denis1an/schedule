package ru.andreev.lectureschedule.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import ru.andreev.lectureschedule.enums.Course;
import ru.andreev.lectureschedule.enums.EFaculty;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "class")
public class Group extends AbstractEntity {

    @Column
    private String name;

    @Column
    private EFaculty EFaculty;

    @Column
    private Course course;

    @OneToMany(mappedBy = "group", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Lesson> lessons;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }
}
