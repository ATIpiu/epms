package com.epms.service.impl;

import com.epms.dao.projectDao.ProjectDao;
import com.epms.dao.salaryDao.SalaryDao;
import com.epms.entity.Salary;
import com.epms.service.SalaryService;
import com.epms.utils.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SalaryServiceImpl implements SalaryService {
    @Autowired
    private SalaryDao salaryDao;
    @Autowired
    private ProjectDao projectDao;

    @Override
    public Result staffGetProjectBonus(int sId) {

        return null;
    }

    @Override
    public Result EvaluateQuality(List<Salary> salaryList) {
        try{
            String Failed = "";
            for (Salary s:salaryList
                 ) {
                s.setsStatus(1);
                if(salaryDao.updateSalary(s)==0) {
                        Failed += s.getsId().toString()+'\n';
                }
            }
            if(Failed != ""){
                return Result.ok().message("部分录入失败："+Failed);
            }
            else return Result.ok().message("录入成功");
        }catch (Exception e){
            return Result.error().message("录入失败："+e.toString());
        }
    }


}
