package spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

@RunWith(SpringRunner.class)
@ContextConfiguration("classpath:spring-ioc.xml")
public class AppMain {

    @Autowired
    ApplicationContext applicationContext1;

    @Autowired
    SpringContextUtils contextUtils;


//    @Autowired
//    Interface1 interface1;

    @Test
    public void r() {
        //Interface1 s = interface1;
        System.out.println("成功");
        Map<String, Interface1> beansOfType = applicationContext1.getBeansOfType(Interface1.class);
        beansOfType.forEach((a, b) -> System.out.println(a + ": " + b));

        ApplicationContext applicationContext2 = contextUtils.getApplicationContext();
        Map<String, Interface1> beansOfType1 = applicationContext2.getBeansOfType(Interface1.class);
        beansOfType1.forEach((a,b)-> System.out.println(a + ": " + b));

    }
}
