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

public class CommandSignIn implements ICommand {
    private static String INDEX = "/index.jsp";
    private static String LOGIN = "/login.jsp";
    private UserDao userDao;
    private GoodsTypeDao goodsTypeDao;
    private CityDao cityDao;
    private DistanceDao distanceDao;

    public CommandSignIn() {
        goodsTypeDao = DaoFactory.getDaoFactory().getGoodsTypeDao();
        cityDao = DaoFactory.getDaoFactory().getCityDao();
        distanceDao = DaoFactory.getDaoFactory().getDistanceDao();
        userDao = DaoFactory.getDaoFactory().getUserDao();
    }

    private static final Logger LOGGER = Logger.getLogger(ConnectionPool.class);

    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("types", goodsTypeDao.getAllGoodsTypes());
        request.setAttribute("cities", cityDao.getAllCities());
        request.setAttribute("distances", distanceDao.getAllDistances());
        HttpSession session = request.getSession(true);
        String sessionId = session.getId();

        if (session.getAttribute("sessionId") == null) {
            session.setAttribute("sessionId", sessionId);
            LOGGER.info("Session " + session.getId() + " has started");
        }

        String login = request.getParameter("login");
        String password = request.getParameter("password");
        User user = DaoFactory.getDaoFactory().getUserDao().checkUser(login, password);
        if (user != null) {
            session.setAttribute("user", user);
            return INDEX;
        } else {
            String errorMessage = "You entered wrong login or password. Please try again ";
            request.setAttribute("errorMessage", errorMessage);
            return LOGIN;
        }
    }
}
