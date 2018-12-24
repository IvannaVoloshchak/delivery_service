package my.delivery.app.command;

import my.delivery.app.dao.DaoFactory;
import my.delivery.app.dao.DeliveryDao;
import my.delivery.app.dao.UserTypeDao;
import my.delivery.app.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CommandDeliveryList implements ICommand {

    private static String LIST_DELIVERY = "/listDelivery.jsp";
    private DeliveryDao dao;
    private UserTypeDao userTypeDao;

    public CommandDeliveryList() {
        dao = DaoFactory.getDaoFactory().getDeliveryDao();
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        User user = (User) session.getAttribute("user");
        userTypeDao=DaoFactory.getDaoFactory().getUserTypeDao();
        if (user.getTypeId() == userTypeDao.getUserTypeByName("operator").getId()) {
            request.setAttribute("deliveries", dao.getAllDeliveries());
        } else {
            request.setAttribute("deliveries", dao.getDeliveriesByUserId(user.getId()));
        }
        return LIST_DELIVERY;
    }
}
