package org.example.ORM.entity_manager;

import java.sql.*;

public class TestMySQLConnection {
    public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://localhost:3306/your_db?useSSL=false&serverTimezone=UTC";
        String username = "root";
        String password = "your_password";

        String sql = "SELECT * FROM student LIMIT 5"; // Thay bằng tên bảng thật trong DB của bạn

        try (Connection conn = DriverManager.getConnection(jdbcURL, username, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("Kết nối thành công! Kết quả SELECT student:");
            while (rs.next()) {
                // In ra giá trị của cột đầu tiên (ví dụ: id, name...)
                System.out.println(rs.getString("name"));
            }

        } catch (SQLException e) {
            System.err.println("Kết nối thất bại hoặc truy vấn lỗi!");
            e.printStackTrace();
        }
    }
}
