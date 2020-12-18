import com.epms.dao.staffDao.StaffDao;
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
        Staff s=new Staff("Test2",10000001,1,"male","12345678901","chongqing","15730680467","ATIpiu","atipiu");
        System.out.println(staffDao.insertIntoStaff(s));
        //按sId查询测试
//        Staff s=new Staff("Test2",10000002,1,"male","12345678901","chongqing","15730680467","ATIpiu","atipiu");
//        System.out.println(staffDao.queryStaffById(s.getsId()));
        //按sUserName查询测试
//        Staff s=new Staff("Test2",10000002,1,"male","12345678901","chongqing","15730680467","ATIpiu","atipiu");
//        System.out.println(staffDao.queryStaffByUserName(s.getsUsername()));
    }

}
