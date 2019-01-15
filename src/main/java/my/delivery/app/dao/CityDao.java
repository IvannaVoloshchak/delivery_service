package my.delivery.app.dao;

import my.delivery.app.model.City;

import java.util.List;
/**
 * Description: This interface describes basic CRUD operations of database.
 * The parent class for all DAO classes of the project.
 *
 *@author Ivanna Voloshchak
 */

public interface CityDao {
    /**
     * This method reads and returns information from all records (rows) of a database table.
     * @return                  - list of all cities from a database table.
     */
    List<City> getAllCities();
}
