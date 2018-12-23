package my.delivery.app.dao;

import my.delivery.app.model.GoodsType;

import java.util.List;

public interface GoodsTypeDao {
    List<GoodsType> getAllGoodsTypes();
    GoodsType getGoodsTypeById(int id);
}
