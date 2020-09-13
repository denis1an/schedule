package ru.andreev.lectureschedule.mapper;

import ru.andreev.lectureschedule.DTO.LessonDTO;
import ru.andreev.lectureschedule.entity.Lesson;

import java.util.ArrayList;
import java.util.List;

public class LessonMapper {
    public static LessonDTO toDto(Lesson lesson){
        LessonDTO lessonDTO = new LessonDTO();
        lessonDTO.setName(lesson.getName());
        lessonDTO.setTeacher(lesson.getTeacher());
        lessonDTO.setType(lesson.getType());
        lessonDTO.setDayOfWeek(lesson.getDayOfWeek());
        lessonDTO.setAudience(lesson.getAudience());
        lessonDTO.setNumOfLesson(lesson.getNumOfLesson());
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
