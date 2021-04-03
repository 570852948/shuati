package org.example;
//@Inherited可以继承的注解


import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spel.GetSPEL;

import javax.naming.Context;

public class M extends BaseTest{

    @Autowired
    GetSPEL getSPEL;

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("spring-ioc.xml");

        GetSPEL getSPEL = (GetSPEL) context.getBean("getSPEL");
        System.out.println(getSPEL.a);
    }

    @Test
    public void b() {
        System.out.println(getSPEL.a);
    }
}
