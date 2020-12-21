package com.epms.entity;

import java.sql.Time;
import java.sql.Time;
import java.sql.Timestamp;

public class CommitLog {
    Integer sId;
    Integer pId;
    Timestamp cCreateTime;
    Integer cType;
    String cFeedback;
    Integer cResponseType;

    public CommitLog(){}

    public CommitLog(Integer sId, Integer pId, Timestamp cCreateTime, Integer cType, String cFeedback, Integer cResponseType) {
        this.sId = sId;
        this.pId = pId;
        this.cCreateTime = cCreateTime;
        this.cType = cType;
        this.cFeedback = cFeedback;
        this.cResponseType = cResponseType;
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

    public Timestamp getcCreateTime() {
        return cCreateTime;
    }

    public void setcCreateTime(Timestamp cCreateTime) {
        this.cCreateTime = cCreateTime;
    }

    public Integer getcType() {
        return cType;
    }

    public void setcType(Integer cType) {
        this.cType = cType;
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
                "sId=" + sId +
                ", pId=" + pId +
                ", cCreateTime=" + cCreateTime +
                ", cType=" + cType +
                ", cFeedback='" + cFeedback + '\'' +
                ", cResponseType=" + cResponseType +
                '}';
    }
}
