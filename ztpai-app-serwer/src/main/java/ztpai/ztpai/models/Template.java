package ztpai.ztpai.models;

import java.time.LocalDate;
import java.time.LocalTime;


public class Template {

    private LocalDate createDate;
    private LocalTime createTime;

    public Template() {
        this.createDate = LocalDate.now();
        this.createTime = LocalTime.now();
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


}