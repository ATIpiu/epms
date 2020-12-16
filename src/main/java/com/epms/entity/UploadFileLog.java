package com.epms.entity;

import java.sql.Date;

public class UploadFileLog {
    Integer u_sId;
    Integer u_pId;
    Date upLoadTime;
    String upLoadUrl;

    public Integer getU_sId() {
        return u_sId;
    }

    public void setU_sId(Integer u_sId) {
        this.u_sId = u_sId;
    }

    public Integer getU_pId() {
        return u_pId;
    }

    public void setU_pId(Integer u_pId) {
        this.u_pId = u_pId;
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
                "u_sId=" + u_sId +
                ", u_pId=" + u_pId +
                ", upLoadTime=" + upLoadTime +
                ", upLoadUrl='" + upLoadUrl + '\'' +
                '}';
    }
}
