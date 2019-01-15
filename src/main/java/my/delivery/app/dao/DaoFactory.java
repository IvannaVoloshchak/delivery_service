package my.delivery.app.dao;

import my.delivery.app.util.PropertyUtil;
/**
 * Description: This abstract class allowed to work with different type of databases,
 * and return the DAO object according the database we choose.
 * <p>
 * @author  Ivanna Voloshchak
 */

public abstract class DaoFactory {

    public abstract CityDao getCityDao();

    public abstract DeliveryDao getDeliveryDao();

    public abstract DistanceDao getDistanceDao();

    public abstract FareDao getFareDao();

    public abstract GoodsTypeDao getGoodsTypeDao();

    public abstract UserDao getUserDao();

    public abstract UserTypeDao getUserTypeDao();
    /**
     * This method return the object of concrete factory
     *
     * @param       - type of factory which will be created.     *
     * @return              - object DAO factory.
     */
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
