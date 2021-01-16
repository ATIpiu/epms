package com.epms.entity;

import java.sql.Timestamp;

public class Wage {
    private int sId;
    private Timestamp salaryMonth;
    private double projectBonus;
    private double baseSalary;
    private double checkOn;
    private double sum;

    public Wage(int sId, Timestamp salaryMonth, double projectBonus, double baseSalary, double checkOn) {
        this.sId = sId;
        this.salaryMonth = salaryMonth;
        this.projectBonus = projectBonus;
        this.baseSalary = baseSalary;
        this.checkOn = checkOn;
        this.sum=this.checkOn+this.baseSalary+this.projectBonus;
    }

    @Override
    public String toString() {
        return "Wage{" +
                "sId=" + sId +
                ", salaryMonth=" + salaryMonth +
                ", projectBonus=" + projectBonus +
                ", baseSalary=" + baseSalary +
                ", checkOn=" + checkOn +
                ", sum=" + sum +
                '}';
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public int getsId() {
        return sId;
    }

    public void setsId(int sId) {
        this.sId = sId;
    }

    public Timestamp getSalaryMonth() {
        return salaryMonth;
    }

    public void setSalaryMonth(Timestamp salaryMonth) {
        this.salaryMonth = salaryMonth;
    }

    public double getProjectBonus() {
        return projectBonus;
    }

    public void setProjectBonus(double projectBonus) {
        this.projectBonus = projectBonus;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public double getCheckOn() {
        return checkOn;
    }

    public void setCheckOn(double checkOn) {
        this.checkOn = checkOn;
    }

}
