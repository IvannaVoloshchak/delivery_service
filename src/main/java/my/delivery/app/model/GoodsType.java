package my.delivery.app.model;

import java.io.Serializable;

public class GoodsType implements Serializable {
    private Integer idGoodsType;
    private String deliveryType;

    public Integer getIdGoodsType() {
        return idGoodsType;
    }

    public void setIdGoodsType(Integer idGoodsType) {
        this.idGoodsType = idGoodsType;
    }

    public String getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(String deliveryType) {
        this.deliveryType = deliveryType;
    }

    @Override
    public String toString() {
        return "GoodsType{" +
                "id_goods_type=" + idGoodsType +
                ", delivery_type='" + deliveryType + '\'' +
                '}';
    }
}
