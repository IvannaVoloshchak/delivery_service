package my.delivery.app.service;


public class DeliveryCalculator {


    public static Double calculateDeliveryPrice( double minimumPrice,double pricePerKilogram, double pricePerKilometer ,  int distance, double weight) {
        Double price = minimumPrice + pricePerKilometer * distance + weight*pricePerKilogram;
        return price;
    }
}
