package my.delivery.app.dao.impl;

import my.delivery.app.dao.UserTypeDao;
import my.delivery.app.model.UserType;
import my.delivery.app.util.ConnectionPool;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserTypeDaoImpl implements UserTypeDao {
    public static Logger consLogger = Logger.getLogger("CONS");
    private ConnectionPool pool;

    public UserTypeDaoImpl() {
        pool = new ConnectionPool();
    }

    public UserType getUserTypeById(int id) {
        Connection connection = pool.getConnection(false);
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
            consLogger.error("Can't find user with this id in DB");
            e.printStackTrace();

        }finally {
            ConnectionPool.closeConnection(connection);
        }
        return userType;
    }
    public UserType getUserTypeByName(String name){
        Connection connection = pool.getConnection(false);
        UserType userType = new UserType();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select id from user_type where name=? ");
            preparedStatement.setString(1, name);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                userType.setId(rs.getInt("id"));
                userType.setName(rs.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }finally {
            ConnectionPool.closeConnection(connection);
        }
        return userType;
    }

}
