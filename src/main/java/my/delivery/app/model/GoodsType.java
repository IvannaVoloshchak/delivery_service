package my.delivery.app.model;

import java.io.Serializable;

public class GoodsType implements Serializable {
    private Integer idGoodsType;
    private String name;

    public Integer getIdGoodsType() {
        return idGoodsType;
    }

    public void setIdGoodsType(Integer idGoodsType) {
        this.idGoodsType = idGoodsType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "GoodsType{" +
                "id_goods_type=" + idGoodsType +
                ", name='" + name + '\'' +
                '}';
    }
}
