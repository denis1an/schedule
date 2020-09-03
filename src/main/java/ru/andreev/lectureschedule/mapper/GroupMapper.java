package ru.andreev.lectureschedule.mapper;

import ru.andreev.lectureschedule.DTO.GroupDTO;
import ru.andreev.lectureschedule.entity.Group;

public class GroupMapper {

    public static GroupDTO toDto(Group group){
        GroupDTO groupDTO = new GroupDTO();
        groupDTO.setNumOfGroup(group.getNumOfGroup());
        groupDTO.setDepartment(group.getDepartment());
        groupDTO.setCourse(group.getCourse());

        if(group.getLessons() == null){
            groupDTO.setScheduleExist(Boolean.FALSE);
        } else {
            groupDTO.setScheduleExist(Boolean.TRUE);
        }

        return groupDTO;
    }
}
