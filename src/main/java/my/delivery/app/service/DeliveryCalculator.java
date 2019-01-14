package my.delivery.app.service;

import org.apache.log4j.Logger;

public class DeliveryCalculator {
    public static Logger consLogger = Logger.getLogger("CONS");
    public static Double calculateDeliveryPrice(double minimumPrice, double pricePerKilogram, double pricePerKilometer, int distance, double weight) {
        if (weight<0){
            consLogger.error("Customer entered weight lower zero"+ weight);
            throw new IllegalArgumentException("Weight can't be less then zero");
        }
        return minimumPrice + pricePerKilometer * distance + weight * pricePerKilogram;
    }
}
