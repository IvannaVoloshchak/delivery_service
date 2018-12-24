package my.delivery.app.model;
import java.io.Serializable;
import java.util.Date;

public class Delivery implements Serializable {
    private Integer id;
    private Integer userId;
    private String sendersFirstName;
    private String sendersLastName;
    private String recipientFirstName;
    private String recipientLastName;
    private Integer fromCity;
    private Integer toCity;
    private Integer goodsType;
    private Double weight;
    private String sendersPhone;
    private String recipientPhone;
    private Date sentDate;
    private Date deliveryDate;
    private Double price;
    private String paymentStatus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getSendersFirstName() {
        return sendersFirstName;
    }

    public void setSendersFirstName(String sendersFirstName) {
        this.sendersFirstName = sendersFirstName;
    }

    public String getSendersLastName() {
        return sendersLastName;
    }

    public void setSendersLastName(String sendersLastName) {
        this.sendersLastName = sendersLastName;
    }

    public String getRecipientFirstName() {
        return recipientFirstName;
    }

    public void setRecipientFirstName(String recipientFirstName) {
        this.recipientFirstName = recipientFirstName;
    }

    public String getRecipientLastName() {
        return recipientLastName;
    }

    public void setRecipientLastName(String recipientLastName) {
        this.recipientLastName = recipientLastName;
    }

    public Integer getFromCity() {
        return fromCity;
    }

    public void setFromCity(Integer fromCity) {
        this.fromCity = fromCity;
    }

    public Integer getToCity() {
        return toCity;
    }

    public void setToCity(Integer toCity) {
        this.toCity = toCity;
    }

    public Integer getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(Integer goodsType) {
        this.goodsType = goodsType;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getSendersPhone() {
        return sendersPhone;
    }

    public void setSendersPhone(String sendersPhone) {
        this.sendersPhone = sendersPhone;
    }

    public String getRecipientPhone() {
        return recipientPhone;
    }

    public void setRecipientPhone(String recipientPhone) {
        this.recipientPhone = recipientPhone;
    }

    public Date getSentDate() {
        return sentDate;
    }

    public void setSentDate(Date sentDate) {
        this.sentDate = sentDate;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    @Override
    public String toString() {
        return "Delivery{" +
                "id= '" + id +
                ", userId= "+ userId +'\''+
                ", senders_first_name='" + sendersFirstName + '\'' +
                ", senders_last_name='" + sendersLastName + '\'' +
                ", recipient_first_name='" + recipientFirstName + '\'' +
                ", recipient_last_name='" + recipientLastName + '\'' +
                ", from_city='" + fromCity + '\'' +
                ", to_city='" + toCity + '\'' +
                ", goods_type='" + goodsType + '\'' +
                ", weight=" + weight +
                ", senders_phone=" + sendersPhone +
                ", recipient_phone=" + recipientPhone +
                ", sent_date=" + sentDate +
                ", delivery_date=" + deliveryDate +
                ", price= " + price+
                ",paymentStatus= " + paymentStatus+
                '}';
    }
}