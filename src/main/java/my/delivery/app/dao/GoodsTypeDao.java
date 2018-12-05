package my.delivery.app.dao;

import my.delivery.app.model.GoodsType;
import my.delivery.app.util.DbUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GoodsTypeDao {
    private Connection connection;

    public GoodsTypeDao() {

        connection = DbUtil.getConnection();
    }
    public List<GoodsType> getAllGoods() {
        Connection connection = DbUtil.getConnection();
        List<GoodsType> goodsTypes = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from goods_type");
            while (rs.next()) {
                GoodsType goodsType= new GoodsType();
                goodsType.setIdGoodsType(rs.getInt("id_goods_type"));
                goodsType.setDeliveryType(rs.getString("delivery_type"));
                goodsTypes.add(goodsType);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return goodsTypes;
    }
}
