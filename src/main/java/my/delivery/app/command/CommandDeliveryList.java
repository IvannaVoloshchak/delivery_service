package my.delivery.app.command;

import my.delivery.app.dao.DeliveryDao;
import my.delivery.app.dao.DistanceDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CommandDeliveryList implements ICommand {

    private static String LIST_DELIVERY = "/listDelivery.jsp";
    private DeliveryDao dao;

    public CommandDeliveryList() {
        dao = new DeliveryDao();
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("deliveries", dao.getAllDeliveries());

        return LIST_DELIVERY;
    }
}
