package com.epms.service;

import com.epms.entity.Salary;
import com.epms.utils.result.Result;

import java.util.List;

public interface SalaryService {
    Result staffGetProjectBonus(int sId);

    /**
     * 主管给自己的项目员工打分，或者管理员给主管项目完成情况打分
     * @param salaryList
     * @return
     */
    Result EvaluateQuality(List<Salary> salaryList);

    /**
     * 根据主管类型和项目Id获取薪水记录
     * @param type
     * @param pId
     * @return
     */
    Result ManagerGetSalaryList(int type,int pId,int page,int pageSize);

    /**
     * 导出Csv文件
     * @return
     */
    String exportCsv(String url);
}
