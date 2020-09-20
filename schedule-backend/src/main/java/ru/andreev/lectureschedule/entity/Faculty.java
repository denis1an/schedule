package ru.andreev.lectureschedule.entity;

import ru.andreev.lectureschedule.enums.EFaculty;

import javax.persistence.*;
import java.util.Map;

@Entity
@Table(name = "faculty")
public class Faculty extends AbstractEntity {
    @Column
    private EFaculty eFaculty;

    @ElementCollection(fetch = FetchType.LAZY)
    private Map<String, String> groupsNum;

    private String number;

    public EFaculty getEFaculty() {
        return eFaculty;
    }

    public void setEFaculty(EFaculty eFaculty) {
        this.eFaculty = eFaculty;
    }

    public Map<String , String> getGroupsNum() {
        return groupsNum;
    }

    public void setGroupsNum(Map<String, String> groupsNum) {
        this.groupsNum = groupsNum;
    }

    public String  getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}

