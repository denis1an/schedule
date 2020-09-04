package ru.andreev.lectureschedule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.andreev.lectureschedule.entity.Group;
import ru.andreev.lectureschedule.enums.Course;
import ru.andreev.lectureschedule.enums.Faculty;

import java.util.List;
import java.util.Optional;

public interface GroupRepository extends JpaRepository<Group, Long> {
    Optional<Group> findByFacultyAndNumOfGroup(Faculty faculty, String numOfGroup);

    List<Group> findAllByCourseAndFaculty(Course course, Faculty faculty);

    List<Group> findAllByFaculty(Faculty faculty);
}
