package my.delivery.app.dao.impl;

import my.delivery.app.dao.UserDao;
import my.delivery.app.model.User;
import my.delivery.app.util.ConnectionPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    private ConnectionPool pool;

    public UserDaoImpl() {
        pool = new ConnectionPool();
    }

    public List<User> getAllUsers() {
        Connection connection = pool.getConnection(false);
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
                user.setLastName(rs.getString("last_name"));
                user.setPhoneNumber(rs.getString("phone_number"));
                user.setEmail(rs.getString("email"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ConnectionPool.closeConnection(connection);
        }
        return users;
    }

    public void addUser(User user) {
        Connection connection = pool.getConnection(false);
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("insert into user(typeId," +
                            "login, password, first_name, last_name, phone_number, email)values ( ?, ?, ?, ?, ?, ?, ?)");


            preparedStatement.setInt(1, user.getTypeId());
            preparedStatement.setString(2, user.getLogin());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setString(4, user.getFirstName());
            preparedStatement.setString(5, user.getLastName());
            preparedStatement.setString(6, user.getPhoneNumber());
            preparedStatement.setString(7, user.getEmail());

            preparedStatement.executeUpdate();
            pool.commitTransaction(connection);
        } catch (SQLException e) {
            pool.transactionRollback(connection);
            e.printStackTrace();
        }finally {
            ConnectionPool.closeConnection(connection);
        }
    }

    public void deleteUser(int id) {
        Connection connection = pool.getConnection(false);
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from " +
                    "user  where id=?");
            // Parameters start with 1
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            pool.commitTransaction(connection);
        } catch (SQLException e) {
            pool.transactionRollback(connection);
            e.printStackTrace();
        }finally {
            ConnectionPool.closeConnection(connection);
        }
    }

    public User getUserById(int id) {
        Connection connection = pool.getConnection(false);
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
                user.setPhoneNumber(rs.getString("phone_number"));
                user.setEmail(rs.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ConnectionPool.closeConnection(connection);
        }
        return user;
    }

    public void updateUser(User user) {
        Connection connection = pool.getConnection(false);
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("Update user set  typeId=?, login =?," +
                            "password=?, first_name=?, last_name=?, phone_number=?, email=? where id =?");

            preparedStatement.setInt(1, user.getTypeId());
            preparedStatement.setString(2, user.getLogin());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setString(4, user.getFirstName());
            preparedStatement.setString(5, user.getLastName());
            preparedStatement.setString(6, user.getPhoneNumber());
            preparedStatement.setString(7, user.getEmail());
            preparedStatement.setInt(8, user.getId());
            preparedStatement.executeUpdate();
            pool.commitTransaction(connection);
        } catch (SQLException e) {
            pool.transactionRollback(connection);
            e.printStackTrace();
        }finally {
            ConnectionPool.closeConnection(connection);
        }
    }

    public boolean find(String login, String password) {
        Connection connection = pool.getConnection(false);
        User user = new User();
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("SELECT * FROM USER WHERE LOGIN = ? AND PASSWORD = ?");
            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, user.getPassword());
            ResultSet rs = null;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ConnectionPool.closeConnection(connection);
        }
        return true;
    }


    public User checkUser(String login, String password) {
        try {
            List<User> userList = getAllUsers();
            for (User user : userList) {
                if (login.equals(user.getLogin()) && password.equals(user.getPassword())) {
                    return user;
                }
            }
        } catch (Exception e) {
            System.out.println("Can't check account");
            throw e;
        }
        return null;
    }


    public boolean checkLogin(String login) {
        try {
            List<User> userList = getAllUsers();
            for (User user : userList) {
                if (login.equals(user.getLogin())) {
                    return true;
                }
            }
        } catch (Exception e) {
            System.out.println("Can't check login");
            throw e;
        }
        return false;
    }
}
