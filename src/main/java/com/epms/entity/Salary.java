package com.epms.entity;

import java.sql.Time;
import java.sql.Timestamp;

public class Salary {
    Integer sId;
    Integer pId;
    Float sQuality;
    Float sCheckIn;
    Timestamp sSalaryTime;
    String sEvaluation;

    public Salary(Integer sId, Integer pId, Timestamp sSalaryTime, int sStatus) {
        this.sId = sId;
        this.pId = pId;
        this.sSalaryTime = sSalaryTime;
        this.sStatus = sStatus;
    }

    public Salary(Integer sId, Integer pId, Float sQuality, String sEvaluation, int sStatus) {
        this.sId = sId;
        this.pId = pId;
        this.sQuality = sQuality;
        this.sEvaluation = sEvaluation;
        this.sStatus = sStatus;
    }

    public int getsStatus() {
        return sStatus;
    }

    public void setsStatus(int sStatus) {
        this.sStatus = sStatus;
    }

    int sStatus;

    public Salary() {
    }

    public Salary(Integer sId, Integer pId, Float sQuality,
                  Float sCheckIn, Timestamp sSalaryTime, String sEvaluation) {
        this.sId = sId;
        this.pId = pId;
        this.sQuality = sQuality;
        this.sCheckIn = sCheckIn;
        this.sSalaryTime = sSalaryTime;
        this.sEvaluation = sEvaluation;
    }

    public Integer getsId() {
        return sId;
    }

    public void setsId(Integer sId) {
        this.sId = sId;
    }

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
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

    public Timestamp getsSalaryTime() {
        return sSalaryTime;
    }

    public void setsSalaryTime(Timestamp sSalaryTime) {
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
                "sId=" + sId +
                ", pId=" + pId +
                ", sQuality=" + sQuality +
                ", sCheckIn=" + sCheckIn +
                ", sSalaryTime=" + sSalaryTime +
                ", sEvaluation='" + sEvaluation + '\'' +
                '}';
    }
}
