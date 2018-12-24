package my.delivery.app.util;


import my.delivery.app.dao.DaoFactory;
import my.delivery.app.dao.UserDao;
import my.delivery.app.model.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConnectionTry {

    public static void main(String[] args) {

        User user = new User();
        user.setTypeId(1);
        user.setLogin("Tania11");
        user.setPassword("jafnejr133");
        user.setFirstName("Tania");
        user.setLastName("Trush");
        user.setPhoneNumber("6546842");
        user.setEmail("TrushTania34@gmail.com");
        addUser(user);


    }
    public static   void addUser(User user) {
        ConnectionPool pool = new ConnectionPool();
        Connection connection = pool.getConnection(false);

        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("insert into user(typeId," +
                            "login, password, first_name, last_name, phone_number, email)values ( ?, ?, ?, ?, ?, ?, ?)");


            preparedStatement.setInt(1, user.getTypeId());
            preparedStatement.setString(2, user.getLogin());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setString(4, user.getFirstName());
            preparedStatement.setString(5, user.getLastName());
            preparedStatement.setString(6, user.getPhoneNumber());
            preparedStatement.setString(7, user.getEmail());

            preparedStatement.executeUpdate();

            pool.commitTransaction(connection);
        } catch (SQLException e) {
            pool.transactionRollback(connection);
            e.printStackTrace();
        }
    }


    public static List<Delivery> getAllDeliveries() {
        ConnectionPool pool = new ConnectionPool();
        Connection connection = pool.getConnection(true);
        pool.commitTransaction(connection);
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



}


