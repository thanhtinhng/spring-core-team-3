package org.example.BeanScopeAndLifeCycle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class ScopeDemo {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ScopeDemo.class);
        CounterBean bean1 = context.getBean(CounterBean.class);
        CounterBean bean2 = context.getBean(CounterBean.class);
        bean1.show();
        bean2.show(); // Nếu scope là singleton => bean1 == bean2
    }
}
