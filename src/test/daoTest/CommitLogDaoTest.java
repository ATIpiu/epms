package daoTest;

import com.epms.dao.commitLogDao.CommitLogDao;
import com.epms.entity.CommitLog;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommitLogDaoTest {
    @Test
    public void commitLogDaoTest(){
        ApplicationContext ctx=new ClassPathXmlApplicationContext("epmsApplication.xml");
        CommitLogDao commitlogDao= (CommitLogDao) ctx.getBean("commitLogDao");

        /**
         * 获取所有的commit日志（CommitLog）信息
         * List<CommitLog> queryAllCommitLogs();
        */
        /*List<CommitLog> logs = commitlogDao.queryAllCommitLogs();
        for(CommitLog log:logs){
            System.out.println(log);
        }*/


        /**
         * 获取commit日志（CommitLog）信息；
         *
         * @return list<CommitLog> 根据项目pId查询所有的commit日志(CommitLog)信息
         */
        /*int pId = 10001;
        List<CommitLog> logs = commitlogDao.queryCommitLogsBypId(pId);
        for(CommitLog log:logs){
            System.out.println(log);
        }*/

        /**
         * 获取commit日志（CommitLog）信息；
         *
         * @return list<CommitLog> 根据员工sId查询上传日志(CommitLog)信息
         * List<CommitLog> queryCommitLogsBysId(int sId);
         */
        /*int sId = 10000004;
        List<CommitLog> logs = commitlogDao.queryCommitLogsBysId(sId);
        for(CommitLog log:logs) {
            System.out.println(log);
        }*/

        /**
         * @param commitLog 参数为一次提交的记录
         * @return int 若更新成功返回1，失败返回0；
         * int updateCommitLog(CommitLog commitLog);
         */
//        List<CommitLog> logss = commitlogDao.queryAllCommitLogs();
//        for(CommitLog log:logss) {
//            System.out.println(log);
//        }
//        java.util.Date javaDate = new java.util.Date();
//        long time = javaDate.getTime();
//        Timestamp stamp = new Timestamp(time);
//        //stamp = Timestamp.valueOf("2020-12-20 21:23:58");
//        CommitLog commitlog = new CommitLog(10000005,10001,stamp,2,"henok",200);
//        Map<String,Object> map = new HashMap<String, Object>();
//        int aaa = 2;
//        map.put("sId",(int)10000001);
//        map.put("pId",(int)10001);
//        map.put("cCreateTime",stamp);
//        map.put("cType",aaa);
//        int i = commitlogDao.insertIntoCommitLog(map);
//        List<CommitLog> logs = commitlogDao.queryAllCommitLogs();
//        for(CommitLog log:logs) {
//            System.out.println(log);
//        }

        //CommitLog commitlog = new CommitLog();

        /**
         * @param commitLog 参数为一次commit的记录
         * @return int 若删除成功返回1，失败返回0；
         * int deleteCommitLog(CommitLog commitLog);
         */
        List<CommitLog> logs = commitlogDao.queryAllCommitLogs();
        Timestamp stamp = Timestamp.valueOf("2020-12-20 21:23:58");
        CommitLog commitlog = new CommitLog(10000004,10001,stamp,2,"henok",200);
        int i = commitlogDao.deleteCommitLog(commitlog);
        for(CommitLog log:logs) {
            System.out.println(log);
        }

    }
}
