package ru.andreev.lectureschedule.mapper;

import ru.andreev.lectureschedule.DTO.LessonDTO;
import ru.andreev.lectureschedule.entity.Lesson;
import ru.andreev.lectureschedule.enums.TypeOfLesson;

import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class LessonMapper {
    public static LessonDTO toDto(Lesson lesson){
        LessonDTO lessonDTO = new LessonDTO();
        lessonDTO.setName(lesson.getName());
        lessonDTO.setTeacher(lesson.getTeacher());
        lessonDTO.setType(setTypeOfLesson(lesson.getType()));

        lessonDTO.setDayOfWeek(setDayOfWeek(lesson.getDayOfWeek()));

        lessonDTO.setAudience(lesson.getAudience());
        lessonDTO.setNumOfLesson(lesson.getNumOfLesson());

        List<String> dates = new ArrayList<>();
        for (Integer week : lesson.getNumOfWeek()){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Calendar cal = Calendar.getInstance();
            cal.set(Calendar.WEEK_OF_YEAR, week + 35);
            cal.set(Calendar.DAY_OF_WEEK, lesson.getDayOfWeek().getValue());
            dates.add(sdf.format(cal.getTime()));
        }
        lessonDTO.setDates(dates);

        return lessonDTO;
    }


    private static String setTypeOfLesson(TypeOfLesson type){
        String typeOfLesson;
        switch (type){
            case LECTURE:
                typeOfLesson = "Лекция";
                break;
            case LABORATORY_WORK:
                typeOfLesson = "Лабораторная работа";
                break;
            case PRACTICAL_LESSON:
                typeOfLesson = "Практическая работа";
                break;
            default:
                typeOfLesson = "";
        }
        return typeOfLesson;
    }

    private static String setDayOfWeek(DayOfWeek day){
        String dayOfWeek;
        switch (day){
            case MONDAY:
                dayOfWeek = "Понедельник";
                break;
            case TUESDAY:
                dayOfWeek = "Вторник";
                break;
            case WEDNESDAY:
                dayOfWeek = "Среда";
                break;
            case THURSDAY:
                dayOfWeek = "Четврег";
                break;
            case FRIDAY:
                dayOfWeek = "Пятница";
                break;
            case SUNDAY:
                dayOfWeek = "Суббота";
                break;
            default:
                dayOfWeek = "Воскресенье";
        }
        return dayOfWeek;
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
