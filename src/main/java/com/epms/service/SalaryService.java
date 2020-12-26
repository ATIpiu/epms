package com.epms.service;

import com.epms.entity.Salary;
import com.epms.utils.result.Result;

import java.util.List;

public interface SalaryService {
    Result staffGetProjectBonus(int sId);

    Result EvaluateQuality(List<Salary> salaryList);

}
