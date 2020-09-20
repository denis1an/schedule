package ru.andreev.lectureschedule;

import org.apache.tomcat.jni.Time;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@SpringBootApplication
public class LectureScheduleApplication {

    public static void main(String[] args) {
        SpringApplication.run(LectureScheduleApplication.class, args);
    }

}
