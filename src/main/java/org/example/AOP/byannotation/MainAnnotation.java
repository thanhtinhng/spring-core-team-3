package org.example.AOP.byannotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "org.example.AOP.byannotation")
@EnableAspectJAutoProxy

public class MainAnnotation {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MainAnnotation.class);
        MyService service = context.getBean(MyService.class);
        service.sayHello();
        context.close();
    }
}
