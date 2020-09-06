package ru.andreev.lectureschedule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.andreev.lectureschedule.entity.Faculty;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty,Long> {
}
