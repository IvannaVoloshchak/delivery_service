package my.delivery.app.model;

import java.io.Serializable;

public class Fare implements Serializable {
    private Integer id;
    private Integer idGoodsType;
    private Double minimumPrice;
    private Double pricePerKilogram;
    private Double pricePerKilometer;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdGoodsType() {
        return idGoodsType;
    }

    public void setIdGoodsType(Integer idGoodsType) {
        this.idGoodsType = idGoodsType;
    }

    public Double getMinimumPrice() {
        return minimumPrice;
    }

    public void setMinimumPrice(Double minimumPrice) {
        this.minimumPrice = minimumPrice;
    }

    public Double getPricePerKilogram() {
        return pricePerKilogram;
    }

    public void setPricePerKilogram(Double pricePerKilogram) {
        this.pricePerKilogram = pricePerKilogram;
    }

    public Double getPricePerKilometer() {
        return pricePerKilometer;
    }

    public void setPricePerKilometer(Double pricePerKilometer) {
        this.pricePerKilometer = pricePerKilometer;
    }

    @Override
    public String toString() {
        return "Fare{" +
                "id=" + id +
                ", id_Goods_Type=" + idGoodsType +
                ", minimum_price=" + minimumPrice +
                ", price_per_kilogram=" + pricePerKilogram +
                ", price_per_kilometer= "+pricePerKilometer+
                '}';
    }
}
