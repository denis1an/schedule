package ru.andreev.lectureschedule.service;

import org.junit.jupiter.api.Test;
import ru.andreev.lectureschedule.entity.Faculty;
import ru.andreev.lectureschedule.entity.Lesson;
import ru.andreev.lectureschedule.enums.EFaculty;
import ru.andreev.lectureschedule.enums.TypeOfLesson;

import java.time.DayOfWeek;
import java.util.List;

import static org.junit.Assert.*;

public class ParseServiceTests{

    private final String groups = "ФфП,50008;54435,ФП-01;54436,ФП-02;53315,ФП-71;53790,ФП-81;54208,ФП-91;54298,ФП-92;";

    @Test
    void it_should_return_parse_lessons () {
        ParseService parseService = new ParseService();

        List<Lesson> lessons = parseService.readSchedule("50005","54214", null);
        Lesson lesson = lessons.get(0);

        assertEquals("Эргономика и дизайн графических интерфейсов", lesson.getName());
        assertEquals(DayOfWeek.MONDAY, lesson.getDayOfWeek());
        assertEquals(2, lesson.getNumOfLesson());
        assertEquals(TypeOfLesson.LABORATORY_WORK, lesson.getType());
        assertEquals("Мусаева Т.В.", lesson.getTeacher());
        assertEquals("ауд.: 202; Б22/2", lesson.getAudience());
        assertEquals(7, lesson.getNumOfWeek().size());
    }

    @Test
    void it_should_return_faculty_of_group(){
        ParseService parseService = new ParseService();
        Faculty faculty = parseService.readGroupsOfFaculty(groups);

        assertEquals(EFaculty.FFP, faculty.getEFaculty());
        assertEquals(50008,faculty.getNumber());
        assertEquals(6, faculty.getGroupsNum().size());
        assertEquals("54298",faculty.getGroupsNum().get("ФП-92"));
    }

}

