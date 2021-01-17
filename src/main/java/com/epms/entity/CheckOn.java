package com.epms.entity;

import io.swagger.models.auth.In;

import java.sql.Date;
import java.sql.Timestamp;

public class CheckOn {
    String loginIp;
    Integer sId;
    Double workTime;
    Date loginDate;

    public CheckOn(String loginIp, Integer sId, Double workTime, Date loginDate) {
        this.loginIp = loginIp;
        this.sId = sId;
        this.workTime = workTime;
        this.loginDate = loginDate;
    }

    public CheckOn() {
    }

    @Override
    public String toString() {
        return "CheckOn{" +
                "loginIp='" + loginIp + '\'' +
                ", sId=" + sId +
                ", workTime=" + workTime +
                ", loginDate=" + loginDate +
                '}';
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    public Integer getsId() {
        return sId;
    }

    public void setsId(Integer sId) {
        this.sId = sId;
    }

    public Double getWorkTime() {
        return workTime;
    }

    public void setWorkTime(Double workTime) {
        this.workTime = workTime;
    }

    public Date getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }
}
