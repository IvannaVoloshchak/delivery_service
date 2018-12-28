package my.delivery.app.command;

import my.delivery.app.dao.CityDao;
import my.delivery.app.dao.DaoFactory;
import my.delivery.app.dao.DistanceDao;
import my.delivery.app.dao.GoodsTypeDao;
import my.delivery.app.resourсesBundle.PageConfigManager;
import my.delivery.app.util.ConnectionPool;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CommandSetLocale implements ICommand {
    private static final Logger LOGGER =Logger.getLogger(ConnectionPool.class);
    private GoodsTypeDao goodsTypeDao;
    private CityDao cityDao;
    private DistanceDao distanceDao;
    public CommandSetLocale(){
        goodsTypeDao = DaoFactory.getDaoFactory().getGoodsTypeDao();
        cityDao = DaoFactory.getDaoFactory().getCityDao();
        distanceDao = DaoFactory.getDaoFactory().getDistanceDao();
    }
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("types", goodsTypeDao.getAllGoodsTypes());
        request.setAttribute("cities", cityDao.getAllCities());
        request.setAttribute("distances", distanceDao.getAllDistances());
        HttpSession session = request.getSession(true);

        String key = request.getParameter("currentPage");
        String locale = request.getParameter("locale");
        session.setAttribute("locale", locale);

        if (locale.equals("1")) {
            LOGGER.info("Locale EN was setted");
        } else {
            LOGGER.info("Locale UA was setted");
        }

        return PageConfigManager.getProperty(key);
    }
}
