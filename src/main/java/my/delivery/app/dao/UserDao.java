package my.delivery.app.dao;

import my.delivery.app.model.User;

import java.util.List;

public interface UserDao {
     List<User> getAllUsers(); /*throws DAOExeption;*/
    void addUser(User user);
    void deleteUser(int id);
    User getUserById(int id);
    void updateUser(User user);
    boolean find(String login, String password);
    User checkUser(String login, String password);
    boolean checkLogin(String login);
}
