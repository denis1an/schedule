package ru.andreev.lectureschedule.service;

import org.springframework.stereotype.Service;
import ru.andreev.lectureschedule.DTO.GroupDTO;
import ru.andreev.lectureschedule.entity.Group;
import ru.andreev.lectureschedule.enums.Course;
import ru.andreev.lectureschedule.enums.Faculty;
import ru.andreev.lectureschedule.mapper.GroupMapper;
import ru.andreev.lectureschedule.repository.GroupRepository;

import java.util.List;
import java.util.Optional;

@Service
public class GroupService {

    private final GroupRepository groupRepository;

    public GroupService(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    public Optional<GroupDTO> findById(Long id){
        Optional<Group> optionalGroup = groupRepository.findById(id);
        return optionalGroup.map(GroupMapper::toDto);
    }

    public List<GroupDTO> findAll(){
        return GroupMapper.toDto(groupRepository.findAll());
    }

    public Optional<GroupDTO> findByFacultyAndNum(Faculty faculty, String numOfGroup){
        Optional<Group> optionalGroup = groupRepository
                .findByFacultyAndNumOfGroup(faculty,numOfGroup);
        return optionalGroup.map(GroupMapper::toDto);
    }

    public List<GroupDTO> findAllByCourseAndFaculty(Course course, Faculty faculty){
        return GroupMapper.toDto(groupRepository.findAllByCourseAndFaculty(course, faculty));
    }

    public List<GroupDTO> findAllByFaculty(Faculty faculty){
        return  GroupMapper.toDto(groupRepository.findAllByFaculty(faculty));
    }

    public Group save(Group group){
        return groupRepository.save(group);
    }

    public Group update(Group group){
        return groupRepository.save(group);
    }

    public void delete(Long id){
        groupRepository.deleteById(id);
    }
}
