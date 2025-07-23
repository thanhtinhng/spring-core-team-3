package org.example.transaction.declarative;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = (UserService) context.getBean("userService");

        try {
            userService.createTwoUsers();
            System.out.println("Tạo 2 user thành công!");
        } catch (Exception e) {
            System.out.println("Gặp lỗi khi tạo user, đã rollback!");
        }
    }
}
