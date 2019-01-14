package my.delivery.app.dao;

import my.delivery.app.model.City;
import my.delivery.app.model.Delivery;
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
public class DeliveryTest {
    @Mock
    Connection connection;
    @Mock
   private DeliveryDao deliveryDaoMoc;
    @Mock
    Delivery delivery1;
    @Mock
    Delivery delivery2;
    @Mock
    Delivery delivery3;
    @Before
    public void setUp() {
        List<Delivery> deliveries = new ArrayList<>();
       deliveries.add(delivery1);
       deliveries.add(delivery2);
       deliveries.add(delivery3);

        when(deliveryDaoMoc.getAllDeliveries()).thenReturn(deliveries);
    }
    @Test
    public void checkAllDeliveries(){
        List<Delivery>deliveries= deliveryDaoMoc.getAllDeliveries();
        assertTrue("There are not delivery in deliveryDaoMoc", !deliveries.isEmpty());
    }
    @Test
    public void checkAddDelivery(){
    }


}
