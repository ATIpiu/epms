package daoTest;

import com.epms.dao.clientDao.ClientDao;
import com.epms.dao.commitLogDao.CommitLogDao;
import com.epms.dao.projectDao.ProjectDao;
import com.epms.entity.CommitLog;
import com.epms.entity.Project;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProjectDaoTest{
    @Test
    public void projectDao() {
        ApplicationContext ctx=new ClassPathXmlApplicationContext("epmsApplication.xml");
        ProjectDao projectDao= (ProjectDao) ctx.getBean("projectDao");
        Date t = new Date();
        long now = t.getTime();

//        List<Project> pro1 = projectDao.queryAllProjects();
//        for(Project p:pro1){
//            System.out.println(p);
//        }

//        Map<String,Object> m1 = new HashMap<String,Object>();
//        m1.put("pId",10001);
//        m1.put("cId",12345678);
//        Project pro2 = projectDao.queryProjectBypId(m1);
//        System.out.println(pro2);
//        List<Project> pro3 = projectDao.queryProjectBycId(m1);
//        for(Project p:pro3){
//            System.out.println(p);
//        }

        Timestamp end = new Timestamp(now);
        Timestamp create = Timestamp.valueOf("2020-12-12 21:21:21");
        Project newp = new Project(10001,"YangForTest",create,end,1234,10000001,10000001,"aaa",
                10000002,null,10000003,"ccc",0,0,"www.7k7k.com",500,200,400);
        //projectDao.insertIntoProject(newp);
        projectDao.updateProject(newp);

//        Map<String,Object> map = new HashMap<String, Object>();
//        map.put("pId",10002);
//        projectDao.deleteProjectBypId(map);
    }
}