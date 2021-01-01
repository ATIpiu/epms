package com.epms.service.impl;

import com.epms.dao.salaryDao.SalaryDao;
import com.epms.dao.selectProjectDao.SelectProjectDao;
import com.epms.entity.Salary;
import com.epms.entity.SelectProject;
import com.epms.service.SelectProjectService;
import com.epms.utils.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class SelectProjectServiceImpl implements SelectProjectService {
    private final SelectProjectDao selectProjectDao;
    private final SalaryDao salaryDao;

    public SelectProjectServiceImpl(SelectProjectDao selectProjectDao, SalaryDao salaryDao) {
        this.selectProjectDao = selectProjectDao;
        this.salaryDao = salaryDao;
    }

    @Override
    public Result managerDistributeStaff(int pId, int[] sIds) {
        try {
            for (int s : sIds) {
                if (selectProjectDao.insertIntoSelectProject(new SelectProject(s, pId)) == 1) {
                    salaryDao.insertIntoSalary(new Salary(s, pId, new Timestamp(new java.util.Date().getTime()), 0));
                }
            }
            return Result.ok().message("分配员工成功");
        } catch (DuplicateKeyException e) {
            return Result.error().message("部分员工分配错误：员工已经分配给该项目！");
        } catch (DataIntegrityViolationException e) {
            return Result.error().message("部分员工编号错误：不存在对应员工");
        } catch (Exception e) {
            return Result.error().message("分配员工失败：" + e.toString());
        }
    }
}
