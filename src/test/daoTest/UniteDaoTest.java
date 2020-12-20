package daoTest;

import com.epms.dao.uniteDao.UniteDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UniteDaoTest {
    @Test
    public void uniteDaoTest(){
        ApplicationContext ctx=new ClassPathXmlApplicationContext("epmsApplication.xml");
        UniteDao uniteDao =(UniteDao)ctx.getBean("uniteDao");
        System.out.println(uniteDao.managerGetCommitLog(10000002,2));
    }
}
