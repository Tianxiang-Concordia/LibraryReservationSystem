package dao;

import pojo.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserDao {

    public User checkPassword(String userName, String DBpassword) {
        Connection connection = DBConnection.getConnection();
        try {
            String query = "select * from user where user_username= ? and user_password=? ";
            PreparedStatement ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, userName);
            ps.setString(2, DBpassword);
            ResultSet rs = ps.executeQuery();
            User user = new User();
            if (rs.next()) {
                user.setUserId(rs.getInt("user_id"));
                user.setUsername(rs.getString("user_username"));
                return user;
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    //getUserById
    public User getUserById(int userId) {
        Connection connection = DBConnection.getConnection();
        try {
            String query = "select * from user where user_id= ?";
            PreparedStatement ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();
            User user = new User();
            if (rs.next()) {
                user.setUserId(rs.getInt("user_id"));
                user.setUsername(rs.getString("user_username"));
                user.setRole(rs.getString("user_role"));
                return user;
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}