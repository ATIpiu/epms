package daoTest;

import com.epms.dao.commitLogDao.CommitLogDao;
import com.epms.dao.uploadFileLogDao.UploadFileLogDao;
import com.epms.entity.UploadFileLog;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UploadFileLogDaoTest{
    @Test
    public void uploadFileLogDaoTest(){
        ApplicationContext ctx=new ClassPathXmlApplicationContext("epmsApplication.xml");
        UploadFileLogDao uploadfilelogDao= (UploadFileLogDao) ctx.getBean("uploadFileLogDao");
        Date t = new Date();
        long now = t.getTime();

//        List<UploadFileLog> logs = uploadfilelogDao.queryAllUploadFileLogs();
//        for(UploadFileLog log:logs){
//            System.out.println(log);
//        }

//        Map<String, Object> map = new HashMap<String,Object>();
//        map.put("pId",10001);
//        map.put("sId",10000002);
//        List<UploadFileLog> logs2 = uploadfilelogDao.queryUploadFileLogsBypId(map);
//        List<UploadFileLog> logs3 = uploadfilelogDao.queryUploadFileLogsBysId(map);
//        for(UploadFileLog log:logs2){
//            System.out.println(log);
//        }
//        for(UploadFileLog log:logs3){
//            System.out.println(log);
//        }


//        Timestamp time = new Timestamp(now);
//        UploadFileLog newup = new UploadFileLog(10000003,10001,time,"www.google.com");
//        uploadfilelogDao.insertIntoUploadFileLog(newup);
//        List<UploadFileLog> log4 = uploadfilelogDao.queryAllUploadFileLogs();
//        for(UploadFileLog log:log4){
//            System.out.println(log);
//        }

//        Timestamp time = Timestamp.valueOf("2020-12-21 20:05:08");
//        UploadFileLog del_up = new UploadFileLog();
//        Map<String,Object> m1 = new HashMap<String,Object>();
//        m1.put("sId",10000003);
//        m1.put("pId",10001);
//        m1.put("upLoadTime",time);
//        uploadfilelogDao.deleteUploadFileLog(m1);

        UploadFileLog up_log = new UploadFileLog(10000002,10001,
                Timestamp.valueOf("2020-12-08 19:50:29"),"www.4399.com");
        uploadfilelogDao.updateUploadFileLog(up_log);

    }
}