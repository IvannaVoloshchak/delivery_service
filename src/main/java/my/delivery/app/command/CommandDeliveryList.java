package my.delivery.app.command;

import my.delivery.app.dao.impl.DeliveryDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CommandDeliveryList implements ICommand {

    private static String LIST_DELIVERY = "/listDelivery.jsp";
    private DeliveryDaoImpl dao;

    public CommandDeliveryList() {
        dao = new DeliveryDaoImpl();
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("deliveries", dao.getAllDeliveries());

        return LIST_DELIVERY;
    }
}
