package com.epms.entity;

import java.sql.Date;

public class CommitLog {
    Integer c_sId;
    Integer c_pId;
    Date cCreateTime;
    Integer c_sType;
    String cFeedback;
    Integer cResponseType;

    public Integer getC_sId() {
        return c_sId;
    }

    public void setC_sId(Integer c_sId) {
        this.c_sId = c_sId;
    }

    public Integer getC_pId() {
        return c_pId;
    }

    public void setC_pId(Integer c_pId) {
        this.c_pId = c_pId;
    }

    public Date getcCreateTime() {
        return cCreateTime;
    }

    public void setcCreateTime(Date cCreateTime) {
        this.cCreateTime = cCreateTime;
    }

    public Integer getC_sType() {
        return c_sType;
    }

    public void setC_sType(Integer c_sType) {
        this.c_sType = c_sType;
    }

    public String getcFeedback() {
        return cFeedback;
    }

    public void setcFeedback(String cFeedback) {
        this.cFeedback = cFeedback;
    }

    public Integer getcResponseType() {
        return cResponseType;
    }

    public void setcResponseType(Integer cResponseType) {
        this.cResponseType = cResponseType;
    }

    @Override
    public String toString() {
        return "CommitLog{" +
                "c_sId=" + c_sId +
                ", c_pId=" + c_pId +
                ", cCreateTime=" + cCreateTime +
                ", c_sType=" + c_sType +
                ", cFeedback='" + cFeedback + '\'' +
                ", cResponseType=" + cResponseType +
                '}';
    }
}
