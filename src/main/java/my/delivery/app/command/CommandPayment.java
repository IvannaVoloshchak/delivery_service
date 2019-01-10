package my.delivery.app.command;

import my.delivery.app.dao.DaoFactory;
import my.delivery.app.dao.DeliveryDao;
import my.delivery.app.model.Delivery;
import my.delivery.app.resourсesBundle.PageConfigManager;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CommandPayment implements ICommand {
    private DeliveryDao dao;


    public CommandPayment() {
        dao = DaoFactory.getDaoFactory().getDeliveryDao();
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        Delivery delivery = dao.getDeliveryById(id);
        request.setAttribute("delivery", delivery);

        return PageConfigManager.getProperty("path.page.pay");
    }
}

