package ru.andreev.lectureschedule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.andreev.lectureschedule.entity.Group;
import ru.andreev.lectureschedule.entity.Lesson;

import java.time.DayOfWeek;
import java.util.List;

public interface LessonRepository extends JpaRepository<Lesson,Long> {

    List<Lesson> findAllByNumOfWeekContainsAndGroup(Integer numOfWeek, Group currentGroup);

    List<Lesson> findAllByNumOfWeekContainsAndDayOfWeekAndGroup(Integer numOfWeek, DayOfWeek day, Group currentGroup);

}
