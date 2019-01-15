package my.delivery.app.dao;

import my.delivery.app.model.UserType;
/**
 * Description: This interface describes basic CRUD operations of database.
 * The parent class for all DAO classes of the project.
 *
 *@author Ivanna Voloshchak
 */
public interface UserTypeDao {
    UserType getUserTypeById(int id);
    UserType getUserTypeByName(String name);
}
