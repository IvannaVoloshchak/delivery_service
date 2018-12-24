package my.delivery.app.dao;

import my.delivery.app.model.UserType;

public interface UserTypeDao {
    UserType getUserTypeById(int id);
    UserType getUserTypeByName(String name);
}
