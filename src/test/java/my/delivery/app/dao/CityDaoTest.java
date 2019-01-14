package my.delivery.app.dao;

import my.delivery.app.dao.CityDao;
import my.delivery.app.model.City;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CityDaoTest {

    @Mock
    Connection connection;
    @Mock
    private CityDao cityDaoMoc;

    @Mock
    City city1;
    @Mock
    City city2;
    @Mock
    City city3;

    @Before
    public void setUp() {
        List<City> cities = new ArrayList<>();
        cities.add(city1);
        cities.add(city2);
        cities.add(city3);

        when(cityDaoMoc.getAllCities()).thenReturn(cities);
    }

    @Test
    public void checkGetAllCities() {
        List<City> cities = cityDaoMoc.getAllCities();
        assertTrue("There are not cities in cityDaoMoc", !cities.isEmpty());
    }

}

