package ru.andreev.lectureschedule.payload.request;

import ru.andreev.lectureschedule.DTO.GroupDTO;

import javax.validation.constraints.NotBlank;
import java.util.Date;

public class ScheduleRequest {
    @NotBlank
    private GroupDTO groupDTO;

    private Date date;

    public GroupDTO getGroupDTO() {
        return groupDTO;
    }

    public void setGroupDTO(GroupDTO groupDTO) {
        this.groupDTO = groupDTO;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
