package com.epms.entity;

public class SelectProject {
    Integer sId;
    Integer pId;
    Integer spId;

    public SelectProject() {
    }

    public SelectProject(Integer sId, Integer pId) {
        this.sId = sId;
        this.pId = pId;
    }

    public SelectProject(Integer sId, Integer pId, Integer spId) {
        this.sId = sId;
        this.pId = pId;
        this.spId = spId;
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

    public Integer getSpId() {
        return spId;
    }

    public void setSpId(Integer spId) {
        this.spId = spId;
    }

    @Override
    public String toString() {
        return "SelectProject{" +
                "sId=" + sId +
                ", pId=" + pId +
                ", spId=" + spId +
                '}';
    }
}
