package my.delivery.app.dao;

import my.delivery.app.model.City;
import my.delivery.app.model.Delivery;
import my.delivery.app.model.Fare;
import my.delivery.app.util.DbUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CityDao {
    private Connection connection;

    public CityDao() {
        connection = DbUtil.getConnection();
    }

    public List<City> getAllCities() {
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
        }return cities;
    }
}