package ru.andreev.lectureschedule.service;

import org.junit.jupiter.api.Test;
import ru.andreev.lectureschedule.domain.Lesson;
import ru.andreev.lectureschedule.enums.TypeOfLesson;

import java.time.DayOfWeek;
import java.util.List;

import static org.junit.Assert.*;

public class ParseServiceTests{

    @Test
    void it_should_return_parse_lessons () {
        ParseService parseService = new ParseService();

        List<Lesson> lessons = parseService.readSchedule();
        Lesson lesson = lessons.get(0);

        assertEquals("Эргономика и дизайн графических интерфейсов", lesson.getName());
        assertEquals(DayOfWeek.MONDAY, lesson.getDayOfWeek());
        assertEquals(2, lesson.getNumOfLesson());
        assertEquals(TypeOfLesson.LABORATORY_WORK, lesson.getType());
        assertEquals("Мусаева Т.В.", lesson.getTeacher());
        assertEquals("ауд.: 202; Б22/2", lesson.getAudience());
        assertEquals("(5, 7, 9, 11, 13, 15, 17н)", lesson.getNumOfWeek());
    }

}

