package daoTest;

import com.epms.dao.commitLogDao.CommitLogDao;
import com.epms.entity.CommitLog;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CommitLogDaoTest {
    @Test
    public void commitLogDaoTest(){
        ApplicationContext ctx=new ClassPathXmlApplicationContext("epmsApplication.xml");

    }
}
