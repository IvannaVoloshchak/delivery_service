package my.delivery.app.dao;

import my.delivery.app.model.Fare;
import my.delivery.app.util.DbUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FareDao {
    private Connection connection;

    public FareDao() {
        connection = DbUtil.getConnection();
    }

    public List<Fare> getAllFare() {
        List<Fare> fares = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from fare");
            while (rs.next()) {
                Fare fare = new Fare();
                fare.setId_fare(rs.getInt("id_fare"));
                fare.setFrom_city(rs.getString("from_city"));
                fare.setTo_city(rs.getString("to_city"));
                fare.setDelivery_type(rs.getString("delivery_type"));
                fare.setPrice(rs.getDouble("price"));
                fares.add(fare);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return fares;
    }
}
