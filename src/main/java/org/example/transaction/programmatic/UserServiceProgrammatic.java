package org.example.transaction.programmatic;

import org.example.transaction.User;
import org.example.transaction.UserDao;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

public class UserServiceProgrammatic {
    private UserDao userDao;
    private PlatformTransactionManager transactionManager;

    public void setUserDao(UserDao dao) {
        this.userDao = dao;
    }

    public void setTransactionManager(PlatformTransactionManager txManager) {
        this.transactionManager = txManager;
    }

    public void createUsersProgrammatically() {
        TransactionStatus status = transactionManager.getTransaction(new DefaultTransactionDefinition());

        try {
            userDao.insert(new User(5, "Alice"));
            userDao.insert(new User(6, "Bob")); // trùng ID để gây lỗi
            transactionManager.commit(status);
            System.out.println("Transaction committed.");
        } catch (Exception e) {
            transactionManager.rollback(status);
            System.out.println("Transaction rolled back " );
        }
    }

    public static void main(String[] args) {
        // Load Spring context
        org.springframework.context.ApplicationContext context =
            new org.springframework.context.support.ClassPathXmlApplicationContext("applicationContext.xml");

        // Lấy bean từ Spring
        UserDao userDao = (UserDao) context.getBean("userDao");
        PlatformTransactionManager txManager = (PlatformTransactionManager) context.getBean("transactionManager");

        // Gán vào service
        UserServiceProgrammatic service = new UserServiceProgrammatic();
        service.setUserDao(userDao);
        service.setTransactionManager(txManager);

        // Thực hiện insert
        service.createUsersProgrammatically();
    }
}
