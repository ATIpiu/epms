package com.epms.entity;

import java.sql.Time;
import java.sql.Timestamp;

public class UploadFileLog {
    Integer sId;
    Integer pId;
    Timestamp upLoadTime;
    String upLoadUrl;

    public UploadFileLog() {
    }

    public UploadFileLog(Integer sId, Integer pId, Timestamp upLoadTime, String upLoadUrl) {
        this.sId = sId;
        this.pId = pId;
        this.upLoadTime = upLoadTime;
        this.upLoadUrl = upLoadUrl;
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

    public Timestamp getUpLoadTime() {
        return upLoadTime;
    }

    public void setUpLoadTime(Timestamp upLoadTime) {
        this.upLoadTime = upLoadTime;
    }

    public String getUpLoadUrl() {
        return upLoadUrl;
    }

    public void setUpLoadUrl(String upLoadUrl) {
        this.upLoadUrl = upLoadUrl;
    }

    @Override
    public String toString() {
        return "UploadFileLog{" +
                "sId=" + sId +
                ", pId=" + pId +
                ", upLoadTime=" + upLoadTime +
                ", upLoadUrl='" + upLoadUrl + '\'' +
                '}';
    }
}
