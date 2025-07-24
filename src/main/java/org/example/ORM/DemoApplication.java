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
//    @Bean
//    CommandLineRunner initDatabase(StudentService studentService) {
//        return args -> {
//            System.out.println("Đang khởi tạo dữ liệu mẫu...");
//
//            Student student1 = new Student();
//            student1.setName("Nguyen Van A");
//            student1.setEmail("22521483.gm.uit.edu.vn");
//            studentService.addStudent(student1);
//
//            Student student2 = new Student();
//            student1.setName("Nguyen Van B");
//            student1.setEmail("123456.gm.uit.edu.vn");
//            studentService.addStudent(student2);
//
//            System.out.println("Đã tạo xong dữ liệu mẫu.");
//        };
//    }
}