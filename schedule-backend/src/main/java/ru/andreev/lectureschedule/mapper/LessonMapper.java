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

    private final static String TIME_START_FIRST_PAIR = "9:00";
    private final static String TIME_END_FIRST_PAIR = "10:35";
    private final static String TIME_START_SECOND_PAIR = "10:45";
    private final static String TIME_END_SECOND_PAIR = "12:20";
    private final static String TIME_START_THIRD_PAIR = "13:00";
    private final static String TIME_END_THIRD_PAIR = "14:35";
    private final static String TIME_START_FOURTH_PAIR = "14:45";
    private final static String TIME_END_FOURTH_PAIR = "16:20";
    private final static String TIME_START_FIFTH_PAIR = "16:30";
    private final static String TIME_END_FIFTH_PAIR = "18:05";
    private final static String TIME_START_SIXTH_PAIR = "18:15";
    private final static String TIME_END_SIXTH_PAIR = "19:50";
    private final static String TIME_F_START_FOURTH_PAIR = "13:30";
    private final static String TIME_F_END_FOURTH_PAIR = "15:00";

    public static LessonDTO toDto(Lesson lesson){
        LessonDTO lessonDTO = new LessonDTO();
        lessonDTO.setName(lesson.getName());
        lessonDTO.setTeacher(lesson.getTeacher());
        lessonDTO.setType(setTypeOfLesson(lesson.getType()));
        lessonDTO.setDayOfWeek(setDayOfWeek(lesson.getDayOfWeek()));
        lessonDTO.setAudience(lesson.getAudience());
        lessonDTO.setNumOfLesson(lesson.getNumOfLesson());
        setTimeOfLesson(lessonDTO,lesson);

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


    private static void setTimeOfLesson(LessonDTO lessonDTO, Lesson lesson){
        switch (lesson.getNumOfLesson()){
            case 1:
                lessonDTO.setStartOfLesson(TIME_START_FIRST_PAIR);
                lessonDTO.setEndOfLesson(TIME_END_FIRST_PAIR);
                break;
            case 2:
                lessonDTO.setStartOfLesson(TIME_START_SECOND_PAIR);
                lessonDTO.setEndOfLesson(TIME_END_SECOND_PAIR);
                break;
            case 3:
                lessonDTO.setStartOfLesson(TIME_START_THIRD_PAIR);
                lessonDTO.setEndOfLesson(TIME_END_THIRD_PAIR);
                break;
            case 4:
                lessonDTO.setStartOfLesson(TIME_START_FOURTH_PAIR);
                lessonDTO.setEndOfLesson(TIME_END_FOURTH_PAIR);
                break;
            case 5:
                lessonDTO.setStartOfLesson(TIME_START_FIFTH_PAIR);
                lessonDTO.setEndOfLesson(TIME_END_FIFTH_PAIR);
                break;
            case 6:
                lessonDTO.setStartOfLesson(TIME_START_SIXTH_PAIR);
                lessonDTO.setEndOfLesson(TIME_END_SIXTH_PAIR);
                break;
            case 85:
                lessonDTO.setStartOfLesson(TIME_F_START_FOURTH_PAIR);
                lessonDTO.setEndOfLesson(TIME_F_END_FOURTH_PAIR);
                break;
        }

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
