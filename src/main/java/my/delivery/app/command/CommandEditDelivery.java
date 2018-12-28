package my.delivery.app.command;

import my.delivery.app.dao.*;
import my.delivery.app.model.Delivery;
import my.delivery.app.resourсesBundle.PageConfigManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CommandEditDelivery  implements ICommand {

    private DeliveryDao dao;
    private GoodsTypeDao goodsTypeDao;
    private CityDao cityDao;
    private DistanceDao distanceDao;
    private FareDao fareDao;
    public CommandEditDelivery() {
        goodsTypeDao = DaoFactory.getDaoFactory().getGoodsTypeDao();
        cityDao= DaoFactory.getDaoFactory().getCityDao();
        dao = DaoFactory.getDaoFactory().getDeliveryDao();
        distanceDao = DaoFactory.getDaoFactory().getDistanceDao();
        fareDao= DaoFactory.getDaoFactory().getFareDao();

    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Delivery delivery = dao.getDeliveryById(id);
        request.setAttribute("delivery", delivery);
        request.setAttribute("types", goodsTypeDao.getAllGoodsTypes());
        request.setAttribute("cities", cityDao.getAllCities());
        request.setAttribute("distances", distanceDao.getAllDistances());
        return  PageConfigManager.getProperty("path.page.insertOrEdit");
    }
}
