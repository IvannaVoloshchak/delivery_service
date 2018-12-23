package my.delivery.app.dao;

import my.delivery.app.util.PropertyUtil;

import java.util.Properties;

public abstract class DaoFactory {

     public abstract CityDao getCityDao();

     public abstract DeliveryDao getDeliveryDao();

     public abstract DistanceDao getDistanceDao();

     public abstract FareDao getFareDao();

     public abstract GoodsTypeDao getGoodsTypeDao();

    public abstract UserDao getUserDao();

   public abstract UserTypeDao getUserTypeDao();

    public static DaoFactory getDaoFactory() {
        String dbType = PropertyUtil.getDbProperty("databasetype");
        DBType type = DBType.valueOf(dbType.toUpperCase());
        switch (type) {
            case MYSQL:
                return new MySqlDaoFactory();
            case ORACLE:
                //return new OracleDAOFactory();
            case SYBASE:
                //return new SybaseDAOFactory();
            default:
                return null;
        }
    }

}
