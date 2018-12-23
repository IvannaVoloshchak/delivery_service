package my.delivery.app.dao;

import my.delivery.app.model.Fare;

import java.util.List;

public interface FareDao {
    List<Fare> getAllFare();
    Fare getFareByIdGoodsType(int id);

}
