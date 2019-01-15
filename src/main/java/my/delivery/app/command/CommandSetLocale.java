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
/**
        * Description: This describes actions of set local language.
        * @author Ivanna Voloshchak
        */
public class CommandSetLocale implements ICommand {
    public static Logger consLogger = Logger.getLogger("CONS");
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
           consLogger.info("Locale EN was setted");
        } else {
            consLogger.info("Locale UA was setted");
        }
         consLogger.info("User changed language");
        return PageConfigManager.getProperty(key);
    }
}
