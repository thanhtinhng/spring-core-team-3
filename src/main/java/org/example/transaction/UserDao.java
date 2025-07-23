package org.example.transaction;

import org.springframework.jdbc.core.JdbcTemplate;
import javax.sql.DataSource;

public class UserDao {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource ds) {
        this.jdbcTemplate = new JdbcTemplate(ds);
    }

    public void insert(User user) {
        jdbcTemplate.update("INSERT INTO users(id, name) VALUES (?, ?)",
                user.getId(), user.getName());
    }
}
