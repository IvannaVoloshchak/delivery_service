package my.delivery.app.command;

import my.delivery.app.dao.CityDao;
import my.delivery.app.dao.DaoFactory;
import my.delivery.app.dao.GoodsTypeDao;
import my.delivery.app.dao.UserDao;
import my.delivery.app.model.User;
import my.delivery.app.resourсesBundle.PageConfigManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CommandAddUser implements ICommand {
    private GoodsTypeDao goodsTypeDao;
    private CityDao cityDao;
    private UserDao userDao;

    public CommandAddUser() {
        goodsTypeDao = DaoFactory.getDaoFactory().getGoodsTypeDao();
        cityDao= DaoFactory.getDaoFactory().getCityDao();
        userDao =DaoFactory.getDaoFactory().getUserDao();
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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
        } else {
            user.setId(Integer.parseInt(id));
            userDao.updateUser(user);
        }
        request.setAttribute("types", goodsTypeDao.getAllGoodsTypes());
        request.setAttribute("cities", cityDao.getAllCities());

        return PageConfigManager.getProperty("path.page.index");
    }
}
