package com.epms.service;

import com.epms.entity.Salary;
import com.epms.entity.Wage;
import com.epms.utils.result.Result;

import java.sql.Timestamp;

public interface WageService {
    double staffGetProjectBonus(int sId);

    /**
     * 员工获取自己的工资记录；
     * @param sId
     * @param page
     * @param pageSize
     * @return
     */
    Result staffGetOwnWage(int sId,int page,int pageSize);

    /**
     * 每个月定时生成工资；
     * @return
     */
    Result generateMonthlyWage();


    /**
     * 导出Csv文件
     * @return
     */
    String exportCsv(String url);

    /**
     * 获取所有的工资记录
     * @param page
     * @param pageSize
     * @return
     */
    Result getAllWage(int page,int pageSize);

    /**
     * 修改工资记录
     * @return
     */
    Result updateWage(Wage wage);
}
