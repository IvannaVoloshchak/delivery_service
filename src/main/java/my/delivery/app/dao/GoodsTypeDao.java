package my.delivery.app.dao;

import my.delivery.app.model.GoodsType;

import java.util.List;
/**
 * Description: This interface describes basic CRUD operations of database.
 * The parent class for all DAO classes of the project.
 *
 *@author Ivanna Voloshchak
 */
public interface GoodsTypeDao {
    List<GoodsType> getAllGoodsTypes();
    GoodsType getGoodsTypeById(int id);
}
