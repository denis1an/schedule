package ru.andreev.lectureschedule.service;

import org.springframework.stereotype.Service;
import ru.andreev.lectureschedule.DTO.LessonDTO;
import ru.andreev.lectureschedule.entity.Lesson;
import ru.andreev.lectureschedule.mapper.LessonMapper;
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

    public Optional<LessonDTO> findById(Long id){
        Optional<Lesson> optionalLesson = lessonRepository.findById(id);
        return optionalLesson.map(LessonMapper::toDto);
    }

    public List<LessonDTO> findAll(){
        return LessonMapper.toDto(lessonRepository.findAll());
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

    public List<LessonDTO> findForWeek(Integer numOfWeek, Long groupId){
        return LessonMapper.toDto(lessonRepository.findAllByNumOfWeekContainsAndGroupId(numOfWeek,groupId));
    }

    public List<LessonDTO> findForDay(Integer numOfWeek, DayOfWeek dayOfWeek, Long groupId){
        return LessonMapper.toDto(lessonRepository.findAllByNumOfWeekContainsAndDayOfWeekAndGroupId(numOfWeek,dayOfWeek,groupId));
    }
}
