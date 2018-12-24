package my.delivery.app.command;

import my.delivery.app.dao.*;
import my.delivery.app.model.User;
import my.delivery.app.util.ConnectionPool;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CommandSignOut implements ICommand  {
    private static String INDEX = "/index.jsp";
    private GoodsTypeDao goodsTypeDao;
    private CityDao cityDao;
    private DistanceDao distanceDao;
    private static final Logger LOGGER = Logger.getLogger(ConnectionPool.class);
    public CommandSignOut(){
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
        User user = (User) session.getAttribute("currentUser");
        if (user != null) {
            LOGGER.info("User " + user.getFirstName() + " " + user.getLastName() + " " + " log out");
        }
        session.invalidate();
        return INDEX;
    }
}
