package ru.andreev.lectureschedule.domain;

import org.hibernate.annotations.Type;
import ru.andreev.lectureschedule.enums.TypeOfLesson;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.DayOfWeek;
import java.util.Arrays;
import java.util.Objects;


@Entity
@Table(name = "lesson")
public class Lesson extends AbstractEntity {

    @Type(type = "int-array")
    @Column(
        name = "numOfWeek",
            columnDefinition = "int[]"
    )
    private int[] numOfWeek;

    @Column
    private DayOfWeek dayOfWeek;

    @Column
    private int numOfLesson;

    @Column
    private String name;

    @Column
    private String teacher;

    @Column
    private TypeOfLesson type;

    @Column
    private String audience;

    public int[] getNumOfWeek() {
        return numOfWeek;
    }

    public void setNumOfWeek(int[] numOfWeek) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lesson lesson = (Lesson) o;
        return numOfLesson == lesson.numOfLesson &&
                Arrays.equals(numOfWeek, lesson.numOfWeek) &&
                dayOfWeek == lesson.dayOfWeek &&
                Objects.equals(name, lesson.name) &&
                Objects.equals(teacher, lesson.teacher) &&
                type == lesson.type &&
                Objects.equals(audience, lesson.audience);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(dayOfWeek, numOfLesson, name, teacher, type, audience);
        result = 31 * result + Arrays.hashCode(numOfWeek);
        return result;
    }
}
