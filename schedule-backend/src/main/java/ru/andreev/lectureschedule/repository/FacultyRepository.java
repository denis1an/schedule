package ru.andreev.lectureschedule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.andreev.lectureschedule.entity.Faculty;
import ru.andreev.lectureschedule.enums.EFaculty;

import java.util.Optional;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty,Long> {
    Optional<Faculty> findByeFaculty(EFaculty efaculty);
}
