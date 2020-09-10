package ru.andreev.lectureschedule.service;

import org.springframework.stereotype.Service;
import ru.andreev.lectureschedule.entity.Faculty;
import ru.andreev.lectureschedule.enums.EFaculty;
import ru.andreev.lectureschedule.repository.FacultyRepository;

import java.util.Optional;

@Service
public class FacultyService {
    private final FacultyRepository facultyRepository;

    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    public Faculty save(Faculty faculty){
        return facultyRepository.save(faculty);
    }

    public Optional<Faculty> findByEFaculty(EFaculty eFaculty){
        return facultyRepository.findByeFaculty(eFaculty);
    }
}
