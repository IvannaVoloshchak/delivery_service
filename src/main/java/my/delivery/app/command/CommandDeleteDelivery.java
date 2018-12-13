package my.delivery.app.command;

import my.delivery.app.dao.DeliveryDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CommandDeleteDelivery implements ICommand {

    private static String LIST_DELIVERY = "/listDelivery.jsp";
    private DeliveryDao dao;

    public CommandDeleteDelivery() {
        dao = new DeliveryDao();
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        dao.deleteDelivery(id);
        request.setAttribute("deliveries", dao.getAllDeliveries());

        return LIST_DELIVERY;
    }
}