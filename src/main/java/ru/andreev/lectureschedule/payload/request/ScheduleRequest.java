package ru.andreev.lectureschedule.payload.request;

import org.springframework.format.annotation.DateTimeFormat;
import ru.andreev.lectureschedule.DTO.GroupDTO;
import ru.andreev.lectureschedule.DTO.LessonDTO;

import javax.validation.constraints.NotBlank;
import java.util.Date;

public class ScheduleRequest {

    @NotBlank
    private GroupDTO groupDTO;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;

    private LessonDTO lesson;

    public GroupDTO getGroupDTO() {
        return groupDTO;
    }

    public void setGroupDTO(GroupDTO groupDTO) {
        this.groupDTO = groupDTO;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public LessonDTO getLesson() {
        return lesson;
    }

    public void setLesson(LessonDTO lesson) {
        this.lesson = lesson;
    }
}
