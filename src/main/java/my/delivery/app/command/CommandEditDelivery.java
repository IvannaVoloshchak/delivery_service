package my.delivery.app.command;

import my.delivery.app.dao.DeliveryDao;
import my.delivery.app.model.Delivery;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CommandEditDelivery  implements ICommand {

    private static String INSERT_OR_EDIT = "/delivery.jsp";
    private DeliveryDao dao;

    public CommandEditDelivery() {
        dao = new DeliveryDao();
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Delivery delivery = dao.getDeliveryById(id);
        request.setAttribute("delivery", delivery);

        return INSERT_OR_EDIT;
    }
}
