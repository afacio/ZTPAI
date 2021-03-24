package ztpai.ztpai.models;

import java.time.LocalDate;
import java.time.LocalTime;


public class Template {

    private LocalDate createDate;
    private LocalTime createTime;
    private Long assignedBy;

    public Template() {
    }

    public Template(Long assignedBy) {
        this.createDate = LocalDate.now();
        this.createTime = LocalTime.now();
        this.assignedBy = assignedBy;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public LocalTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalTime createTime) {
        this.createTime = createTime;
    }

    public Long getAssignedBy() {
        return assignedBy;
    }

    public void setAssignedBy(Long assignedBy) {
        this.assignedBy = assignedBy;
    }
}