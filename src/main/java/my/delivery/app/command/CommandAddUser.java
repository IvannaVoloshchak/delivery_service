package my.delivery.app.command;

import my.delivery.app.dao.CityDao;
import my.delivery.app.dao.DaoFactory;
import my.delivery.app.dao.GoodsTypeDao;
import my.delivery.app.dao.UserDao;
import my.delivery.app.model.User;
import my.delivery.app.resourсesBundle.PageConfigManager;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/**
 * Description: This describes actions of registration new user.
 * @author Ivanna Voloshchak
 */

public class CommandAddUser implements ICommand {
    public static Logger consLogger = Logger.getLogger("CONS");
    private GoodsTypeDao goodsTypeDao;
    private CityDao cityDao;
    private UserDao userDao;

    public CommandAddUser() {
        goodsTypeDao = DaoFactory.getDaoFactory().getGoodsTypeDao();
        cityDao = DaoFactory.getDaoFactory().getCityDao();
        userDao = DaoFactory.getDaoFactory().getUserDao();
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        if (userDao.checkUserExist(login)) {
            String errorMessage = "You entered login which one is already exist. Please try another login ";
            request.setAttribute("errorMessage", errorMessage);
            return PageConfigManager.getProperty("path.page.registration");
        }
        User user = new User();
        user.setTypeId(1);
        user.setLogin(request.getParameter("login"));
        user.setPassword(request.getParameter("password"));
        user.setFirstName(request.getParameter("first_name"));
        user.setLastName(request.getParameter("last_name"));
        user.setPhoneNumber(request.getParameter("phone_number"));
        user.setEmail(request.getParameter("email"));

        String id = request.getParameter("id");
        if (id == null || id.isEmpty()) {
            userDao.addUser(user);
            consLogger.info("Add new user " + user.getLogin() + " in DB");
        } else {
            user.setId(Integer.parseInt(id));
            userDao.updateUser(user);
            consLogger.info("Update user " + user.getLogin() + " in DB");
        }
        request.setAttribute("types", goodsTypeDao.getAllGoodsTypes());
        request.setAttribute("cities", cityDao.getAllCities());


        return PageConfigManager.getProperty("path.page.index");
    }
}
