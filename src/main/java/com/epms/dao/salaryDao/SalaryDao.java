package com.epms.dao.salaryDao;
import com.epms.entity.CommitLog;
import com.epms.entity.Salary;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;
@Mapper
public interface SalaryDao {
    /**
     * @param salary 参数为一条salary记录 null部分不填
     * @return int 若插入成功返回1，失败返回0；
     */
    int insertIntoSalary(Salary salary);

    /**
     * @param salary 参数为一条salary记录
     * @return int 若删除成功返回1，失败返回0；
     */
    int deleteSalary(Salary salary);

    /**
     * @param salary 参数为一条salary的记录
     * @return int 若更新成功返回1，失败返回0；
     */
    int updateSalary(Salary salary);

    /**
     * 获取salary记录信息；
     *
     * @return list<Salary> 根据员工sId查询工资(Salary)信息
     */
    List<Salary> querySalaryBysId(Map<String,Object> map);

    /**
     * 获取salary记录信息；
     *
     * @return list<Salary> 根据项目pId查询工资信息
     */
    List<Salary> querySalaryBypId(Map<String,Object> map);

    /**
     * 获取所有的Salary表信息；
     *
     * @return list<Salary> 所有的Salary信息
     */
    List<Salary> queryAllSalaries();

}
