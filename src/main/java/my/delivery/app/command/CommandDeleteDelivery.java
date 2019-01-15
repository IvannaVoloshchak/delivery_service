package my.delivery.app.command;

import my.delivery.app.dao.DaoFactory;
import my.delivery.app.dao.DeliveryDao;
import my.delivery.app.dao.UserTypeDao;
import my.delivery.app.model.User;
import my.delivery.app.resourсesBundle.PageConfigManager;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
/**
        * Description: This describes actions of delete delivery from Delivery list.
        * @author Ivanna Voloshchak
        */
public class CommandDeleteDelivery implements ICommand {
    public static Logger consLogger = Logger.getLogger("CONS");
    private DeliveryDao dao;

    public CommandDeleteDelivery() {
        dao = DaoFactory.getDaoFactory().getDeliveryDao();
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        User user = (User) session.getAttribute("user");
        int id = Integer.parseInt(request.getParameter("id"));
        dao.deleteDelivery(id);
        UserTypeDao userTypeDao = DaoFactory.getDaoFactory().getUserTypeDao();
        if (user.getTypeId() == userTypeDao.getUserTypeByName("operator").getId()) {
            request.setAttribute("deliveries", dao.getAllDeliveries());
        } else {
            request.setAttribute("deliveries", dao.getDeliveriesByUserId(user.getId()));
        }
        consLogger.info("Delivery for " + user.getLogin()+ " was delete from DB");
        return PageConfigManager.getProperty("path.page.listDelivery");
    }
}