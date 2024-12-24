package com.vku.dao;

import com.vku.common.Database;
import com.vku.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserDAO {
    public static boolean checkLogin(User user) {
        String username = user.getUsername();
        String password = user.getPassword();

        System.out.println("Username: " + username);
        System.out.println("Password: " + password);

        // câu lệnh SQL
        String sql = "SELECT * FROM user WHERE username = ? AND password = ?";
        System.out.println("SQL: " + sql); // Test

        // truy vấn csdl
        try (Connection conn = Database.getConnection(); 
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, username);
            ps.setString(2, password);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    System.out.println("Login successful");
                    return true; // Trả về true nếu đăng nhập thành công
                } else {
                    System.out.println("Invalid username or password");
                    return false; 
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
