package org.example.AOP.byannotation;

import org.springframework.stereotype.Component;

@Component
public class MyService {

    public void sayHello() {
        System.out.println("(annotation) My Service is running!?!");
    }
}
