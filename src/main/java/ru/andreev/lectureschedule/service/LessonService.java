package ru.andreev.lectureschedule.service;

import org.springframework.stereotype.Service;
import ru.andreev.lectureschedule.DTO.LessonDTO;
import ru.andreev.lectureschedule.entity.Lesson;
import ru.andreev.lectureschedule.mapper.LessonMapper;
import ru.andreev.lectureschedule.repository.LessonRepository;

import java.time.DayOfWeek;
import java.util.Calendar;
import java.util.Date;
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

    public void saveAll(List<Lesson> lessons){
        lessonRepository.saveAll(lessons);
    }

    public void update(Lesson lesson){
        lessonRepository.save(lesson);
    }

    public void delete(Lesson lesson){
        lessonRepository.delete(lesson);
    }

    public List<LessonDTO> findForWeek(Date date, Long groupId){
        return LessonMapper.toDto(lessonRepository.findAllByNumOfWeekContainsAndGroupId(getNumOfWeek(date),groupId));
    }

    public List<LessonDTO> findForDay(Date date, Long groupId){
        return LessonMapper.toDto(lessonRepository.findAllByNumOfWeekContainsAndDayOfWeekAndGroupId(getNumOfWeek(date),getDayOfWeek(date),groupId));
    }

    private DayOfWeek getDayOfWeek(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        if(dayOfWeek == 0){
             return DayOfWeek.SUNDAY;
        }else {
            return DayOfWeek.of(dayOfWeek);
        }
    }

    private int getNumOfWeek(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.WEEK_OF_YEAR) - 35;
    }
}
