package my.delivery.app.dao;

import my.delivery.app.model.User;
import my.delivery.app.util.DbUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    private Connection connection;

    public UserDao() {
        connection = DbUtil.getConnection();
    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from user");
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setTypeId(rs.getInt("typeId"));
                user.setLogin(rs.getString("login"));
                user.setPassword(rs.getString("password"));
                user.setFirstName(rs.getString("first_name"));
                user.setLastName(rs.getString("" + "last_name"));
                user.setPhoneNumber(rs.getInt("phone_number"));
                user.setEmail(rs.getString("email"));
                users.add(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public void addUser(User user) {

        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("insert into user(id,typeId," +
                            "login, password, first_name, last_name, phone_number, email)values ( ?, ?, ?, ?, ?, ?, ?,?)");

            preparedStatement.setInt(1, user.getId());
            preparedStatement.setInt(2, user.getTypeId());
            preparedStatement.setString(3, user.getLogin());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setString(5, user.getFirstName());
            preparedStatement.setString(6, user.getLastName());
            preparedStatement.setInt(7, user.getPhoneNumber());
            preparedStatement.setString(8, user.getEmail());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteUser(int id) {

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from " +
                    "user  where id=?");
            // Parameters start with 1
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public User getUserById(int id) {

        User user = new User();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from user where id=? ");
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                user.setId(rs.getInt("id"));
                user.setTypeId(rs.getInt("typeId"));
                user.setLogin(rs.getString("login"));
                user.setPassword(rs.getString("password"));
                user.setFirstName(rs.getString("first_name"));
                user.setLastName(rs.getString("last_name"));
                user.setPhoneNumber(rs.getInt("phone_number"));
                user.setEmail(rs.getString("email"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public void updateUser(User user) {

        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("Update user set id=?, typeId=?, login =?," +
                            "password=?, first_name=?, last_name=?, phone_number=?, email=? where id =?");

            preparedStatement.setInt(1, user.getId());
            preparedStatement.setInt(2, user.getTypeId());
            preparedStatement.setString(3, user.getLogin());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setString(5, user.getFirstName());
            preparedStatement.setString(6, user.getLastName());
            preparedStatement.setInt(7, user.getPhoneNumber());
            preparedStatement.setString(8, user.getEmail());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
