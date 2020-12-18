package com.epms.entity;

import java.sql.Date;

public class UploadFileLog {
    Integer sId;
    Integer pId;
    Date upLoadTime;
    String upLoadUrl;

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

    public Date getUpLoadTime() {
        return upLoadTime;
    }

    public void setUpLoadTime(Date upLoadTime) {
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
