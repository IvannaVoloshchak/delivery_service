package my.delivery.app.command;

import my.delivery.app.dao.DeliveryDao;
import my.delivery.app.model.Delivery;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CommandPayment implements ICommand {
    private static String PAY = "/payment.jsp";
    private static String LIST_DELIVERY = "/listDelivery.jsp";
    private DeliveryDao dao;

    public CommandPayment() {

        dao = new DeliveryDao();
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        return PAY;
    }
}

