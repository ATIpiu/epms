package serviceTest;

import com.epms.entity.Staff;
import com.epms.service.StaffService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StaffServiceTest {
    @Test
    public void staffServiceTest() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("epmsApplication.xml");
        StaffService staffService = (StaffService) ctx.getBean("staffServiceImpl");
        //查询全部测试
//        System.out.println(staffService.getAllStaffs(1,20));
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
}
