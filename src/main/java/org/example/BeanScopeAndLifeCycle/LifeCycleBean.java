package org.example.BeanScopeAndLifeCycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class LifeCycleBean {
    @PostConstruct
    public void init() {
        System.out.println("Bean được khởi tạo");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Bean bị hủy");
    }

    public void run() {
        System.out.println("Chạy logic chính...");
    }
}