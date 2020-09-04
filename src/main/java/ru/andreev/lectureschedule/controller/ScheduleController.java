package ru.andreev.lectureschedule.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.andreev.lectureschedule.DTO.LessonDTO;
import ru.andreev.lectureschedule.entity.Group;
import ru.andreev.lectureschedule.payload.request.ScheduleRequest;
import ru.andreev.lectureschedule.repository.GroupRepository;
import ru.andreev.lectureschedule.repository.LessonRepository;
import ru.andreev.lectureschedule.service.GroupService;
import ru.andreev.lectureschedule.service.LessonService;

import javax.validation.Valid;
import java.time.DayOfWeek;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(produces = "application/json", path = "/api/v.0/schedule")
public class ScheduleController {

    private final LessonService lessonService;

    private final GroupService groupService;

    public ScheduleController(LessonService lessonService, GroupService groupService) {
        this.lessonService = lessonService;
        this.groupService = groupService;
    }

    @GetMapping("/week")
    public List<LessonDTO> getScheduleForTheWeek(@RequestBody @Valid ScheduleRequest request){
        Optional<Group> optionalGroup = groupService.findByFacultyAndNum(
                request.getGroupDTO().getFaculty(),request.getGroupDTO().getNumOfGroup());
        List<LessonDTO> schedule = null;
        if(optionalGroup.isPresent()){
               schedule = lessonService.findForWeek(
                       getNumOfWeek(new Date()),optionalGroup.get().getId()
               );
        }
        return schedule;
    }

    @GetMapping("/day")
    public List<LessonDTO> getScheduleForTheDay(@RequestBody @Valid ScheduleRequest request) {
        Optional<Group> optionalGroup = groupService.findByFacultyAndNum(
                request.getGroupDTO().getFaculty(),request.getGroupDTO().getNumOfGroup());
        List<LessonDTO> schedule = null;
        if(optionalGroup.isPresent()){
            schedule = lessonService.findForDay(
                    getNumOfWeek(request.getDate()),getDayOfWeek(request.getDate()),optionalGroup.get().getId()
            );
        }
        return schedule;
    }

    private DayOfWeek getDayOfWeek(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return DayOfWeek.of(calendar.get(Calendar.DAY_OF_WEEK));
    }

    private int getNumOfWeek(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.WEEK_OF_YEAR) - 35;
    }
}


