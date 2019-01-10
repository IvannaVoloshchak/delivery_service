package my.delivery.app.dao.impl;

import my.delivery.app.dao.GoodsTypeDao;
import my.delivery.app.model.GoodsType;
import my.delivery.app.util.ConnectionPool;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GoodsTypeDaoImpl implements GoodsTypeDao {
    public static Logger consLogger = Logger.getLogger("CONS");
    private ConnectionPool pool;

    public GoodsTypeDaoImpl() {
        pool = new ConnectionPool();
    }

    public List<GoodsType> getAllGoodsTypes() {
        Connection connection = pool.getConnection(false);
        List<GoodsType> goodsTypes = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from goods_type");
            while (rs.next()) {
                GoodsType goodsType = new GoodsType();
                goodsType.setIdGoodsType(rs.getInt("id_goods_type"));
                goodsType.setName(rs.getString("name"));

                goodsTypes.add(goodsType);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            consLogger.error("Can't find this goods type in DB");
        } finally {
            ConnectionPool.closeConnection(connection);
        }
        return goodsTypes;
    }

    public GoodsType getGoodsTypeById(int id) {
        Connection connection = pool.getConnection(false);
        GoodsType goodsType = new GoodsType();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from distance where id=? ");
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                goodsType.setIdGoodsType(rs.getInt("id_goods_type"));
                goodsType.setName(rs.getString("name"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
            consLogger.error("Can't find this goods type in DB");
        } finally {
            ConnectionPool.closeConnection(connection);
        }
        return goodsType;
    }
}
