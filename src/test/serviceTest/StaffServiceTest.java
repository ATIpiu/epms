package serviceTest;

import com.epms.service.StaffService;
import com.epms.utils.result.Result;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StaffServiceTest {
    @Test
    public void StaffServiceTest() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("epmsApplication.xml");
        StaffService staffService= (StaffService) ctx.getBean("staffService");
        System.out.println(staffService.Login("ATIpiu1","atipiu"));
//        System.out.println(result);
    }
}
