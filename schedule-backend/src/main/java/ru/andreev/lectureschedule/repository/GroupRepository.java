package ru.andreev.lectureschedule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.andreev.lectureschedule.entity.Faculty;
import ru.andreev.lectureschedule.entity.Group;
import ru.andreev.lectureschedule.enums.Course;
import ru.andreev.lectureschedule.enums.EFaculty;

import java.util.List;
import java.util.Optional;

public interface GroupRepository extends JpaRepository<Group, Long> {
    Optional<Group> findByEFacultyAndName(EFaculty faculty, String name);

    List<Group> findAllByCourseAndEFaculty(Course course, EFaculty EFaculty);

    List<Group> findAllByEFaculty(EFaculty eFaculty);

}
