package org.example.BeanScopeAndLifeCycle;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype") // thử đổi "singleton" và "prototype"
public class CounterBean {
    private static int count = 0;
    private int id;
    public CounterBean() {
        id = ++count;
    }
    public void show() {
        System.out.println("Bean ID: " + id);
    }
}
