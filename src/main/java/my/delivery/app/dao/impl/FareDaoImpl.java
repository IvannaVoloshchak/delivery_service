package my.delivery.app.dao.impl;

import my.delivery.app.dao.FareDao;
import my.delivery.app.model.Fare;
import my.delivery.app.util.ConnectionPool;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FareDaoImpl implements FareDao {
    public static Logger consLogger = Logger.getLogger("CONS");
    private ConnectionPool pool;

    public FareDaoImpl() {
        pool = new ConnectionPool();
    }

    public List<Fare> getAllFare() {
        Connection connection = pool.getConnection(false);
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
                fare.setPricePerKilometer(rs.getDouble("price_per_kilometer"));

                fares.add(fare);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            consLogger.error("Can't find fare from this parameters in DB");
        } finally {
            ConnectionPool.closeConnection(connection);
        }
        return fares;
    }

    public Fare getFareByIdGoodsType(int id) {
        Connection connection = pool.getConnection(false);
        Fare fare = new Fare();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from fare where id_goods_type=?");
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                fare.setId(rs.getInt("id"));
                fare.setIdGoodsType(rs.getInt("id_goods_type"));
                fare.setMinimumPrice(rs.getDouble("minimum_price"));
                fare.setPricePerKilogram(rs.getDouble("price_per_kilogram"));
                fare.setPricePerKilometer(rs.getDouble("price_per_kilometer"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
            consLogger.error("Can't find fare for this goods type in DB");
        } finally {
            ConnectionPool.closeConnection(connection);
        }
        return fare;
    }
}
