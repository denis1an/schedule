package ru.andreev.lectureschedule.service;

import org.springframework.stereotype.Service;
import ru.andreev.lectureschedule.DTO.LessonDTO;
import ru.andreev.lectureschedule.comporator.LessonDtoDayPairComparator;
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

    public void saveAll(List<Lesson> lessons){
        lessonRepository.saveAll(lessons);
    }

    public void update(Lesson lesson){
        lessonRepository.save(lesson);
    }

    public void delete(Lesson lesson){
        lessonRepository.delete(lesson);
    }

    public List<LessonDTO> findByLesson(String name, String teacher, String audience, Long groupId){
        return LessonMapper.toDto(
                lessonRepository.findAllByNameContainingAndTeacherContainingAndAudienceContainingAndGroupId(name, teacher,audience,groupId));
    }

    public List<LessonDTO> findForWeek(Date date, Long groupId){
        List<LessonDTO> lessons = LessonMapper.toDto(lessonRepository.findAllByNumOfWeekContainsAndGroupId(getNumOfWeek(date),groupId));
        lessons.sort(new LessonDtoDayPairComparator());
        return lessons;
    }

    public List<LessonDTO> findForDay(Date date, Long groupId){
        return LessonMapper.
                toDto(lessonRepository.findAllByNumOfWeekContainsAndDayOfWeekAndGroupId(getNumOfWeek(date),getDayOfWeek(date),groupId));
    }

    private DayOfWeek getDayOfWeek(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        DayOfWeek dayOfWeek;
        int day = calendar.get(Calendar.DAY_OF_WEEK);
        switch (day){
            case 1:
                dayOfWeek = DayOfWeek.SUNDAY;
                break;
            case 2:
                dayOfWeek = DayOfWeek.MONDAY;
                break;
            case 3:
                dayOfWeek = DayOfWeek.TUESDAY;
                break;
            case 4:
                dayOfWeek = DayOfWeek.WEDNESDAY;
                break;
            case 5:
                dayOfWeek = DayOfWeek.THURSDAY;
                break;
            case 6:
                dayOfWeek = DayOfWeek.FRIDAY;
                break;
            default:
                dayOfWeek = DayOfWeek.SATURDAY;
        }
        return dayOfWeek;
    }

    private int getNumOfWeek(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.WEEK_OF_YEAR) - 35;
    }
}
