package my.delivery.app.util;



import my.delivery.app.dao.DeliveryDao;
import my.delivery.app.model.Delivery;

import java.util.Date;


public class ConnectionTry {

    public static void main(String[] args) {
        DeliveryDao userDao= new DeliveryDao();
//        List<Delivery> allDeliveries= getAllDeliveries();
//        System.out.println(allDeliveries);
        Delivery delivery1= new Delivery();
        delivery1.setSenders_name("Bohdan");
        delivery1.setRecipient_name("Sydorov");
        delivery1.setSenders_address("Kiev Shevchenka 23");
        delivery1.setRecipient_address("Lviv Konovaltsca 4");
        delivery1.setDelivery_type("box");
        delivery1.setWeight(4.7);
        delivery1.setSent_date(new Date());
        delivery1.setDelivery_date(new Date());
        delivery1.setId(7);

         // addDelivery(delivery1);
       // deleteDelivery(5);


        userDao.updateDelivery(delivery1);
//        Delivery delivery=getDeliveryById(7);
//        System.out.println(delivery);

    }
//    public static List<Delivery> getAllDeliveries() {
//     Connection connection = DbUtil.getConnection();
//        List<Delivery> deliveries = new ArrayList<Delivery>();
//        try {
//            Statement statement = connection.createStatement();
//            ResultSet rs = statement.executeQuery("select * from delivery");
//            while (rs.next()) {
//                Delivery delivery = new Delivery();
//                delivery.setId(rs.getInt("id"));
//                delivery.setSenders_name(rs.getString("senders_name"));
//                delivery.setRecipient_name(rs.getString("recipient_name"));
//                delivery.setSenders_address( rs.getString("senders_address"));
//                delivery.setRecipient_address(rs.getString("recipient_address"));
//                delivery.setDelivery_type(rs.getString("delivery_type"));
//                delivery.setWeight(rs.getDouble("weight"));
//                delivery.setSent_date(rs.getDate("sent_date"));
//                delivery.setDelivery_date(rs.getDate("delivery_date"));
//                deliveries.add(delivery);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//       return deliveries;
//    }
//
//    public static void addDelivery(Delivery delivery) {
//        Connection connection=DbUtil.getConnection();
//        try {
//            PreparedStatement preparedStatement = connection.
//                   prepareStatement("insert into delivery(senders_name,recipient_name," +
//                            "senders_address," +
//                           "recipient_address," +
//                           "delivery_type,weight,sent_date,delivery_date)values ( ?, ?, ?, ?, ?, ?, ?, ?)");
//
//
//           preparedStatement.setString(1, delivery.getSenders_name());
//           preparedStatement.setString(2, delivery.getRecipient_name());
//           preparedStatement.setString(3, delivery.getSenders_address());
//           preparedStatement.setString(4, delivery.getRecipient_address());
//           preparedStatement.setString(5, delivery.getDelivery_type());
//           preparedStatement.setDouble(6, delivery.getWeight());
//           preparedStatement.setDate(7, new Date(delivery.getSent_date().getTime()));
//           preparedStatement.setDate(8, new Date(delivery.getDelivery_date().getTime()));
//
//            preparedStatement.executeUpdate();
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//    public static void deleteDelivery(int id) {
//        Connection connection=DbUtil.getConnection();
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement("delete from " +
//                    "delivery  where id=?");
//            // Parameters start with 1
//            preparedStatement.setInt(1, id);
//            preparedStatement.executeUpdate();
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//        public static void updateDelivery(Delivery delivery) {
//            Connection connection=DbUtil.getConnection();
//        try {
//            PreparedStatement preparedStatement = connection
//                    .prepareStatement("Update delivery set senders_name =?, recipient_name =?," +
//                            " senders_address =?, recipient_address =?," +
//                            " delivery_type =?, weight =?, sent_date =?, delivery_date =?  + where id =?");
//
//            // Parameters start with 1
//
//            preparedStatement.setString(1, delivery.getSenders_name());
//            preparedStatement.setString(2, delivery.getRecipient_name());
//            preparedStatement.setString(3, delivery.getSenders_address());
//            preparedStatement.setString(4, delivery.getRecipient_address());
//            preparedStatement.setString(5, delivery.getDelivery_type());
//            preparedStatement.setDouble(6, delivery.getWeight());
//            preparedStatement.setDate(7, new Date(delivery.getSent_date().getTime()));
//            preparedStatement.setDate(8, new Date(delivery.getDelivery_date().getTime()));
//
//            preparedStatement.setInt(9, delivery.getId());
//
//            preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//    public static java.util.Date stringToDate(String s) {//method which make type Date - String
//        java.util.Date date = null;
//        try {
//            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//            date = dateFormat.parse(s);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return date;
//    }
//
//    public static Delivery getDeliveryById(int id) {
//        Connection connection=DbUtil.getConnection();
//        Delivery delivery = new Delivery();
//        try {
//            PreparedStatement preparedStatement = connection.
//                    prepareStatement("select * from delivery where id=?");
//            preparedStatement.setInt(1, id);
//            ResultSet rs = preparedStatement.executeQuery();
//
//            if (rs.next()) {
//                delivery.setId(rs.getInt("id"));
//                delivery.setSenders_name(rs.getString("senders_name"));
//                delivery.setRecipient_name(rs.getString("recipient_name"));
//                delivery.setSenders_address( rs.getString("senders_address"));
//                delivery.setRecipient_address(rs.getString("recipient_address"));
//                delivery.setDelivery_type(rs.getString("delivery_type"));
//                delivery.setWeight(rs.getDouble("weight"));
//                delivery.setSent_date(rs.getDate("sent_date"));
//                delivery.setDelivery_date(rs.getDate("delivery_date"));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return delivery;
//    }
}


