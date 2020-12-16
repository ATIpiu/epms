package com.epms.entity;

import java.sql.Date;

public class Salary {
    Integer s_sId;
    Integer s_pId;
    Float sQuality;
    Float sCheckIn;
    Date sSalaryTime;
    String sEvaluation;

    public Integer getS_sId() {
        return s_sId;
    }

    public void setS_sId(Integer s_sId) {
        this.s_sId = s_sId;
    }

    public Integer getS_pId() {
        return s_pId;
    }

    public void setS_pId(Integer s_pId) {
        this.s_pId = s_pId;
    }

    public Float getsQuality() {
        return sQuality;
    }

    public void setsQuality(Float sQuality) {
        this.sQuality = sQuality;
    }

    public Float getsCheckIn() {
        return sCheckIn;
    }

    public void setsCheckIn(Float sCheckIn) {
        this.sCheckIn = sCheckIn;
    }

    public Date getsSalaryTime() {
        return sSalaryTime;
    }

    public void setsSalaryTime(Date sSalaryTime) {
        this.sSalaryTime = sSalaryTime;
    }

    public String getsEvaluation() {
        return sEvaluation;
    }

    public void setsEvaluation(String sEvaluation) {
        this.sEvaluation = sEvaluation;
    }

    @Override
    public String toString() {
        return "Salary{" +
                "s_sId=" + s_sId +
                ", s_pId=" + s_pId +
                ", sQuality=" + sQuality +
                ", sCheckIn=" + sCheckIn +
                ", sSalaryTime=" + sSalaryTime +
                ", sEvaluation='" + sEvaluation + '\'' +
                '}';
    }
}
