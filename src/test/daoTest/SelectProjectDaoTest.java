package daoTest;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.epms.dao.selectProjectDao.SelectProjectDao;
import com.epms.entity.SelectProject;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SelectProjectDaoTest{

    @Test
    public void selectprojectDaoTest() {
        ApplicationContext ctx=new ClassPathXmlApplicationContext("epmsApplication.xml");
        SelectProjectDao selectprojectDao= (SelectProjectDao) ctx.getBean("selectProjectDao");

//        List<SelectProject> sps = selectprojectDao.queryAllSelectProjects();
//        for (SelectProject sp:sps){
//            System.out.println(sp);
//        }

//        SelectProject s1 = selectprojectDao.querySelectProjectByspId(1001);
//        System.out.println(s1);

//        List<SelectProject> s2 = selectprojectDao.querySelectProjectBypId(10001);
//        List<SelectProject> s3 = selectprojectDao.querySelectProjectBysId(10000004);
//        for (SelectProject sp2:s2){
//            System.out.println(sp2);
//        }
//        for (SelectProject sp3:s3){
//            System.out.println(sp3);
//        }
//        SelectProject s4= new SelectProject(10000004,10001,1002);
//        selectprojectDao.insertIntoSelectProject(s4);

//        Map<String,Object> map = new HashMap<String, Object>();
//        map.put("spId",1002);
//        selectprojectDao.deleteSelectProjectByspId(map);

        SelectProject s5 = new SelectProject(10000003,10001,1001);
        selectprojectDao.updateSelectProject(s5);

    }
}