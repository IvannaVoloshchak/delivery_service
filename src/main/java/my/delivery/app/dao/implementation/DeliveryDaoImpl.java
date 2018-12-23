package my.delivery.app.dao.implementation;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import my.delivery.app.dao.DeliveryDao;
import my.delivery.app.util.DbUtil;

import my.delivery.app.model.Delivery;

public class DeliveryDaoImpl implements DeliveryDao {
    private Connection connection;

    public DeliveryDaoImpl() {

        connection = DbUtil.getConnection();
    }

    public List<Delivery> getAllDeliveries() {

        List<Delivery> deliveries = new ArrayList<Delivery>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from delivery");
            while (rs.next()) {
                Delivery delivery = new Delivery();
                delivery.setId(rs.getInt("id"));
                delivery.setUserId(rs.getInt("user_id"));
                delivery.setSendersFirstName(rs.getString("senders_first_name"));
                delivery.setSendersLastName(rs.getString("senders_last_name"));
                delivery.setRecipientFirstName(rs.getString("recipient_first_name"));
                delivery.setRecipientLastName(rs.getString("recipient_last_name"));
                delivery.setFromCity(rs.getInt("city_from_id"));
                delivery.setToCity(rs.getInt("city_to_id"));
                delivery.setGoodsType(rs.getInt("goods_type_id"));
                delivery.setWeight(rs.getDouble("weight"));
                delivery.setSendersPhone(rs.getString("senders_phone"));
                delivery.setRecipientPhone(rs.getString("recipient_phone"));
                delivery.setSentDate(rs.getDate("sent_date"));
                delivery.setDeliveryDate(rs.getDate("delivery_date"));
                delivery.setPrice(rs.getDouble("price"));
                delivery.setPaymentStatus(rs.getString("paymentStatus"));
                deliveries.add(delivery);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return deliveries;
    }

    public void addDelivery(Delivery delivery) {

        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("insert into delivery(user_id, senders_first_name, senders_last_name," +
                            " recipient_first_name, recipient_last_name, city_from_id,city_to_id, goods_type_id," +
                            " weight,senders_phone, recipient_phone, sent_date, delivery_date, price, paymentStatus)" +
                            "values ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

            preparedStatement.setInt(1, delivery.getUserId());
            preparedStatement.setString(2, delivery.getSendersFirstName());
            preparedStatement.setString(3, delivery.getSendersLastName());
            preparedStatement.setString(4, delivery.getRecipientFirstName());
            preparedStatement.setString(5, delivery.getRecipientLastName());
            preparedStatement.setInt(6, delivery.getFromCity());
            preparedStatement.setInt(7, delivery.getToCity());
            preparedStatement.setInt(8, delivery.getGoodsType());
            preparedStatement.setDouble(9, delivery.getWeight());
            preparedStatement.setString(10, delivery.getSendersPhone());
            preparedStatement.setString(11, delivery.getRecipientPhone());
            preparedStatement.setDate(12, new Date(delivery.getSentDate().getTime()));
            preparedStatement.setDate(13, new Date(delivery.getDeliveryDate().getTime()));
            preparedStatement.setDouble(14,delivery.getPrice());
            preparedStatement.setString(15,delivery.getPaymentStatus());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void deleteDelivery(int id) {

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from " +
                    "delivery  where id=?");
            // Parameters start with 1
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateDelivery(Delivery delivery) {

        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("Update delivery set user_id=?, senders_first_name=?, senders_last_name=?," +
                            " recipient_first_name=?, recipient_last_name=?, city_from_id=?, city_to_id=?, goods_type_id=?," +
                            " weight=?, senders_phone=?, recipient_phone=?, sent_date=?,delivery_date=?, price=?, paymentStatus=? " +
                            "where id =?");

            // Parameters start with 1

            preparedStatement.setInt(1, delivery.getUserId());
            preparedStatement.setString(2, delivery.getSendersFirstName());
            preparedStatement.setString(3, delivery.getSendersLastName());
            preparedStatement.setString(4, delivery.getRecipientFirstName());
            preparedStatement.setString(5, delivery.getRecipientLastName());
            preparedStatement.setInt(6, delivery.getFromCity());
            preparedStatement.setInt(7, delivery.getToCity());
            preparedStatement.setInt(8, delivery.getGoodsType());
            preparedStatement.setDouble(9, delivery.getWeight());
            preparedStatement.setString(10, delivery.getSendersPhone());
            preparedStatement.setString(11, delivery.getRecipientPhone());
            preparedStatement.setDate(12, new Date(delivery.getSentDate().getTime()));
            preparedStatement.setDate(13, new Date(delivery.getDeliveryDate().getTime()));
            preparedStatement.setDouble(14, delivery.getPrice());
            preparedStatement.setString(15, delivery.getPaymentStatus());
            preparedStatement.setInt(16, delivery.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public java.util.Date stringToDate(String s) {//method which make type Date - String
        java.util.Date date = null;
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            date = dateFormat.parse(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date;
    }

    public Delivery getDeliveryById(int id) {

        Delivery delivery = new Delivery();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from delivery where id=?");
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                delivery.setId(rs.getInt("id"));
                delivery.setUserId(rs.getInt("user_Id"));
                delivery.setSendersFirstName(rs.getString("senders_first_name"));
                delivery.setSendersLastName(rs.getString("senders_last_name"));
                delivery.setRecipientFirstName(rs.getString("recipient_first_name"));
                delivery.setRecipientLastName(rs.getString("recipient_last_name"));
                delivery.setFromCity(rs.getInt("city_from_id"));
                delivery.setToCity(rs.getInt("city_to_id"));
                delivery.setGoodsType(rs.getInt("goods_type_id"));
                delivery.setWeight(rs.getDouble("weight"));
                delivery.setSendersPhone(rs.getString("senders_phone"));
                delivery.setRecipientPhone(rs.getString("recipient_phone"));
                delivery.setSentDate(rs.getDate("sent_date"));
                delivery.setDeliveryDate(rs.getDate("delivery_date"));
                delivery.setPrice(rs.getDouble("price"));
                delivery.setPaymentStatus(rs.getString("paymentStatus"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return delivery;
    }

}