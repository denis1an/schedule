package ru.andreev.lectureschedule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.andreev.lectureschedule.domain.Lesson;

import java.time.DayOfWeek;
import java.util.List;

public interface LessonRepository extends JpaRepository<Lesson,Long> {

    List<Lesson> findAllByNumOfWeekContains(Integer numOfWeek);

    List<Lesson> findAllByNumOfWeekContainsAndDayOfWeek(Integer numOfWeek, DayOfWeek day);

}
