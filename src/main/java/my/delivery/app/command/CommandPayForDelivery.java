package my.delivery.app.command;

import my.delivery.app.dao.DaoFactory;
import my.delivery.app.dao.DeliveryDao;
import my.delivery.app.dao.UserDao;
import my.delivery.app.dao.UserTypeDao;
import my.delivery.app.model.Delivery;
import my.delivery.app.model.User;
import my.delivery.app.resourсesBundle.PageConfigManager;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
/**
        * Description: This describes actions of pay for delivery
        * @author Ivanna Voloshchak
        */
public class CommandPayForDelivery implements ICommand {
    public static Logger consLogger = Logger.getLogger("CONS");
    private DeliveryDao dao;
    private UserDao userDao;

    public CommandPayForDelivery() {
        dao = DaoFactory.getDaoFactory().getDeliveryDao();
        userDao = DaoFactory.getDaoFactory().getUserDao();
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        User user = (User) session.getAttribute("user");
        int id = Integer.parseInt(request.getParameter("id"));
        Delivery delivery = dao.getDeliveryById(id);
        delivery.setPaymentStatus("paid");
        dao.updateDelivery(delivery);
        UserTypeDao userTypeDao = DaoFactory.getDaoFactory().getUserTypeDao();
        if (user.getTypeId() == userTypeDao.getUserTypeByName("operator").getId()) {
            consLogger.info("Operator can pay for delivery");
            request.setAttribute("deliveries", dao.getAllDeliveries());
        } else {
            consLogger.info("User " + user.getLogin()+" paid for delivery");
            request.setAttribute("deliveries", dao.getDeliveriesByUserId(user.getId()));
        }

        return PageConfigManager.getProperty("path.page.listDelivery");
    }
}
