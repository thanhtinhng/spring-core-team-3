package org.example.transaction.declarative;

import org.example.transaction.User;
import org.example.transaction.UserDao;
import org.springframework.transaction.annotation.Transactional;

public class UserService {
    private UserDao userDao;

    public void setUserDao(UserDao dao) {
        this.userDao = dao;
    }

    @Transactional
    public void createTwoUsers() {
        userDao.insert(new User(3, "Alice"));
        userDao.insert(new User(4, "Bob")); // Trùng id -> gây lỗi -> rollback
    }
}
