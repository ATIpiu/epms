package com.epms.entity;

import java.sql.Date;

public class Project {
    Integer pId;
    String pName;
    Date pCreateDate;
    Date pEndDate;
    Integer pType;
    Integer p_cId;
    Integer pModelManagerId;
    String pModelStaff;
    Integer pRenderManagerId;
    String pRenderStaff;
    Integer pAfterManagerId;
    String pAfterStaff;
    Integer pPeriodStatus;
    Integer pProjectStatus;
    String pFileUrl;
    Integer pModelWage;
    Integer pRenderWage;
    Integer pAfterWage;

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public Date getpCreateDate() {
        return pCreateDate;
    }

    public void setpCreateDate(Date pCreateDate) {
        this.pCreateDate = pCreateDate;
    }

    public Date getpEndDate() {
        return pEndDate;
    }

    public void setpEndDate(Date pEndDate) {
        this.pEndDate = pEndDate;
    }

    public Integer getpType() {
        return pType;
    }

    public void setpType(Integer pType) {
        this.pType = pType;
    }

    public Integer getP_cId() {
        return p_cId;
    }

    public void setP_cId(Integer p_cId) {
        this.p_cId = p_cId;
    }

    public Integer getpModelManagerId() {
        return pModelManagerId;
    }

    public void setpModelManagerId(Integer pModelManagerId) {
        this.pModelManagerId = pModelManagerId;
    }

    public String getpModelStaff() {
        return pModelStaff;
    }

    public void setpModelStaff(String pModelStaff) {
        this.pModelStaff = pModelStaff;
    }

    public Integer getpRenderManagerId() {
        return pRenderManagerId;
    }

    public void setpRenderManagerId(Integer pRenderManagerId) {
        this.pRenderManagerId = pRenderManagerId;
    }

    public String getpRenderStaff() {
        return pRenderStaff;
    }

    public void setpRenderStaff(String pRenderStaff) {
        this.pRenderStaff = pRenderStaff;
    }

    public Integer getpAfterManagerId() {
        return pAfterManagerId;
    }

    public void setpAfterManagerId(Integer pAfterManagerId) {
        this.pAfterManagerId = pAfterManagerId;
    }

    public String getpAfterStaff() {
        return pAfterStaff;
    }

    public void setpAfterStaff(String pAfterStaff) {
        this.pAfterStaff = pAfterStaff;
    }

    public Integer getpPeriodStatus() {
        return pPeriodStatus;
    }

    public void setpPeriodStatus(Integer pPeriodStatus) {
        this.pPeriodStatus = pPeriodStatus;
    }

    public Integer getpProjectStatus() {
        return pProjectStatus;
    }

    public void setpProjectStatus(Integer pProjectStatus) {
        this.pProjectStatus = pProjectStatus;
    }

    public String getpFileUrl() {
        return pFileUrl;
    }

    public void setpFileUrl(String pFileUrl) {
        this.pFileUrl = pFileUrl;
    }

    public Integer getpModelWage() {
        return pModelWage;
    }

    public void setpModelWage(Integer pModelWage) {
        this.pModelWage = pModelWage;
    }

    public Integer getpRenderWage() {
        return pRenderWage;
    }

    public void setpRenderWage(Integer pRenderWage) {
        this.pRenderWage = pRenderWage;
    }

    public Integer getpAfterWage() {
        return pAfterWage;
    }

    public void setpAfterWage(Integer pAfterWage) {
        this.pAfterWage = pAfterWage;
    }

    @Override
    public String toString() {
        return "Project{" +
                "pId=" + pId +
                ", pName='" + pName + '\'' +
                ", pCreateDate=" + pCreateDate +
                ", pEndDate=" + pEndDate +
                ", pType=" + pType +
                ", p_cId=" + p_cId +
                ", pModelManagerId=" + pModelManagerId +
                ", pModelStaff='" + pModelStaff + '\'' +
                ", pRenderManagerId=" + pRenderManagerId +
                ", pRenderStaff='" + pRenderStaff + '\'' +
                ", pAfterManagerId=" + pAfterManagerId +
                ", pAfterStaff='" + pAfterStaff + '\'' +
                ", pPeriodStatus=" + pPeriodStatus +
                ", pProjectStatus=" + pProjectStatus +
                ", pFileUrl='" + pFileUrl + '\'' +
                ", pModelWage=" + pModelWage +
                ", pRenderWage=" + pRenderWage +
                ", pAfterWage=" + pAfterWage +
                '}';
    }
}