package my.delivery.app.util;



import my.delivery.app.dao.DeliveryDao;
import my.delivery.app.dao.DistanceDao;
import my.delivery.app.dao.FareDao;
import my.delivery.app.dao.GoodsTypeDao;
import my.delivery.app.model.*;
import my.delivery.app.service.DeliveryCalculator;

import java.sql.*;

public class ConnectionTry {

    public static void main(String[] args) {
        FareDao fareDao= new FareDao();
        Fare FareValue= fareDao.getFareByIdGoodsType(2);
        double minPrice= FareValue.getMinimumPrice();
        double pricePerKg= FareValue.getPricePerKilogram();
        double priceByKm=FareValue.getPricePerKilometer();
        DistanceDao distanceDao = new DistanceDao();
        Distance getDistanceValue= distanceDao.getDistanceByIdCity(3, 4);
        int distance =getDistanceValue.getDistance();
        System.out.println( DeliveryCalculator.calculateDeliveryPrice(minPrice, pricePerKg, priceByKm,distance,1.5));




//        CityDao cityDao = new CityDao();
//        List<City> cities = cityDao.getAllCities();
//        System.out.println(cities);
//        DistanceDao distanceDao = new DistanceDao();
//        Distance distance = getDistanceById(3);
//        System.out.println(distance);
//
//        GoodsTypeDao goodsTypeDao= new GoodsTypeDao();
//        List <GoodsType> allGoodsType = getAllGoodsTypes();
//        System.out.println(allGoodsType);

//        FareDao fareDao=new FareDao();
//        List<Fare> allFare= getAllFare();
//        System.out.println(allFare);
//        Fare fare = new Fare();
//        fare.setFrom_city("Kiev");
//        fare.setTo_city("Lviv");
//        fare.setName("box");
//        fare.setWeight(4.5);
//        fare.calculateDeliveryPrice(100.0);
//        addFare(fare);

//        DeliveryDao userDao= new DeliveryDao();
//        List<Delivery> allDeliveries= getAllDeliveries();
//       System.out.println("\n"+ allDeliveries);
//        Delivery delivery1= new Delivery();
//        delivery1.setSendersFirstName("Bohdan");
//        delivery1.setSendersLastName("Tyrchun");
//        delivery1.setRecipientFirstName("Andriy");
//        delivery1.setRecipientLastName("Shushkin");
//        delivery1.setFromCity("Kiev ");
//        delivery1.setToCity("Lviv ");
//        delivery1.setGoodsType("box");
//        delivery1.setWeight(4.9);
//        delivery1.setSendersPhone("0952347567");
//        delivery1.setRecipientPhone("0972355567");
//        delivery1.setSentDate(new Date(2018/12/12));
//        delivery1.setDeliveryDate(new Date(2018/12/22));
//        delivery1.setId(27);
//        updateDelivery(delivery1);
        //addDelivery(delivery1);
//       // deleteDelivery(5);
//
//
//       // userDao.updateDelivery(delivery1);
////        Delivery delivery=getDeliveryById(7);
////        System.out.println(delivery);
////        UserType userType = getUserTypeById(2);
////        System.out.println(userType);
//        Distance distance= getDistanceByIdCity(1,2);
//        System.out.println(distance);
//
//        Fare fare = getFareByIdGoodsType(2);
//        System.out.println(fare);
    }
//    public static Fare getFareByIdGoodsType(int id) {
//        Connection connection= DbUtil.getConnection();
//        Fare fare = new Fare();
//        try {
//            PreparedStatement preparedStatement = connection.
//                    prepareStatement("select * from fare where id_goods_type=?");
//            preparedStatement.setInt(1, id);
//            ResultSet rs = preparedStatement.executeQuery();
//
//            if (rs.next()) {
//                fare.setId(rs.getInt("id"));
//                fare.setIdGoodsType(rs.getInt("id_goods_type"));
//                fare.setMinimumPrice(rs.getDouble("minimum_price"));
//                fare.setPricePerKilogram(rs.getDouble("price_per_kilogram"));
//
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return fare;
//    }
//    public static Distance getDistanceByIdCity(int idFrom, int idTo ) {
//        Connection connection= DbUtil.getConnection();
//        Distance distance = new Distance();
//        try {
//            PreparedStatement preparedStatement = connection.
//                    prepareStatement("select * from delivery_service.distance where id_from=? and id_to=?");
//            preparedStatement.setInt(1, idFrom);
//            preparedStatement.setInt(2, idTo);
//            ResultSet rs = preparedStatement.executeQuery();
//
//            if (rs.next()) {
//                distance.setId(rs.getInt("id"));
//                distance.setIdFrom(rs.getInt("id_from"));
//                distance.setIdTo(rs.getInt("id_to"));
//                distance.setDistance(rs.getInt("distance"));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return distance;
//    }
////    public static List<Delivery> getAllDeliveries() {
//        Connection connection= DbUtil.getConnection();
//        List<Delivery> deliveries = new ArrayList<Delivery>();
//        try {
//            Statement statement = connection.createStatement();
//            ResultSet rs = statement.executeQuery("select * from delivery");
//            while (rs.next()) {
//                Delivery delivery = new Delivery();
//                delivery.setId(rs.getInt("id"));
//                delivery.setSendersFirstName(rs.getString("senders_first_name"));
//                delivery.setSendersLastName(rs.getString("senders_last_name"));
//                delivery.setRecipientFirstName(rs.getString("recipient_first_name"));
//                delivery.setRecipientLastName(rs.getString("recipient_last_name"));
//                delivery.setFromCity(rs.getString("from_city"));
//                delivery.setToCity(rs.getString("to_city"));
//                delivery.setGoodsType(rs.getString("goods_type"));
//                delivery.setWeight(rs.getDouble("weight"));
//                delivery.setSendersPhone(rs.getString("senders_phone"));
//                delivery.setRecipientPhone(rs.getString("recipient_phone"));
//                delivery.setSentDate(rs.getDate("sent_date"));
//                delivery.setDeliveryDate(rs.getDate("delivery_date"));
//                deliveries.add(delivery);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return deliveries;
//    }
//
//    public static void addDelivery (Delivery delivery) {
//        Connection connection= DbUtil.getConnection();
//        try {
//            PreparedStatement preparedStatement = connection.
//                    prepareStatement("insert into delivery(senders_first_name, senders_last_name," +
//                            " recipient_first_name, recipient_last_name, from_city,to_city, goods_type," +
//                            " weight,senders_phone, recipient_phone, sent_date, delivery_date)" +
//                            "values ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
//
//            preparedStatement.setString(1, delivery.getSendersFirstName());
//            preparedStatement.setString(2, delivery.getSendersLastName());
//            preparedStatement.setString(3, delivery.getRecipientFirstName());
//            preparedStatement.setString(4, delivery.getRecipientLastName());
//            preparedStatement.setString(5, delivery.getFromCity());
//            preparedStatement.setString(6, delivery.getToCity());
//            preparedStatement.setString(7, delivery.getGoodsType());
//            preparedStatement.setDouble(8, delivery.getWeight());
//            preparedStatement.setString(9, delivery.getSendersPhone());
//            preparedStatement.setString(10, delivery.getRecipientPhone());
//            preparedStatement.setDate(11, new Date(delivery.getSentDate().getTime()));
//            preparedStatement.setDate(12, new Date(delivery.getDeliveryDate().getTime()));
//
//            preparedStatement.executeUpdate();
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//
//    public static void deleteDelivery(int id) {
//        Connection connection= DbUtil.getConnection();
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
//
//    public static void updateDelivery(Delivery delivery) {
//        Connection connection= DbUtil.getConnection();
//        try {
//            PreparedStatement preparedStatement = connection
//                    .prepareStatement("Update delivery set senders_first_name=?, senders_last_name=?," +
//                            " recipient_first_name=?, recipient_last_name=?, from_city=?, to_city=?, goods_type=?," +
//                            " weight=?, senders_phone=?, recipient_phone=?, sent_date=?,delivery_date=?  " +
//                            "where id =?");
//
//            // Parameters start with 1
//
//            preparedStatement.setString(1, delivery.getSendersFirstName());
//            preparedStatement.setString(2, delivery.getSendersLastName());
//            preparedStatement.setString(3, delivery.getRecipientFirstName());
//            preparedStatement.setString(4, delivery.getRecipientLastName());
//            preparedStatement.setString(5, delivery.getFromCity());
//            preparedStatement.setString(6, delivery.getToCity());
//            preparedStatement.setString(7, delivery.getGoodsType());
//            preparedStatement.setDouble(8, delivery.getWeight());
//            preparedStatement.setString(9, delivery.getSendersPhone());
//            preparedStatement.setString(10, delivery.getRecipientPhone());
//            preparedStatement.setDate(11, new Date(delivery.getSentDate().getTime()));
//            preparedStatement.setDate(12, new Date(delivery.getDeliveryDate().getTime()));
//            preparedStatement.setInt(13, delivery.getId());
//
//            preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public java.util.Date stringToDate(String s) {//method which make type Date - String
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
//        Connection connection= DbUtil.getConnection();
//        Delivery delivery = new Delivery();
//        try {
//            PreparedStatement preparedStatement = connection.
//                    prepareStatement("select * from delivery where id=?");
//            preparedStatement.setInt(1, id);
//            ResultSet rs = preparedStatement.executeQuery();
//
//            if (rs.next()) {
//                delivery.setId(rs.getInt("id"));
//                delivery.setSendersFirstName(rs.getString("senders_first_name"));
//                delivery.setSendersLastName(rs.getString("senders_last_name"));
//                delivery.setRecipientFirstName(rs.getString("recipient_first_name"));
//                delivery.setRecipientLastName(rs.getString("recipient_last_name"));
//                delivery.setFromCity(rs.getString("from_city"));
//                delivery.setToCity(rs.getString("to_city"));
//                delivery.setGoodsType(rs.getString("goods_type"));
//                delivery.setWeight(rs.getDouble("weight"));
//                delivery.setSendersPhone(rs.getInt("senders_phone"));
//                delivery.setRecipientPhone(rs.getInt("recipient_phone"));
//                delivery.setSentDate(rs.getDate("sent_date"));
//                delivery.setDeliveryDate(rs.getDate("delivery_date"));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return delivery;
//    }
//    public static UserType getUserTypeById(int id) {
//        Connection connection= DbUtil.getConnection();
//        UserType userType = new UserType();
//        try {
//            PreparedStatement preparedStatement = connection.
//                    prepareStatement("select * from user_type where id=? ");
//            preparedStatement.setInt(1, id);
//            ResultSet rs = preparedStatement.executeQuery();
//
//            if (rs.next()) {
//                userType.setId(rs.getInt("id"));
//                userType.setName(rs.getString("name"));
//
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return userType;
//    }
//    public static List<City> getAllCities() {
//        Connection connection= DbUtil.getConnection();
//        List<City> cities = new ArrayList<>();
//        try {
//            Statement statement = connection.createStatement();
//            ResultSet rs = statement.executeQuery("select * from city");
//            while (rs.next()) {
//                City city = new City();
//                city.setId(rs.getInt("id"));
//                city.setName(rs.getString("name"));
//                cities.add(city);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }return cities;
//    }
//        public static List<GoodsType> getAllGoodsTypes() {
//            Connection connection = DbUtil.getConnection();
//            List<GoodsType> goodsTypes = new ArrayList<>();
//            try {
//                Statement statement = connection.createStatement();
//                ResultSet rs = statement.executeQuery("select * from goods_type");
//                while (rs.next()) {
//                    GoodsType goodsType= new GoodsType();
//                    goodsType.setIdGoodsType(rs.getInt("id_goods_type"));
//                    goodsType.setName(rs.getString("name"));
//                    goodsTypes.add(goodsType);
//                }
//
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//            return goodsTypes;
//        }


//    public static List<Fare> getAllFare() {
//        Connection connection = DbUtil.getConnection();
//        List<Fare> fares = new ArrayList<>();
//        try {
//            Statement statement = connection.createStatement();
//            ResultSet rs = statement.executeQuery("select * from delivery_service.fare");
//            while (rs.next()) {
//                Fare fare = new Fare();
//                fare.setIdFare(rs.getInt("id_fare"));
//                fare.setFrom_city(rs.getString("from_city"));
//                fare.setTo_city(rs.getString("to_city"));
//                fare.setName(rs.getString("delivery_type"));
//
//                fare.calculateDeliveryPrice(rs.getDouble("price"));
//               fares.add(fare);
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return fares;
//    }

//    public static List<Delivery> getAllDeliveries() {
//     Connection connection = DbUtil.getConnection();
//        List<Delivery> deliveries = new ArrayList<Delivery>();
//        try {
//            Statement statement = connection.createStatement();
//            ResultSet rs = statement.executeQuery("select * from delivery");
//            while (rs.next()) {
//                Delivery delivery = new Delivery();
//                delivery.setIdFare(rs.getInt("id"));
//                delivery.setSenders_name(rs.getString("senders_name"));
//                delivery.setRecipient_name(rs.getString("recipient_name"));
//                delivery.setSenders_address( rs.getString("senders_address"));
//                delivery.setRecipient_address(rs.getString("recipient_address"));
//                delivery.setName(rs.getString("delivery_type"));
//                delivery.setWeight(rs.getDouble("weight"));
//                delivery.setSentDate(rs.getDate("sent_date"));
//                delivery.setDeliveryDate(rs.getDate("delivery_date"));
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
//           preparedStatement.setString(5, delivery.getName());
//           preparedStatement.setDouble(6, delivery.getWeight());
//           preparedStatement.setDate(7, new Date(delivery.getSentDate().getTime()));
//           preparedStatement.setDate(8, new Date(delivery.getDeliveryDate().getTime()));
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
//            preparedStatement.setString(5, delivery.getName());
//            preparedStatement.setDouble(6, delivery.getWeight());
//            preparedStatement.setDate(7, new Date(delivery.getSentDate().getTime()));
//            preparedStatement.setDate(8, new Date(delivery.getDeliveryDate().getTime()));
//
//            preparedStatement.setInt(9, delivery.getIdFare());
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
//    public static Distance getDistanceById(int id) {
//        Connection connection=DbUtil.getConnection();
//        Distance distance = new Distance();
//        try {
//            PreparedStatement preparedStatement = connection.
//                    prepareStatement("select * from distance where id=? ");
//            preparedStatement.setInt(1, id);
//            ResultSet rs = preparedStatement.executeQuery();
//
//            if (rs.next()) {
//                distance.setId(rs.getInt("id"));
//                distance.setIdFrom(rs.getInt("id_from"));
//                distance.setIdTo(rs.getInt("id_to"));
//                distance.setDistance(rs.getInt("distance"));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return distance;
//    }

}


