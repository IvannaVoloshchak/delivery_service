package my.delivery.app.dao;

import my.delivery.app.model.Distance;

import java.util.List;

public interface DistanceDao {
    List<Distance> getAllDistances();
    Distance getDistanceByIdCity(int idFrom, int idTo );

}
