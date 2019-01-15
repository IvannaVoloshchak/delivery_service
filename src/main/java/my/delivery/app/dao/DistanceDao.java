package my.delivery.app.dao;

import my.delivery.app.model.Distance;

import java.util.List;
/**
 * Description: This interface describes basic CRUD operations of database.
 * The parent class for all DAO classes of the project.
 *
 *@author Ivanna Voloshchak
 */
public interface DistanceDao {
    List<Distance> getAllDistances();
    Distance getDistanceByIdCity(int idFrom, int idTo );

}
