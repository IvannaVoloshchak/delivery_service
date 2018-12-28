package my.delivery.app.command;

import my.delivery.app.dao.CityDao;
import my.delivery.app.dao.DaoFactory;
import my.delivery.app.dao.DeliveryDao;
import my.delivery.app.dao.GoodsTypeDao;
import my.delivery.app.resourсesBundle.PageConfigManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CommandCreateDelivery implements ICommand {

    private DeliveryDao dao;
    private GoodsTypeDao goodsTypeDao;
    private CityDao cityDao;

    public CommandCreateDelivery() {
        goodsTypeDao = DaoFactory.getDaoFactory().getGoodsTypeDao();
        cityDao= DaoFactory.getDaoFactory().getCityDao();
        dao = DaoFactory.getDaoFactory().getDeliveryDao();
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("types", goodsTypeDao.getAllGoodsTypes());
        request.setAttribute("cities", cityDao.getAllCities());

        return PageConfigManager.getProperty("path.page.insertOrEdit");
    }
}
