package daoTest;

import com.epms.dao.projectDao.ProjectDao;
import com.epms.dao.salaryDao.SalaryDao;
import com.epms.entity.Salary;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SalaryDaoTest{
    @Test
    public void salaryDaoTest(){
        ApplicationContext ctx=new ClassPathXmlApplicationContext("epmsApplication.xml");
        SalaryDao salaryDao= (SalaryDao) ctx.getBean("salaryDao");
        Date t = new Date();
        long now = t.getTime();

//        List<Salary> s1 = salaryDao.queryAllSalaries();
//        for(Salary s:s1){
//            System.out.println(s1);
//        }

//        Map<String,Object> map = new HashMap<String,Object>();
//        map.put("pId",10001);
//        map.put("sId",10000001);
//        List<Salary> s2 = salaryDao.querySalaryBypId(map);
//        System.out.println(s2);
//
//        List<Salary> s3 = salaryDao.querySalaryBysId(map);
//        System.out.println(s3);

        Timestamp t1 = Timestamp.valueOf("2020-12-02 21:33:05");
        Salary s4 = new Salary(10000003,10001,(float)0.10,(float)0.88,t1,null);
//        salaryDao.insertIntoSalary(s4);
        salaryDao.deleteSalary(s4);
//        salaryDao.updateSalary(s4);

    }
}
