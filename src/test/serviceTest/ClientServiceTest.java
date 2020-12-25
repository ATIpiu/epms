package serviceTest;

import com.epms.service.ClientService;
import com.epms.service.StaffService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ClientServiceTest {
    @Test
    public void StaffServiceTest() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("epmsApplication.xml");
        ClientService clientService= (ClientService) ctx.getBean("clientServiceImpl");
        System.out.println(clientService.getAllClients(1,20));
//        System.out.println(result);
    }
}
