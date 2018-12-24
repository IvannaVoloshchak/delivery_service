package my.delivery.app.dao;

import my.delivery.app.dao.impl.*;

public class MySqlDaoFactory extends DaoFactory {
    @Override
    public CityDao getCityDao() {
        return new CityDaoImpl();
    }

   @Override
    public DeliveryDao getDeliveryDao() {
        return new DeliveryDaoImpl();
    }

    @Override
    public DistanceDao getDistanceDao() {
        return new DistanceDaoImpl();
    }

  @Override
    public FareDao getFareDao() {
        return new FareDaoImpl();
    }

    @Override
    public GoodsTypeDao getGoodsTypeDao() {
        return new GoodsTypeDaoImpl();
    }

    @Override
    public UserDao getUserDao() {
        return new UserDaoImpl();
    }

   @Override
    public UserTypeDao getUserTypeDao() {
        return new UserTypeDaoImpl();
    }
}
