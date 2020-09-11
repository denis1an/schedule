package ru.andreev.lectureschedule.controller.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.andreev.lectureschedule.DTO.LessonDTO;
import ru.andreev.lectureschedule.entity.Group;
import ru.andreev.lectureschedule.payload.request.ScheduleRequest;
import ru.andreev.lectureschedule.service.GroupService;
import ru.andreev.lectureschedule.service.LessonService;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(produces = "application/json", path = "/api/v.0/schedule")
public class ScheduleRestController {

    private final LessonService lessonService;

    private final GroupService groupService;

    public ScheduleRestController(LessonService lessonService, GroupService groupService) {
        this.lessonService = lessonService;
        this.groupService = groupService;
    }

    @GetMapping("/week")
    public List<LessonDTO> getScheduleForTheWeek(@RequestBody @Valid ScheduleRequest request){
        Optional<Group> optionalGroup = groupService.findByFacultyAndName(
                request.getGroupDTO().getFaculty(),request.getGroupDTO().getNumOfGroup());
        List<LessonDTO> schedule = null;
        if(optionalGroup.isPresent()){
               schedule = lessonService.findForWeek(
                       new Date(),optionalGroup.get().getId()
               );
        }
        return schedule;
    }

    @GetMapping("/day")
    public List<LessonDTO> getScheduleForTheDay(@RequestBody @Valid ScheduleRequest request) {
        Optional<Group> optionalGroup = groupService.findByFacultyAndName(
                request.getGroupDTO().getFaculty(),request.getGroupDTO().getNumOfGroup());
        List<LessonDTO> schedule = null;
        if(optionalGroup.isPresent()){
            schedule = lessonService.findForDay(
                    request.getDate(),optionalGroup.get().getId()
            );
        }
        return schedule;
    }

}


