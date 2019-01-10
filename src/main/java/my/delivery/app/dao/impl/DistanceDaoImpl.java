package my.delivery.app.dao.impl;

import my.delivery.app.dao.DistanceDao;
import my.delivery.app.model.Distance;
import my.delivery.app.util.ConnectionPool;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DistanceDaoImpl implements DistanceDao {
    public static Logger consLogger = Logger.getLogger("CONS");
    private ConnectionPool pool;

    public DistanceDaoImpl() {
        pool = new ConnectionPool();
    }

    public List<Distance> getAllDistances() {
        Connection connection = pool.getConnection(false);
        List<Distance> distances = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from distance");
            while (rs.next()) {
                Distance distance = new Distance();
                distance.setId(rs.getInt("id"));
                distance.setIdFrom(rs.getInt("id_from"));
                distance.setIdTo(rs.getInt("id_to"));
                distance.setDistance(rs.getInt("distance"));

                distances.add(distance);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            consLogger.error("Can't find distance in DB");
        } finally {
            ConnectionPool.closeConnection(connection);
        }
        return distances;
    }

    public Distance getDistanceByIdCity(int idFrom, int idTo) {
        Connection connection = pool.getConnection(false);
        Distance distance = new Distance();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from delivery_service.distance where id_from=? and id_to=?");
            preparedStatement.setInt(1, idFrom);
            preparedStatement.setInt(2, idTo);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                distance.setId(rs.getInt("id"));
                distance.setIdFrom(rs.getInt("id_from"));
                distance.setIdTo(rs.getInt("id_to"));
                distance.setDistance(rs.getInt("distance"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            consLogger.error("Can't find distance for this cities in DB");
        } finally {
            ConnectionPool.closeConnection(connection);
        }
        return distance;
    }

}
