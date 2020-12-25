package serviceTest;

import com.epms.dao.clientDao.ClientDao;
import com.epms.entity.Client;
import com.epms.service.ClientService;
import com.epms.service.StaffService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class ClientServiceTest {
    @Test
    public void clientServiceTest() {
        ApplicationContext ctx=new ClassPathXmlApplicationContext("epmsApplication.xml");
        ClientService clientService= (ClientService) ctx.getBean("clientServiceImpl");
//        查询全部测试
        System.out.println(clientService.getAllClients(1,20));
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
}
