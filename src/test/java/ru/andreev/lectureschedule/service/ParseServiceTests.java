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

        List<Lesson> lessons = parseService.readSchedule("https://cabinet.sut.ru/raspisanie_all_new?type_z=1?faculty=50005&kurs=2&group=54214&ok=%D0%9F%D0%BE%D0%BA%D0%B0%D0%B7%D0%B0%D1%82%D1%8C&group_el=0");
        Lesson lesson = lessons.get(0);

        assertEquals("Эргономика и дизайн графических интерфейсов", lesson.getName());
        assertEquals(DayOfWeek.MONDAY, lesson.getDayOfWeek());
        assertEquals(2, lesson.getNumOfLesson());
        assertEquals(TypeOfLesson.LABORATORY_WORK, lesson.getType());
        assertEquals("Мусаева Т.В.", lesson.getTeacher());
        assertEquals("ауд.: 202; Б22/2", lesson.getAudience());
        assertArrayEquals(new int[]{5, 7, 9, 11, 13, 15, 17,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, lesson.getNumOfWeek());
    }

}

