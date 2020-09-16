package ru.andreev.lectureschedule.mapper;

import ru.andreev.lectureschedule.DTO.LessonDTO;
import ru.andreev.lectureschedule.entity.Lesson;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class LessonMapper {
    public static LessonDTO toDto(Lesson lesson){
        LessonDTO lessonDTO = new LessonDTO();
        lessonDTO.setName(lesson.getName());
        lessonDTO.setTeacher(lesson.getTeacher());
        lessonDTO.setType(String.valueOf(lesson.getType()));
        lessonDTO.setDayOfWeek(lesson.getDayOfWeek());
        lessonDTO.setAudience(lesson.getAudience());
        lessonDTO.setNumOfLesson(lesson.getNumOfLesson());

        List<String> dates = new ArrayList<>();
        for (Integer week : lesson.getNumOfWeek()){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Calendar cal = Calendar.getInstance();
            cal.set(Calendar.WEEK_OF_YEAR, week + 35);
            cal.set(Calendar.DAY_OF_WEEK, lessonDTO.getDayOfWeek().getValue());
            dates.add(sdf.format(cal.getTime()));
        }
        lessonDTO.setDates(dates);

        return lessonDTO;
    }


    public static List<LessonDTO> toDto(List<Lesson> lessons){
        List<LessonDTO> lessonDTOs = new ArrayList<>();
        for (Lesson lesson : lessons){
            LessonDTO lessonDTO = toDto(lesson);
            lessonDTOs.add(lessonDTO);
        }
        return lessonDTOs;
    }
}
