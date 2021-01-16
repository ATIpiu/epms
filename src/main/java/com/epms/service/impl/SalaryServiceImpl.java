package com.epms.service.impl;

import com.epms.dao.projectDao.ProjectDao;
import com.epms.dao.salaryDao.SalaryDao;
import com.epms.dao.staffDao.StaffDao;
import com.epms.entity.Salary;
import com.epms.entity.UploadFileLog;
import com.epms.service.SalaryService;
import com.epms.utils.result.Result;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class SalaryServiceImpl implements SalaryService {
    private final SalaryDao salaryDao;
    private final ProjectDao projectDao;
    private final StaffDao staffDao;

    public SalaryServiceImpl(SalaryDao salaryDao, ProjectDao projectDao, StaffDao staffDao) {
        this.salaryDao = salaryDao;
        this.projectDao = projectDao;
        this.staffDao = staffDao;
    }


    @Override
    public Result EvaluateQuality(List<Salary> salaryList) {
        try{
            String Failed = "";
            for (Salary s:salaryList
                 ) {
                s.setsStatus(1);
                if(salaryDao.insertIntoSalary(s)==0) {
                        Failed += s.getsId().toString()+'\n';
                }
            }
            if(Failed != ""){
                return Result.ok().message("部分录入失败："+Failed);
            }
            else return Result.ok().message("录入成功");
        }catch (DuplicateKeyException e){
            return Result.error().message("录入失败：部分货全部员工已录入！！！");
        }
        catch (Exception e){
            System.err.println(e);
            return Result.error().message("录入失败："+e.toString());
        }
    }

    @Override
    public Result ManagerGetSalaryList(int type, int pId,int page,int pageSize) {
       try {
           List<Salary> salaryList = salaryDao.querySalaryBypId(pId);
           List<Salary> result = new ArrayList<Salary>();
           for (Salary s : salaryList
           ) {
               if (staffDao.getType(s.getsId()) == type)
                   result.add(s);
           }
           List<Salary> results1 = new ArrayList<Salary>();
           for(int i=(page-1)*pageSize;i<page*pageSize&&i<result.size();i++){
               results1.add(result.get(i));
           }
           return Result.ok().data("salaryList", results1);
       }catch (Exception e){
           return Result.error().message("查询失败！！" +e.toString());
       }
    }
    @Override
    public String exportCsv(String url) {
        try{
            salaryDao.generateFile(url);
            return url;
        }catch (Exception e){
            System.err.println(e.toString());
            return null;
        }
    }

    @Override
    public Result getAllSalary(int page, int pageSize) {
        try {
            List<Salary> salaryList=salaryDao.queryAllSalaries();
            List<Salary> results = new ArrayList<>();
            for(int i=(page-1)*pageSize;i<page*pageSize&&i<salaryList.size();i++){
                results.add(salaryList.get(i));
            }
            return Result.ok().message("查询成功").data("salaryList",results);
        }
        catch (Exception e){
            System.err.println(e.toString());
            return Result.error().message(e.toString());
        }
    }



    @Override
    public Result updateSalary(Salary salary) {
        try{
            salaryDao.updateSalary(salary);
            return Result.ok();
        }catch (Exception e){
            System.err.println(e.toString());
            return Result.error().message(e.toString());
        }

    }

}
