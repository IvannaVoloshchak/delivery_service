package my.delivery.app.service;

public class DeliveryCalculator {
    public static Double calculateDeliveryPrice(double weight, int distance, int minimumPrice) {
        Double price = minimumPrice + 0.1 * distance + weight;
        return price;
    }
}
