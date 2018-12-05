package my.delivery.app.model;
import java.io.Serializable;
import java.util.Date;

public class Delivery implements Serializable {
    private Integer id;
    private String senders_name;
    private String recipient_name;
    private String senders_address;
    private String recipient_address;
    private String delivery_type;
    private Double weight;
    private Date sent_date;
    private Date delivery_date;

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSenders_name() {
        return senders_name;
    }

    public void setSenders_name(String senders_name) {
        this.senders_name = senders_name;
    }

    public String getRecipient_name() {
        return recipient_name;
    }

    public void setRecipient_name(String recipient_name) {
        this.recipient_name = recipient_name;
    }

    public String getSenders_address() {
        return senders_address;
    }

    public void setSenders_address(String senders_address) {
        this.senders_address = senders_address;
    }

    public String getRecipient_address() {
        return recipient_address;
    }

    public void setRecipient_address(String recipient_address) {
        this.recipient_address = recipient_address;
    }

    public String getDelivery_type() {
        return delivery_type;
    }

    public void setDelivery_type(String delivery_type) {
        this.delivery_type = delivery_type;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Date getSent_date() {
        return sent_date;
    }

    public void setSent_date(Date sent_date) {
        this.sent_date = sent_date;
    }

    public Date getDelivery_date() {
        return delivery_date;
    }

    public void setDelivery_date(Date delivery_date) {
        this.delivery_date = delivery_date;
    }


    @Override
    public String toString() {
        return "Delivery{" +
                "id=" + id +
                ", senders_name='" + senders_name + '\'' +
                ", recipient_name='" + recipient_name + '\'' +
                ", senders_address='" + senders_address + '\'' +
                ", recipient_address='" + recipient_address + '\'' +
                ", delivery_type='" + delivery_type + '\'' +
                ", weight=" + weight +
                ", sent_date=" + sent_date +
                ", delivery_date=" + delivery_date +
                '}';
    }
}