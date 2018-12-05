package my.delivery.app.model;

import java.io.Serializable;

public class Fare implements Serializable {
    private Integer id_fare;
    private String from_city;
    private String to_city;
    private String delivery_type;

    private Double price;

    public Integer getId_fare() {
        return id_fare;
    }

    public void setId_fare(Integer id_fare) {
        this.id_fare = id_fare;
    }

    public String getFrom_city() {
        return from_city;
    }

    public void setFrom_city(String from_city) {
        this.from_city = from_city;
    }

    public String getTo_city() {
        return to_city;
    }

    public void setTo_city(String to_city) {
        this.to_city = to_city;
    }

    public String getDelivery_type() {
        return delivery_type;
    }

    public void setDelivery_type(String delivery_type) {
        this.delivery_type = delivery_type;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Fare{" +
                "id_fare=" + id_fare +
                ", from_city='" + from_city + '\'' +
                ", to_city='" + to_city + '\'' +
                ", delivery_type='" + delivery_type + '\'' +
                 ", price=" + price +
                '}';
    }
}
