package com.epms.service.impl;

import com.epms.dao.WageDao.WageDao;
import com.epms.dao.projectDao.ProjectDao;
import com.epms.dao.salaryDao.SalaryDao;
import com.epms.dao.staffDao.StaffDao;
import com.epms.entity.Salary;
import com.epms.entity.Staff;
import com.epms.entity.Wage;
import com.epms.service.WageService;
import com.epms.utils.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class WageServiceImpl implements WageService {
    private final WageDao wageDao;
    private final StaffDao staffDao;
    private final SalaryDao salaryDao;
    private final ProjectDao projectDao;

    public WageServiceImpl(WageDao wageDao, StaffDao staffDao, SalaryDao salaryDao, ProjectDao projectDao) {
        this.wageDao = wageDao;
        this.staffDao = staffDao;
        this.salaryDao = salaryDao;
        this.projectDao = projectDao;
    }

    @Override
    public Result staffGetOwnWage(int sId, int page, int pageSize) {
        try {
            List<Wage> wageList = wageDao.queryWageBysId(sId);
            List<Wage> results = new ArrayList<>();
            for (int i = (page - 1) * pageSize; i < page * pageSize && i < wageList.size(); i++) {            //分页
                results.add(wageList.get(i));
            }
            return Result.ok().data("wageList", results);
        } catch (Exception e) {
            return Result.error().message(e.toString());
        }
    }

    @Override
    public double staffGetProjectBonus(int sId) {
        List<Salary> salaryList=salaryDao.querySalaryBysId(sId);
        double bonus=0.0;
        for (Salary s :salaryList
        ) {
            if (s.getsStatus()==0){
                int type=staffDao.getType(sId);
                if(type==1||type==4||type==7){
                    bonus+=projectDao.queryProjectBypId(s.getpId()).getpModelWage()*s.getsQuality();
                }
                else if (type==2||type==5||type==8){
                    bonus+=projectDao.queryProjectBypId(s.getpId()).getpRenderWage()*s.getsQuality();
                }
                else if (type==3||type==6||type==9){
                    bonus+=projectDao.queryProjectBypId(s.getpId()).getpAfterWage()*s.getsQuality();
                }
                s.setsStatus(1);
                salaryDao.updateSalary(s);
            }
        }
        return bonus;
    }
    @Override
    public Result generateMonthlyWage() {
        List<Staff> staffList=staffDao.queryAllStaffs();
        Date date=new java.sql.Date(System.currentTimeMillis());
        for (Staff staff:staffList
             ) {
            System.out.println(staff.getsName());
            double bonus=this.staffGetProjectBonus(staff.getsId());
            double base=staffDao.getBaseWage(staff.getsId());
            double checkOn=100.0;
            Wage wage=new Wage(staff.getsId(),date,bonus,base, checkOn);
            wageDao.insertIntoWage(wage);
        }
        return Result.ok();
    }

    @Override
    public String exportCsv(String url) {
        try{
            staffDao.generateFile(url);
            return url;
        }catch (Exception e){
            System.err.println(e.toString());
            return null;
        }
    }
    @Override
    public Result getAllWage(int page, int pageSize) {
        try {
            List<Wage> wageList=wageDao.queryAllWage();
            List<Wage> results = new ArrayList<>();
            for(int i=(page-1)*pageSize;i<page*pageSize&&i<wageList.size();i++){
                results.add(wageList.get(i));
            }
            return Result.ok().message("查询成功").data("wageList",results);
        }
        catch (Exception e){
            System.err.println(e.toString());
            return Result.error().message(e.toString());
        }
    }



    @Override
    public Result updateWage(Wage wage) {
        try{
            wageDao.updateWage(wage);
            return Result.ok();
        }catch (Exception e){
            System.err.println(e.toString());
            return Result.error().message(e.toString());
        }

    }
}
