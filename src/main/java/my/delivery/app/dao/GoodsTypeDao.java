package my.delivery.app.dao;

import my.delivery.app.model.GoodsType;
import my.delivery.app.util.DbUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GoodsTypeDao {
    private Connection connection;

    public GoodsTypeDao() {

        connection = DbUtil.getConnection();
    }

    public List<GoodsType> getAllGoodsTypes() {
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
        }
        return goodsTypes;
    }

    public GoodsType getGoodsTypeById(int id) {

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
        }
        return goodsType;
    }
}
