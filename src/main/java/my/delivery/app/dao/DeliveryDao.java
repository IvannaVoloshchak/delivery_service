package my.delivery.app.dao;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import my.delivery.app.util.DbUtil;

import my.delivery.app.model.Delivery;

public class DeliveryDao {
    private Connection connection;

    public DeliveryDao() {

        connection = DbUtil.getConnection();
    }
    public  List<Delivery> getAllDeliveries() {

        List<Delivery> deliveries = new ArrayList<Delivery>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from delivery");
            while (rs.next()) {
                Delivery delivery = new Delivery();
                delivery.setId(rs.getInt("id"));
                delivery.setSenders_name(rs.getString("senders_name"));
                delivery.setRecipient_name(rs.getString("recipient_name"));
                delivery.setSenders_address( rs.getString("senders_address"));
                delivery.setRecipient_address(rs.getString("recipient_address"));
                delivery.setDelivery_type(rs.getString("delivery_type"));
                delivery.setWeight(rs.getDouble("weight"));
                delivery.setSent_date(rs.getDate("sent_date"));
                delivery.setDelivery_date(rs.getDate("delivery_date"));
                deliveries.add(delivery);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return deliveries;
    }
    public  void addDelivery(Delivery delivery) {

        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("insert into delivery(senders_name,recipient_name," +
                            "senders_address,recipient_address,delivery_type,weight,sent_date,delivery_date)values ( ?, ?, ?, ?, ?, ?, ?, ?)");

            preparedStatement.setString(1, delivery.getSenders_name());
            preparedStatement.setString(2, delivery.getRecipient_name());
            preparedStatement.setString(3, delivery.getSenders_address());
            preparedStatement.setString(4, delivery.getRecipient_address());
            preparedStatement.setString(5, delivery.getDelivery_type());
            preparedStatement.setDouble(6, delivery.getWeight());
            preparedStatement.setDate(7, new Date(delivery.getSent_date().getTime()));
            preparedStatement.setDate(8, new Date(delivery.getDelivery_date().getTime()));

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public  void deleteDelivery(int id) {

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
                    .prepareStatement("Update delivery set senders_name =?, recipient_name =?," +
                            " senders_address =?, recipient_address =?," +
                            " delivery_type =?, weight =?, sent_date =?, delivery_date =?   where id =?");

            // Parameters start with 1

            preparedStatement.setString(1, delivery.getSenders_name());
            preparedStatement.setString(2, delivery.getRecipient_name());
            preparedStatement.setString(3, delivery.getSenders_address());
            preparedStatement.setString(4, delivery.getRecipient_address());
            preparedStatement.setString(5, delivery.getDelivery_type());
            preparedStatement.setDouble(6, delivery.getWeight());
            preparedStatement.setDate(7, new Date(delivery.getSent_date().getTime()));
            preparedStatement.setDate(8, new Date(delivery.getDelivery_date().getTime()));

            preparedStatement.setInt(9, delivery.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public  java.util.Date stringToDate(String s) {//method which make type Date - String
        java.util.Date date = null;
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            date = dateFormat.parse(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date;
    }
    public  Delivery getDeliveryById(int id) {

        Delivery delivery = new Delivery();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from delivery where id=?");
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                delivery.setId(rs.getInt("id"));
                delivery.setSenders_name(rs.getString("senders_name"));
                delivery.setRecipient_name(rs.getString("recipient_name"));
                delivery.setSenders_address( rs.getString("senders_address"));
                delivery.setRecipient_address(rs.getString("recipient_address"));
                delivery.setDelivery_type(rs.getString("delivery_type"));
                delivery.setWeight(rs.getDouble("weight"));
                delivery.setSent_date(rs.getDate("sent_date"));
                delivery.setDelivery_date(rs.getDate("delivery_date"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return delivery;
    }
}