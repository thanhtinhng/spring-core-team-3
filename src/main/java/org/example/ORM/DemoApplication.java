package org.example.ORM;

import org.example.ORM.hibernate.Student;
import org.example.ORM.spring_data_jpa.StudentRepository;
import org.example.ORM.spring_data_jpa.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;

@SpringBootApplication
@EntityScan(basePackages = "org.example.ORM.hibernate") // nơi chứa @Entity
@EnableJpaRepositories(basePackages = "org.example.ORM.spring_data_jpa") // nơi chứa @Repository
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}