package my.delivery.app.command;

import my.delivery.app.dao.DaoFactory;
import my.delivery.app.dao.DeliveryDao;
import my.delivery.app.dao.UserDao;
import my.delivery.app.model.Delivery;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CommandPayForDelivery implements ICommand {
    private static String LIST_DELIVERY = "/listDelivery.jsp";
    private DeliveryDao dao;
    private UserDao userDao;

    public CommandPayForDelivery() {
        dao = DaoFactory.getDaoFactory().getDeliveryDao();
        userDao = DaoFactory.getDaoFactory().getUserDao();
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        Delivery delivery = dao.getDeliveryById(id);
        delivery.setPaymentStatus("paid");
        dao.updateDelivery(delivery);
        request.setAttribute("deliveries", dao.getAllDeliveries());
        return LIST_DELIVERY;
    }
}
