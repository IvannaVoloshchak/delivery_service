package my.delivery.app.dao;

import my.delivery.app.model.UserType;
import my.delivery.app.util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserTypeDao {
    private Connection connection;

    public UserTypeDao(){
        connection = DbUtil.getConnection();
    }
    public UserType getUserTypeById(int id) {

       UserType userType = new UserType();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from user_type where id=? ");
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                userType.setId(rs.getInt("id"));
                userType.setName(rs.getString("name"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userType;
    }
}