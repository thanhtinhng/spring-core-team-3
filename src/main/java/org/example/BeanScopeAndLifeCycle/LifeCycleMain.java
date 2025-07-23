package org.example.BeanScopeAndLifeCycle;

import org.springframework.context.annotation.*;

@Configuration
@ComponentScan
public class LifeCycleMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(LifeCycleMain.class);
        context.getBean(LifeCycleBean.class).run();
        context.close(); // để gọi @PreDestroy
    }
}

