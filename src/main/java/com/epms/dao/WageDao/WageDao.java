package com.epms.dao.WageDao;

import com.epms.entity.Wage;
import org.apache.ibatis.annotations.Mapper;

import java.sql.Timestamp;
import java.util.List;

@Mapper
public interface WageDao {
    List<Wage> queryWageBysId(int sId);

    List<Wage> queryWageBysSalaryMonth(Timestamp salaryMonth);

    List<Wage> queryAllWage();

    int insertIntoWage(Wage wage);

    int updateWage(Wage wage);
}
