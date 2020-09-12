package ru.andreev.lectureschedule.comporator;

import ru.andreev.lectureschedule.DTO.LessonDTO;
import java.util.Comparator;

public class LessonDtoDayPairComparator implements Comparator<LessonDTO> {

    @Override
    public int compare(LessonDTO o1, LessonDTO o2) {
        if(o1.getDayOfWeek().getValue() > o2.getDayOfWeek().getValue()){
            return 1;
        }
        if(o1.getDayOfWeek().getValue() == o2.getDayOfWeek().getValue() && o1.getNumOfLesson() > o2.getNumOfLesson()){
            return 1;
        }
        if(o1.getDayOfWeek().getValue() == o2.getDayOfWeek().getValue() && o1.getNumOfLesson() == o2.getNumOfLesson()){
            return 0;
        }
        return -1;
    }
}
