package com.epms.entity;

public class Client {
    String cName;
    Integer cId;
    String cTel;
    String cPhoneNumber;
    String cQNumber;
    String cEmail;
    String cUsername;
    String cPwd;
    String cUnit;

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    public String getcTel() {
        return cTel;
    }

    public void setcTel(String cTel) {
        this.cTel = cTel;
    }

    public String getcPhoneNumber() {
        return cPhoneNumber;
    }

    public void setcPhoneNumber(String cPhoneNumber) {
        this.cPhoneNumber = cPhoneNumber;
    }

    public String getcQNumber() {
        return cQNumber;
    }

    public void setcQNumber(String cQNumber) {
        this.cQNumber = cQNumber;
    }

    public String getcEmail() {
        return cEmail;
    }

    public void setcEmail(String cEmail) {
        this.cEmail = cEmail;
    }

    public String getcUsername() {
        return cUsername;
    }

    public void setcUsername(String cUsername) {
        this.cUsername = cUsername;
    }

    public String getcPwd() {
        return cPwd;
    }

    public void setcPwd(String cPwd) {
        this.cPwd = cPwd;
    }

    public String getcUnit() {
        return cUnit;
    }

    public void setcUnit(String cUnit) {
        this.cUnit = cUnit;
    }

    @Override
    public String toString() {
        return "Client{" +
                "cName='" + cName + '\'' +
                ", cId=" + cId +
                ", cTel='" + cTel + '\'' +
                ", cPhoneNumber='" + cPhoneNumber + '\'' +
                ", cQNumber='" + cQNumber + '\'' +
                ", cEmail='" + cEmail + '\'' +
                ", cUsername='" + cUsername + '\'' +
                ", cPwd='" + cPwd + '\'' +
                ", cUnit='" + cUnit + '\'' +
                '}';
    }
}
