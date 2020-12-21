package com.epms.entity;

public class Staff {
    String sName;
    Integer sId;
    Integer sType;
    String sSex;
    String sIdNumber;
    String sAddress;
    String sTel;
    String sUsername;
    String sPwd;

    public Staff(){}
    public Staff(String sName, Integer sId, Integer sType, String sSex,
                 String sIdNumber, String sAddress, String sTel,
                 String sUsername, String sPwd) {
        this.sName = sName;
        this.sId = sId;
        this.sType = sType;
        this.sSex = sSex;
        this.sIdNumber = sIdNumber;
        this.sAddress = sAddress;
        this.sTel = sTel;
        this.sUsername = sUsername;
        this.sPwd = sPwd;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public Integer getsId() {
        return sId;
    }

    public void setsId(Integer sId) {
        this.sId = sId;
    }

    public Integer getsType() {
        return sType;
    }

    public void setsType(Integer sType) {
        this.sType = sType;
    }

    public String getsSex() {
        return sSex;
    }

    public void setsSex(String sSex) {
        this.sSex = sSex;
    }

    public String getsIdNumber() {
        return sIdNumber;
    }

    public void setsIdNumber(String sIdNumber) {
        this.sIdNumber = sIdNumber;
    }

    public String getsAddress() {
        return sAddress;
    }

    public void setsAddress(String sAddress) {
        this.sAddress = sAddress;
    }

    public String getsTel() {
        return sTel;
    }

    public void setsTel(String sTel) {
        this.sTel = sTel;
    }

    public String getsUsername() {
        return sUsername;
    }

    public void setsUsername(String sUsername) {
        this.sUsername = sUsername;
    }

    public String getsPwd() {
        return sPwd;
    }

    public void setsPwd(String sPwd) {
        this.sPwd = sPwd;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "sName='" + sName + '\'' +
                ", sId=" + sId +
                ", sType=" + sType +
                ", sSex='" + sSex + '\'' +
                ", sIdNumber='" + sIdNumber + '\'' +
                ", sAddress='" + sAddress + '\'' +
                ", sTel='" + sTel + '\'' +
                ", sUsername='" + sUsername + '\'' +
                '}';
    }
}
