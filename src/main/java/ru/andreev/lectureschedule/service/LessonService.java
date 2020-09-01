package ru.andreev.lectureschedule.service;

import org.springframework.stereotype.Service;
import ru.andreev.lectureschedule.domain.Lesson;
import ru.andreev.lectureschedule.repository.LessonRepository;

import java.time.DayOfWeek;
import java.util.List;
import java.util.Optional;

@Service
public class LessonService {

    private final LessonRepository lessonRepository;

    public LessonService(LessonRepository lessonRepository) {
        this.lessonRepository = lessonRepository;
    }

    public Optional<Lesson> findById(Long id){
        return lessonRepository.findById(id);
    }

    public List<Lesson> findAll(){
        return lessonRepository.findAll();
    }

    public void save(Lesson lesson){
        lessonRepository.save(lesson);
    }

    public void update(Lesson lesson){
        lessonRepository.save(lesson);
    }

    public void delete(Lesson lesson){
        lessonRepository.delete(lesson);
    }

    public List<Lesson> findByWeek(Integer numOfWeek){
        return lessonRepository.findAllByNumOfWeekContains(numOfWeek);
    }

    public List<Lesson> findByDay(Integer numOfWeek, DayOfWeek dayOfWeek){
        return lessonRepository.findAllByNumOfWeekContainsAndDayOfWeek(numOfWeek,dayOfWeek);
    }
}
