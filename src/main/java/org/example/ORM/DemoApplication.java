package org.example.ORM;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "org.example.ORM.entity_manager") // nơi chứa @Entity
@EnableJpaRepositories(basePackages = "org.example.ORM.spring_data_jpa") // nơi chứa @Repository
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}