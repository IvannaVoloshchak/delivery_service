package my.delivery.app.dao.impl;

import my.delivery.app.dao.CityDao;
import my.delivery.app.model.City;
import my.delivery.app.util.ConnectionPool;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CityDaoImpl implements CityDao {

private ConnectionPool pool;

    public CityDaoImpl() {
        pool = new ConnectionPool();
    }

    public List<City> getAllCities() {
       Connection connection=pool.getConnection(false);
        List<City> cities = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from city");
            while (rs.next()) {
                City city = new City();
                city.setId(rs.getInt("id"));
                city.setName(rs.getString("name"));
                cities.add(city);
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
        finally {
            ConnectionPool.closeConnection(connection);
        }return cities;
    }
}