package my.delivery.app.dao;

import my.delivery.app.model.Delivery;

import java.util.List;
/**
 * Description: This interface describes basic CRUD operations of database.
 * The parent class for all DAO classes of the project.
 *
 *@author Ivanna Voloshchak.
 */
public interface DeliveryDao {
    List<Delivery> getAllDeliveries();
    void addDelivery(Delivery delivery);
    void deleteDelivery(int id);
    void updateDelivery(Delivery delivery);
    Delivery getDeliveryById(int id);
    List<Delivery> getDeliveriesByUserId(int userId);


}
