package org.example.SpringContext.Annotation;

import org.springframework.stereotype.Component;

@Component
public class HelloBean {
    private String message = "@Component!";
    public void sayHello() {
        System.out.println("Message: " + message);
    }
}