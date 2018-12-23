package my.delivery.app.dao;

import my.delivery.app.model.Delivery;

import java.util.List;

public interface DeliveryDao {
    List<Delivery> getAllDeliveries();
    void addDelivery(Delivery delivery);
    void deleteDelivery(int id);
    void updateDelivery(Delivery delivery);
    Delivery getDeliveryById(int id);

}
