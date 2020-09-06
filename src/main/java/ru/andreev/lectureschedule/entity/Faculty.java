package ru.andreev.lectureschedule.entity;

import ru.andreev.lectureschedule.enums.EFaculty;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Map;

@Entity
@Table(name = "faculty")
public class Faculty extends AbstractEntity {
    @Column
    private EFaculty eFaculty;

    @ElementCollection
    private Map<String, String> groupsNum;

    private int number;

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

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}

