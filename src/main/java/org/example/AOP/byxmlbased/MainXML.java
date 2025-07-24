package org.example.AOP.byxmlbased;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainXML {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("aop-config.xml");

        MyService service = context.getBean("myService", MyService.class);
        service.sayHello();
    }
}
