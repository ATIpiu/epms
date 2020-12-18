import com.epms.dao.clientDao.ClientDao;
import com.epms.dao.staffDao.StaffDao;
import com.epms.entity.Client;
import com.epms.entity.Staff;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DaoTest {
    @Test
    //输出所有的Bean的测试
    public void seanTest(){
        ApplicationContext ctx=new ClassPathXmlApplicationContext("epmsApplication.xml");
        String beans[]=ctx.getBeanDefinitionNames();
        for (String bean:beans
        ) {
            System.out.println(bean);
        }
    }
    @Test
    public void staffDaoTest(){
        ApplicationContext ctx=new ClassPathXmlApplicationContext("epmsApplication.xml");
        StaffDao staffDao= (StaffDao) ctx.getBean("staffDao");
        //查询全部测试
//        List<Staff> staffs=staffDao.queryAllStaffs();
//        for (Staff staff:staffs){
//            System.out.println(staff);
//        }
        //插入测试
//        Staff s=new Staff("Test2",10000002,1,"male","12345678901","chongqing","15730680467","ATIpiu","atipiu");
//        System.out.println(staffDao.insertIntoStaff(s));
        //按sId查询测试
        Staff s=new Staff("Test2",10000002,1,"male","12345678901","chongqing","15730680467","ATIpiu","atipiu");
        System.out.println(staffDao.queryStaffById(s.getsId()));
        //按sUserName查询测试
//        Staff s=new Staff("Test2",10000002,1,"male","12345678901","chongqing","15730680467","ATIpiu","atipiu");
//        System.out.println(staffDao.queryStaffByUserName(s.getsUsername()));
    }
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
        //按sUserName查询测试
//        Client c=new Client("Test2",12345678,"12345667","123456","1123456","1522760512@qq.com","Atipiu","123456","none");
//        System.out.println(clientDao.queryClientByUserName(c.getcUsername()));
    }

}
