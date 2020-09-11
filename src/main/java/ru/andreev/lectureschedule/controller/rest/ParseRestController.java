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
    public GroupDTO parseGroup(@RequestBody @Valid GroupRequest request){
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

    /*
    *
    * ISIT - 50005, IST-922 - 54214
    *
    @GetMapping
    public String test(){
        List<Lesson> lessons = parseService.readSchedule("50005","54214" );
        lessonService.saveAll(lessons);

        return "test";
    }*/

   /* @GetMapping
    public String test(){

        Faculty faculty1 = parseService.readGroupsOfFaculty("ИСИТ,50005;54426,ИСТ-011;54427,ИСТ-012;54428,ИСТ-013;54671,ИСТ-014;" +
                "54423,ИСТ-021;54424,ИСТ-022;54425,ИСТ-023;54429,ИСТ-031;54430,ИСТ-032;54431,ИСТ-033;54433,ИСТ-041;54434,ИСТ-042;54432,ИСТ-051;" +
                "54672,ИСТ-052;53330,ИСТ-711;53331,ИСТ-712;54242,ИСТ-713;53332,ИСТ-721;53333,ИСТ-722;53334,ИСТ-731;53336,ИСТ-741;53539,ИСТ-742;53337,ИСТ-751;" +
                "53808,ИСТ-811;53809,ИСТ-812;53810,ИСТ-813;53811,ИСТ-821;53812,ИСТ-822;53813,ИСТ-831;53814,ИСТ-832;54040,ИСТ-833;53815,ИСТ-841;53816,ИСТ-842;" +
                "53817,ИСТ-851;54210,ИСТ-911;54211,ИСТ-912;54212,ИСТ-913;54213,ИСТ-921;54214,ИСТ-922;54215,ИСТ-923;54216,ИСТ-931;54217,ИСТ-932;54218,ИСТ-933;" +
                "54221,ИСТ-941;54222,ИСТ-942;54219,ИСТ-951;");

        facultyService.save(faculty1);


        Faculty faculty2 = parseService.readGroupsOfFaculty("ИКСС,50029;54528,ИБС-01;54529,ИБС-02;54670,ИБС-03;53776,ИБС-81;54119,ИБС-91;54288,ИБС-92;54544,ИКБ-01;54545,ИКБ-02;54546,ИКБ-03;54547,ИКБ-04;54548,ИКБ-05;54549,ИКБ-06;53292,ИКБ-71;53293,ИКБ-72;53409,ИКБ-73;53764,ИКБ-81;53765,ИКБ-82;53766,ИКБ-83;53767,ИКБ-84;54089,ИКБ-91;54090,ИКБ-92;54091,ИКБ-93;54092,ИКБ-94;54093,ИКБ-95;54557,ИКВТ-01;54556,ИКВТ-02;54668,ИКВТ-03;53300,ИКВТ-71;53773,ИКВТ-81;53774,ИКВТ-82;54079,ИКВТ-91;54081,ИКВТ-92;54550,ИКПИ-01;" +
                "54551,ИКПИ-02;54552,ИКПИ-03;54553,ИКПИ-04;54554,ИКПИ-05;54555,ИКПИ-06;54669,ИКПИ-07;53296,ИКПИ-71;53297,ИКПИ-72;53298,ИКПИ-73;53299,ИКПИ-74;53768,ИКПИ-81;53769,ИКПИ-82;53770,ИКПИ-83;" +
                "53771,ИКПИ-84;53772,ИКПИ-85;54083,ИКПИ-91;54084,ИКПИ-92;54085,ИКПИ-93;54086,ИКПИ-94;54087,ИКПИ-95;54088,ИКПИ-96;54534,ИКТ-01;54535,ИКТ-02;54536,ИКТ-03;54537,ИКТ-04;54541,ИКТ-05;54542,ИКТ-06;" +
                "54543,ИКТ-07;54538,ИКТ-08;54539,ИКТ-09;54540,ИКТ-10;54578,ИКТВ-03;54579,ИКТВ-04;54252,ИКТВ-61;54253,ИКТВ-62;54254,ИКТВ-63;54255,ИКТВ-64;54261,ИКТВ-71;54262,ИКТВ-72;54270,ИКТВ-83;54271,ИКТВ-84;54115,ИКТВ-93;54116,ИКТВ-94;54107,ИКТЗ-73;54108,ИКТЗ-74;54616,ИКТЗ-83;54617,ИКТЗ-84;54624,ИКТЗ-93;54625,ИКТЗ-94;54113,ИКТК-75;54114,ИКТК-76;54622,ИКТК-85;54623,ИКТК-86;54630,ИКТК-95;54631,ИКТК-96;54109,ИКТО-71;54110,ИКТО-72;54618,ИКТО-81;54619,ИКТО-82;54626,ИКТО-91;54627,ИКТО-92;54531,ИКТС-01;54532,ИКТС-02;54450,ИКТС-03;54251,ИКТС-61;54259,ИКТС-71;54260,ИКТС-72;54266,ИКТС-81;54267,ИКТС-82;54117,ИКТС-91;54118,ИКТС-92;54111,ИКТУ-77;54112,ИКТУ-78;54620,ИКТУ-87;54621,ИКТУ-88;54628,ИКТУ-97;54629,ИКТУ-98;54533,ИКФ-01;53295,ИКФ-71;53763,ИКФ-81;54105,ИКФ-91;");

        facultyService.save(faculty2);

        return "test";
    }*/

}
