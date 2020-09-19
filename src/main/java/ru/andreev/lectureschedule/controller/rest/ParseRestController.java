package ru.andreev.lectureschedule.controller.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.andreev.lectureschedule.DTO.GroupDTO;
import ru.andreev.lectureschedule.entity.Faculty;
import ru.andreev.lectureschedule.entity.Group;
import ru.andreev.lectureschedule.entity.Lesson;
import ru.andreev.lectureschedule.mapper.GroupMapper;
import ru.andreev.lectureschedule.payload.request.GroupRequest;
import ru.andreev.lectureschedule.service.FacultyService;
import ru.andreev.lectureschedule.service.GroupService;
import ru.andreev.lectureschedule.service.LessonService;
import ru.andreev.lectureschedule.service.ParseService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(produces = "application/json", path = "/api/v.0/schedule/upload/")
public class ParseRestController {

    private final ParseService parseService;

    private final LessonService lessonService;

    private final FacultyService facultyService;

    private final GroupService groupService;

    public ParseRestController(ParseService parseService, LessonService lessonService, FacultyService facultyService, GroupService groupService) {
        this.parseService = parseService;
        this.lessonService = lessonService;
        this.facultyService = facultyService;
        this.groupService = groupService;
    }

    @GetMapping("/group")
    public GroupDTO loadGroup(@RequestBody @Valid GroupRequest request){
        Optional<Faculty> optionalFaculty = facultyService.
                findByEFaculty(request.getFaculty());
        Group group;
        if(optionalFaculty.isPresent()){
            Faculty faculty = optionalFaculty.get();

            String codeFaculty = faculty.getNumber();
            String codeGroup = faculty.getGroupsNum().get(request.getName());

            group = new Group();
            group.setName(request.getName());
            group.setCourse(request.getCourse());
            group.setEFaculty(request.getFaculty());

            List<Lesson> lessons = parseService.readSchedule(codeFaculty,codeGroup);
            lessons.forEach(lesson -> lesson.setGroup(group));
            lessonService.saveAll(lessons);

            group.setLessons(lessons);
            groupService.save(group);
        }else {
            return new GroupDTO();
        }
        return GroupMapper.toDto(group); //todo responseEntity
    }
}
