package com.epms.entity;

import java.sql.Date;

public class CommitLog {
    Integer sId;
    Integer pId;
    Date cCreateTime;
    Integer sType;
    String cFeedback;
    Integer cResponseType;

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

    public Date getcCreateTime() {
        return cCreateTime;
    }

    public void setcCreateTime(Date cCreateTime) {
        this.cCreateTime = cCreateTime;
    }

    public Integer getsType() {
        return sType;
    }

    public void setsType(Integer sType) {
        this.sType = sType;
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
                ", sType=" + sType +
                ", cFeedback='" + cFeedback + '\'' +
                ", cResponseType=" + cResponseType +
                '}';
    }
}
