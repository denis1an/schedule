package ru.andreev.lectureschedule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.andreev.lectureschedule.entity.Lesson;

import java.time.DayOfWeek;
import java.util.List;

public interface LessonRepository extends JpaRepository<Lesson,Long> {

    List<Lesson> findAllByNumOfWeekContainsAndGroupId(Integer numOfWeek, Long groupId);

    List<Lesson> findAllByNumOfWeekContainsAndDayOfWeekAndGroupId(Integer numOfWeek, DayOfWeek day, Long groupId);

    List<Lesson> findAllByNameContainingAndTeacherContainingAndAudienceContainingAndGroupId
            (String name, String teacher, String audience, Long groupId);
}
