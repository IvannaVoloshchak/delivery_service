package my.delivery.app.dao;

import my.delivery.app.model.Fare;

import java.util.List;
/**
 * Description: This interface describes basic CRUD operations of database.
 * The parent class for all DAO classes of the project.
 *
 *@author Ivanna Voloshchak
 */
public interface FareDao {
    List<Fare> getAllFare();
    Fare getFareByIdGoodsType(int id);

}
