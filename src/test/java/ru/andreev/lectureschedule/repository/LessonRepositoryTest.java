package ru.andreev.lectureschedule.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import ru.andreev.lectureschedule.domain.Lesson;
import ru.andreev.lectureschedule.service.ParseService;

import static org.junit.Assert.*;

import java.util.List;

@EnableJpaRepositories
@DataJpaTest
public class LessonRepositoryTest {

    @Autowired
    private ParseService parseService;

    @Autowired
    private LessonRepository lessonRepository;

    @Test
     void save_lessons_to_database(){
        List<Lesson> saveLesson =  lessonRepository.saveAll(parseService
                .readSchedule());
        assertNotNull(saveLesson);
    }

}
