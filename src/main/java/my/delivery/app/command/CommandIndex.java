package my.delivery.app.command;

import my.delivery.app.dao.CityDao;
import my.delivery.app.dao.DaoFactory;
import my.delivery.app.dao.DistanceDao;
import my.delivery.app.dao.GoodsTypeDao;
import my.delivery.app.resourсesBundle.PageConfigManager;
import org.apache.log4j.Logger;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CommandIndex implements ICommand {
    public static Logger consLogger = Logger.getLogger("CONS");
    private GoodsTypeDao goodsTypeDao;
    private CityDao cityDao;
    private DistanceDao distanceDao;

    public CommandIndex(){
        goodsTypeDao = DaoFactory.getDaoFactory().getGoodsTypeDao();
        cityDao= DaoFactory.getDaoFactory().getCityDao();
        distanceDao = DaoFactory.getDaoFactory().getDistanceDao();
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("types", goodsTypeDao.getAllGoodsTypes());
        request.setAttribute("cities", cityDao.getAllCities());
        request.setAttribute("distances", distanceDao.getAllDistances());
        consLogger.info("Customer is on the main page");

        return PageConfigManager.getProperty("path.page.index");
    }
}
