package com.epms;

import com.epms.entity.CommitLog;
import com.epms.service.ClientService;
import com.epms.service.CommitLogService;
import com.epms.service.StaffService;
import com.epms.utils.SpringUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import java.sql.Timestamp;

@SpringBootTest
public class EpmsServiceTest {
    @Test
    public void clientServiceTest() {
        ApplicationContext ctx = SpringUtil.getApplicationContext();
        ClientService clientService = (ClientService) ctx.getBean("clientServiceImpl");
//        查询全部测试
        System.out.println(clientService.getAllClients(1, 20));
//        插入测试
//        Client c=new Client("Test2",12345678,"12345667","123456","1123456","1522760512@qq.com","Atipiu11","123456","none");
//        System.out.println(clientService.insertIntoClient(c));
        //按sId查询测试
//        Client c=new Client("Test2",12345678,"12345667","123456","1123456","1522760512@qq.com","Atipiu","123456","none");
//        System.out.println(clientService.queryClientById(c.getcId()));
//        按sUserName查询测试
//        Client c=new Client("Test3",12345678,"12345667","123456","1123456","1522760512@qq.com","Atipiu","123456","none");
//        System.out.println(clientService.queryClientByUserName(c.getcUsername()));
        //更新Client对象测试
//        Client c=new Client("Test3",12345678,"12345667","123456","1123456","1522760512@qq.com","Atipiu11","123456",null);
//        System.out.println(clientService.updateClient(c));
    }

    @Test
    public void staffServiceTest() {
        ApplicationContext ctx = SpringUtil.getApplicationContext();
        StaffService staffService = (StaffService) ctx.getBean("staffServiceImpl");
//        查询全部测试
        System.out.println(staffService.getAllStaffs(2, 20));
        //插入测试
//        Staff s=new Staff("Test5",10000005,5,"male","12345678901","chongqing","15730680467","ATIpiu5","atipiu");
//        System.out.println(staffService.addStaff(s));
        //按sId查询测试
//        Staff s=new Staff("Test2",10000005,1,"male","12345678901","chongqing","15730680467","ATIpiu","atipiu");
//        System.out.println(staffService.queryStaffById(s.getsId()));
        //按sUserName查询测试
//        Staff s=new Staff("Test2",10000002,1,"male","12345678901","chongqing","15730680467","ATIpiu","atipiu");
//        System.out.println(staffService.queryStaffByUserName(s.getsUsername()));
        //更新Staff记录测试
//        Staff s = new Staff("Test5", 10000005, 1, "male", "12345678901", "chongqing", "15730680467", "ATIpiu6", "atipiu");
//        System.out.println(staffService.updateStaff(s));
    }

    @Test
    public void commitLogServiceTest() {
        ApplicationContext ctx = SpringUtil.getApplicationContext();
        CommitLogService commitLogService = (CommitLogService) ctx.getBean("commitLogServiceImpl");
        java.util.Date javaDate = new java.util.Date(120,11,26,9,20,31);
        long time = javaDate.getTime();
        Timestamp stamp = new Timestamp(time);
        CommitLog commitLog = new CommitLog(10000004,10001,stamp,1,"henok",1,"1");
//        主管获取自己提交记录测试
//        System.out.println(commitLogService.managerGetCommitLog(10000001, 1,20));
//        客户获取自己提交记录测试
//        System.out.println(commitLogService.clientGetCommitLog(10000001, 1, 20));
//        主管或者客户审核提交记录测试
//        System.out.println(commitLogService.checkCommitLog(commitLog));
//        员工提交记录测试
//        System.out.println(commitLogService.staffAddCommitLog(commitLog));
//        客户或者主管审核测试
//        System.out.println(commitLogService.checkCommitLog(commitLog));
//        管理员获取全部提交记录测试
//        System.out.println(commitLogService.getAllCommitLog(1,20));
//        员工获取他自己提交记录测试
//        System.out.println(commitLogService.staffGetOwnCommitLog(10000004,1,20));
    }
}

