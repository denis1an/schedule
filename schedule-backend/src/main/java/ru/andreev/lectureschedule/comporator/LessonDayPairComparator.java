package ru.andreev.lectureschedule.comporator;

import ru.andreev.lectureschedule.entity.Lesson;

import java.util.Comparator;

public class LessonDayPairComparator implements Comparator<Lesson> {

    @Override
    public int compare(Lesson o1, Lesson o2) {
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
