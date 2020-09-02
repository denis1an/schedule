package ru.andreev.lectureschedule.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import ru.andreev.lectureschedule.enums.TypeOfLesson;

import javax.persistence.*;
import java.time.DayOfWeek;
import java.util.List;
import java.util.Objects;


@Entity
@Table(name = "lessons")
public class Lesson extends AbstractEntity {

    @Column
    private String name;

    @Column
    private String teacher;

    @Column
    private TypeOfLesson type;

    @Column
    private String audience;

    @Column
    private DayOfWeek dayOfWeek;

    @Column
    private int numOfLesson;

    @ManyToOne(fetch= FetchType.LAZY, cascade= CascadeType.ALL)
    @JsonBackReference
    private Group group;

    @Column
    @ElementCollection
    private List<Integer> numOfWeek;

    public List<Integer> getNumOfWeek() {
        return numOfWeek;
    }

    public void setNumOfWeek(List<Integer> numOfWeek) {
        this.numOfWeek = numOfWeek;
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

    public String getAudience() {
        return audience;
    }

    public void setAudience(String audience) {
        this.audience = audience;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lesson lesson = (Lesson) o;
        return numOfLesson == lesson.numOfLesson &&
                Objects.equals(numOfWeek, lesson.numOfWeek) &&
                dayOfWeek == lesson.dayOfWeek &&
                Objects.equals(name, lesson.name) &&
                Objects.equals(teacher, lesson.teacher) &&
                type == lesson.type &&
                Objects.equals(audience, lesson.audience);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numOfWeek, dayOfWeek, numOfLesson, name, teacher, type, audience);
    }
}
