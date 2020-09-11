package ru.andreev.lectureschedule.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.andreev.lectureschedule.DTO.LessonDTO;
import ru.andreev.lectureschedule.entity.Group;
import ru.andreev.lectureschedule.payload.request.ScheduleRequest;
import ru.andreev.lectureschedule.service.GroupService;
import ru.andreev.lectureschedule.service.LessonService;

import java.util.List;
import java.util.Optional;

@Controller
public class ScheduleController {

    private final LessonService lessonService;
    private final GroupService groupService;

    public ScheduleController(LessonService lessonService, GroupService groupService) {
        this.lessonService = lessonService;
        this.groupService = groupService;
    }

    @GetMapping
    public String schedulePage(Model model){
        model.addAttribute("groupRequest", new ScheduleRequest());
        return "schedule";
    }
    @PostMapping
    public String showSchedule(@ModelAttribute ScheduleRequest request, Model model){
        Optional<Group> optionalGroup = groupService
                .findByFacultyAndName(request.getGroupDTO().getFaculty(), request.getGroupDTO().getNumOfGroup());
        List<LessonDTO> schedule = null;
        if(optionalGroup.isPresent()){
            schedule = lessonService.findForDay(request.getDate(),optionalGroup.get().getId());
        }
        model.addAttribute("lessons", schedule);
        return "table";
    }
}
