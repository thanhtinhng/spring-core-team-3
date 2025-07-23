package org.example.SpringContext.JavaConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public HelloBean helloBean() {
        HelloBean h = new HelloBean();
        h.setMessage("Hello");
        return h;
    }
}