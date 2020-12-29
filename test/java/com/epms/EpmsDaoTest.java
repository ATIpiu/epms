package com.epms;

import com.epms.dao.clientDao.ClientDao;
import com.epms.dao.commitLogDao.CommitLogDao;
import com.epms.dao.projectDao.ProjectDao;
import com.epms.dao.salaryDao.SalaryDao;
import com.epms.dao.selectProjectDao.SelectProjectDao;
import com.epms.dao.staffDao.StaffDao;
import com.epms.dao.uploadFileLogDao.UploadFileLogDao;
import com.epms.entity.*;
import com.epms.utils.SpringUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@SpringBootTest
public class EpmsDaoTest {

    @Test
    //输出所有的Bean的测试
    public void seanTest() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("epmsApplication.xml");
        String[] beans = ctx.getBeanDefinitionNames();
        for (String bean : beans
        ) {
            System.out.println(bean);
        }
    }

    @Test
    public void clientDaoTest() {
        ApplicationContext ctx = SpringUtil.getApplicationContext();
        System.out.println(ctx);
        ClientDao clientDao = (ClientDao) ctx.getBean("clientDao");
        //查询全部测试
//        List<Client> clients = clientDao.queryAllClients();
//        for (Client client : clients) {
//            System.out.println(client);
//        }
//        插入测试
//        Client c=new Client("Test2",12345678,"12345667","123456","1123456","1522760512@qq.com","Atipiu11","123456","none");
//        System.out.println(clientDao.insertIntoClient(c));
        //按sId查询测试
//        Client c=new Client("Test2",12345678,"12345667","123456","1123456","1522760512@qq.com","Atipiu","123456","none");
//        System.out.println(clientDao.queryClientById(c.getcId()));
//        按sUserName查询测试
//        Client c=new Client("Test3",12345678,"12345667","123456","1123456","1522760512@qq.com","Atipiu","123456","none");
//        System.out.println(clientDao.queryClientByUserName(c.getcUsername()));
        //更新Client对象测试
//        Client c=new Client("Test3",12345678,"12345667","123456","1123456","1522760512@qq.com","Atipiu11","123456",null);
//        System.out.println(clientDao.updateClient(c));
        //关键字查询测试
        System.out.println(clientDao.queryClientByKeyword("A"));
    }

    @Test
    public void commitLogDaoTest() {
        ApplicationContext ctx = SpringUtil.getApplicationContext();
        CommitLogDao commitlogDao = (CommitLogDao) ctx.getBean("commitLogDao");

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
        CommitLog commitlog = new CommitLog(10000004, 10001, stamp, 2, "henok", 200);
        int i = commitlogDao.deleteCommitLog(commitlog);
        for (CommitLog log : logs) {
            System.out.println(log);
        }

    }

    @Test
    public void projectDao() {
        ApplicationContext ctx = SpringUtil.getApplicationContext();
        ProjectDao projectDao = (ProjectDao) ctx.getBean("projectDao");
        Date t = new Date();
        long now = t.getTime();

//        List<Project> pro1 = projectDao.queryAllProjects();
//        for(Project p:pro1){
//            System.out.println(p);
//        }

//        Map<String,Object> m1 = new HashMap<String,Object>();
//        m1.put("pId",10001);
//        m1.put("cId",12345678);
        Project pro2 = projectDao.queryProjectBypId(10001);
        System.out.println(pro2);
//        List<Project> pro3 = projectDao.queryProjectBycId(m1);
//        for(Project p:pro3){
//            System.out.println(p);
//        }

        Timestamp end = new Timestamp(now);
        Timestamp create = Timestamp.valueOf("2020-12-12 21:21:21");
        Project newp = new Project(10001, "YangForTest", create, end, 1234, 10000001, 10000001, "aaa",
                10000002, "123", 10000003, "ccc", 0, 0, "www.7k7k.com", 500, 200, 400);
        //projectDao.insertIntoProject(newp);
//        projectDao.updateProject(newp);

//        Map<String,Object> map = new HashMap<String, Object>();
//        map.put("pId",10002);
//        projectDao.deleteProjectBypId(map);
    }

    @Test
    public void salaryDaoTest() {
        ApplicationContext ctx = SpringUtil.getApplicationContext();
        SalaryDao salaryDao = (SalaryDao) ctx.getBean("salaryDao");
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
        Salary s4 = new Salary(10000003, 10001, (float) 0.10, (float) 0.88, t1, null);
//        salaryDao.insertIntoSalary(s4);
        salaryDao.deleteSalary(s4);
//        salaryDao.updateSalary(s4);

    }

    @Test
    public void selectProjectDaoTest() {
        ApplicationContext ctx = SpringUtil.getApplicationContext();
        SelectProjectDao selectProjectDao = (SelectProjectDao) ctx.getBean("selectProjectDao");

//        List<SelectProject> sps = selectProjectDao.queryAllSelectProjects();
//        for (SelectProject sp:sps){
//            System.out.println(sp);
//        }

//        SelectProject s1 = selectProjectDao.querySelectProjectByspId(1001);
//        System.out.println(s1);

//        List<SelectProject> s2 = selectProjectDao.querySelectProjectBypId(10001);
//        List<SelectProject> s3 = selectProjectDao.querySelectProjectBysId(10000004);
//        for (SelectProject sp2:s2){
//            System.out.println(sp2);
//        }
//        for (SelectProject sp3:s3){
//            System.out.println(sp3);
//        }
//        SelectProject s4= new SelectProject(10000004,10001,1002);
//        selectProjectDao.insertIntoSelectProject(s4);

//        Map<String,Object> map = new HashMap<String, Object>();
//        map.put("spId",1002);
//        selectProjectDao.deleteSelectProjectByspId(map);

        SelectProject s5 = new SelectProject(10000003, 10001, 1001);
        selectProjectDao.updateSelectProject(s5);

    }

    @Test
    public void staffDaoTest() {
        ApplicationContext ctx = SpringUtil.getApplicationContext();
        StaffDao staffDao = (StaffDao) ctx.getBean("staffDao");
        //查询全部测试
//        List<Staff> staffs=staffDao.queryAllStaffs();
//        for (Staff staff:staffs){
//            System.out.println(staff);
//        }
        //插入测试
//        Staff s=new Staff("Test2",10000002,1,"male","12345678901","chongqing","15730680467","ATIpiu","atipiu");
//        System.out.println(staffDao.insertIntoStaff(s));
        //按sId查询测试
//        Staff s=new Staff("Test2",10000002,1,"male","12345678901","chongqing","15730680467","ATIpiu","atipiu");
//        System.out.println(staffDao.queryStaffById(s.getsId()));
        //按sUserName查询测试
//        Staff s=new Staff("Test2",10000002,1,"male","12345678901","chongqing","15730680467","ATIpiu","atipiu");
//        System.out.println(staffDao.queryStaffByUserName(s.getsUsername()));
        //更新Staff记录测试
//        Staff s = new Staff("Test3", 10000002, 1, "male", "12345678901", "chongqing", "15730680467", "ATIpiu", "atipiu");
//        System.out.println(staffDao.updateStaff(s));
//        System.out.println(staffDao.managerGetOwnStaff(10001,11));
//        模糊查询测试
        System.out.println(staffDao.queryStaffByKeyword("male"));
    }

    @Test
    public void uploadFileLogDaoTest() {
        ApplicationContext ctx = SpringUtil.getApplicationContext();
        UploadFileLogDao uploadfilelogDao = (UploadFileLogDao) ctx.getBean("uploadFileLogDao");
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

        UploadFileLog up_log = new UploadFileLog(10000002, 10001,
                Timestamp.valueOf("2020-12-08 19:50:29"), "www.4399.com");
        uploadfilelogDao.updateUploadFileLog(up_log);

    }

    @org.junit.Test
    public void test(){
    }
}
