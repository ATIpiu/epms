package com.epms.entity;

public class SelectProject {
    Integer sp_sId;
    Integer sp_pId;
    Integer spId;

    public Integer getSp_sId() {
        return sp_sId;
    }

    public void setSp_sId(Integer sp_sId) {
        this.sp_sId = sp_sId;
    }

    public Integer getSp_pId() {
        return sp_pId;
    }

    public void setSp_pId(Integer sp_pId) {
        this.sp_pId = sp_pId;
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
                "sp_sId=" + sp_sId +
                ", sp_pId=" + sp_pId +
                ", spId=" + spId +
                '}';
    }
}
