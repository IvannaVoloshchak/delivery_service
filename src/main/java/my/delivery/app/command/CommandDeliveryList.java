package my.delivery.app.command;

import my.delivery.app.dao.DaoFactory;
import my.delivery.app.dao.DeliveryDao;
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
import java.util.List;
/**
        * Description: This describes actions of show all delivery for user
        * @author Ivanna Voloshchak
        */
public class CommandDeliveryList implements ICommand {
    public static Logger consLogger = Logger.getLogger("CONS");
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
        List<Delivery> listDelivery;

        if (user.getTypeId() == userTypeDao.getUserTypeByName("operator").getId()) {
           listDelivery= dao.getAllDeliveries();
        } else {
            listDelivery= dao.getDeliveriesByUserId(user.getId());
        }
        session.setAttribute("deliveries",listDelivery);
        request.setAttribute("deliveries", listDelivery);
        consLogger.info("List of deliveries was uploaded: " + listDelivery);
        return PageConfigManager.getProperty("path.page.listDelivery");
    }
}
