import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class EpmsTest {
    @Test
    //输出所有的Bean的测试
    public void seanTest() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("epmsApplication.xml");
        String beans[] = ctx.getBeanDefinitionNames();
        for (String bean : beans
        ) {
            System.out.println(bean);
        }
    }


}
