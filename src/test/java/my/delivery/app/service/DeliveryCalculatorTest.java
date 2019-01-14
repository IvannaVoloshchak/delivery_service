package my.delivery.app.service;

import org.junit.Assert;
import org.junit.Test;

public class DeliveryCalculatorTest {

    @Test
    public void checkDeliveryPrice() {
        double expectedResult = 81.0;
        DeliveryCalculator dc = new DeliveryCalculator();

        double actualResult = dc.calculateDeliveryPrice(25, 1, 0.1, 540, 2);
        Assert.assertEquals(expectedResult, actualResult, 0.0);
    }
    @Test
    public void checkDeliveryPriceAllValuesZero() {
        double expectedResult = 0;
        DeliveryCalculator dc = new DeliveryCalculator();

        double actualResult = dc.calculateDeliveryPrice(0, 0, 0, 0, 0);
        Assert.assertEquals(expectedResult, actualResult, 0.0);
    }
    @Test(expected = IllegalArgumentException.class)
    public void checkDeliveryPriceIfWeightBelongZero() {
        DeliveryCalculator dc = new DeliveryCalculator();
       dc.calculateDeliveryPrice(30, 1,0.1, 540, -2.0);
    }
    @Test
    public void CheckDeliveryPriceIfWeightEqualsZero(){
        DeliveryCalculator dc = new DeliveryCalculator();
        double actualResult = dc.calculateDeliveryPrice(25, 1,0.1, 540, 0.0);
       double expectedResult =79;
        Assert.assertEquals(expectedResult, actualResult, 0.0);
    }

}
