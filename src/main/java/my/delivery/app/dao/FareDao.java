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
                fare.setId(rs.getInt("ide"));
                fare.setIdGoodsType(rs.getInt("id_goods_type"));
                fare.setMinimumPrice(rs.getDouble("minimum_price"));
                fare.setPricePerKilogram(rs.getDouble("price_per_kilogram"));

                fares.add(fare);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return fares;
    }
}
