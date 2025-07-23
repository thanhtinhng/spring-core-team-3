package org.example.SpringContext.Annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan
public class AppAnnotation {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppAnnotation.class);
        HelloBean hello = context.getBean(HelloBean.class);
        hello.sayHello();
    }
}
