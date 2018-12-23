package my.delivery.app.util;


import my.delivery.app.dao.DaoFactory;
import my.delivery.app.dao.UserDao;
import my.delivery.app.model.*;

import java.sql.*;

public class ConnectionTry {

    public static void main(String[] args) {
       UserDao userDao= DaoFactory.getDaoFactory().getUserDao();
        System.out.println(userDao.getAllUsers());
}
}


