package ru.andreev.lectureschedule.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import ru.andreev.lectureschedule.entity.Lesson;
import ru.andreev.lectureschedule.enums.TypeOfLesson;
import ru.andreev.lectureschedule.repository.LessonRepository;

import java.time.DayOfWeek;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class LessonServiceTest {
    @Mock
    private LessonRepository lessonRepository;
    @InjectMocks
    private LessonService lessonService;

    private Lesson newLesson;

    @Before
    public void init(){
        newLesson = new Lesson();
        newLesson.setName("Эргономика и дизайн графических интерфейсов");
        newLesson.setDayOfWeek(DayOfWeek.MONDAY);
        newLesson.setNumOfLesson(2);
        newLesson.setType(TypeOfLesson.LABORATORY_WORK);
        newLesson.setTeacher("Мусаева Т.В.");
        newLesson.setAudience("ауд.: 202; Б22/2");
        newLesson.setNumOfWeek(List.of(5,7,9,11,13,15,17));

    }

    @Test
    public void shouldSaveLesson(){

    }



}
