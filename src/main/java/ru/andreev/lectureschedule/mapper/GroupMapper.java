package ru.andreev.lectureschedule.mapper;

import ru.andreev.lectureschedule.DTO.GroupDTO;
import ru.andreev.lectureschedule.entity.Group;

import java.util.ArrayList;
import java.util.List;

public class GroupMapper {

    public static GroupDTO toDto(Group group){
        GroupDTO groupDTO = new GroupDTO();
        groupDTO.setNumOfGroup(group.getName());
        groupDTO.setFaculty(group.getEFaculty());
        groupDTO.setCourse(group.getCourse());

        if(group.getLessons() != null){
            groupDTO.setScheduleExist(Boolean.TRUE);
        }else {
            groupDTO.setScheduleExist(Boolean.FALSE);
        }

        return groupDTO;
    }

    public static List<GroupDTO> toDto(List<Group> groups){
        List<GroupDTO> groupDTOs = new ArrayList<>();
        for (Group group : groups) {
            GroupDTO groupDTO = toDto(group);
            groupDTOs.add(groupDTO);
        }
        return groupDTOs;
    }
}
