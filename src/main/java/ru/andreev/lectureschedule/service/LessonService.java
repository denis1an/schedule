package ru.andreev.lectureschedule.service;

import org.springframework.stereotype.Service;
import ru.andreev.lectureschedule.DTO.LessonDTO;
import ru.andreev.lectureschedule.entity.Group;
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

    public Lesson save(Lesson lesson){
        return lessonRepository.save(lesson);
    }

    public Lesson update(Lesson lesson){
        return lessonRepository.save(lesson);
    }

    public void delete(Lesson lesson){
        lessonRepository.delete(lesson);
    }

    public List<LessonDTO> findByWeek(Integer numOfWeek, Group currentGroup){
        return LessonMapper.toDto(
                lessonRepository.findAllByNumOfWeekContainsAndGroup(numOfWeek,currentGroup)
        );
    }

    public List<LessonDTO> findByDay(Integer numOfWeek, DayOfWeek dayOfWeek, Group currentGroup){
        return LessonMapper.toDto(
                lessonRepository.findAllByNumOfWeekContainsAndDayOfWeekAndGroup(numOfWeek,dayOfWeek,currentGroup)
        );
    }
}
