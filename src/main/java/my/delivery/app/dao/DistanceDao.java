package my.delivery.app.dao;

import my.delivery.app.model.Distance;
import my.delivery.app.util.DbUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DistanceDao {
    private Connection connection;

    public DistanceDao() {
        connection = DbUtil.getConnection();
    }

    public List<Distance> getAllDistances() {
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
        }
        return distances;
    }
    public  Distance getDistanceByIdCity(int idFrom, int idTo ) {

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
        }
        return distance;
    }

}
