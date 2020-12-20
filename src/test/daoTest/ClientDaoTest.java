package daoTest;

import com.epms.dao.clientDao.ClientDao;
import com.epms.entity.Client;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ClientDaoTest {
    @Test
    public void clientDaoTest(){
        ApplicationContext ctx=new ClassPathXmlApplicationContext("epmsApplication.xml");
        ClientDao clientDao= (ClientDao) ctx.getBean("clientDao");
        //查询全部测试
//        List<Client> clients=clientDao.queryAllClients();
//        for (Client client:clients){
//            System.out.println(client);
//        }
        //插入测试
//        Client c=new Client("Test2",12345678,"12345667","123456","1123456","1522760512@qq.com","Atipiu","123456","none");
//        System.out.println(clientDao.insertIntoClient(c));
        //按sId查询测试
//        Client c=new Client("Test2",12345678,"12345667","123456","1123456","1522760512@qq.com","Atipiu","123456","none");
//        System.out.println(clientDao.queryClientById(c.getcId()));
//        按sUserName查询测试
        Client c=new Client("Test3",12345678,"12345667","123456","1123456","1522760512@qq.com","Atipiu","123456","none");
        System.out.println(clientDao.queryClientByUserName(c.getcUsername()));
        //更新Client对象测试
//        Client c=new Client("Test3",12345678,"12345667","123456","1123456","1522760512@qq.com","Atipiu","123456","none");
//        System.out.println(clientDao.updateClient(c));
    }
}
