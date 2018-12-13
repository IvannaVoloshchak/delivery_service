package my.delivery.app.command;

import my.delivery.app.dao.DeliveryDao;
import my.delivery.app.model.Delivery;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CommandSaveDelivery implements ICommand {

    private static String LIST_DELIVERY = "/listDelivery.jsp";
    private DeliveryDao dao;

    public CommandSaveDelivery() {

        dao = new DeliveryDao();
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Delivery delivery = new Delivery();
        delivery.setSendersFirstName(request.getParameter("senders_first_name"));
        delivery.setSendersLastName(request.getParameter("senders_last_name"));
        delivery.setRecipientFirstName(request.getParameter("recipient_first_name"));
        delivery.setRecipientLastName(request.getParameter("recipient_last_name"));
        delivery.setFromCity(request.getParameter("from_city"));
        delivery.setToCity(request.getParameter("to_city"));
        delivery.setGoodsType(request.getParameter("goods_type"));
        delivery.setWeight(Double.parseDouble(request.getParameter("weight")));
        delivery.setSendersPhone(request.getParameter("senders_phone"));
        delivery.setRecipientPhone(request.getParameter("recipient_phone"));

        try {
            Date sentDate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("sent_date"));
            delivery.setSentDate(sentDate);
            Date deliveryDate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("delivery_date"));
            delivery.setDeliveryDate(deliveryDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        delivery.setPrice(Double.parseDouble(request.getParameter("price")));

        String id = request.getParameter("id");
        if (id == null || id.isEmpty()) {
            dao.addDelivery(delivery);
        } else {
            delivery.setId(Integer.parseInt(id));
            dao.updateDelivery(delivery);
        }

        request.setAttribute("deliveries", dao.getAllDeliveries());
        return LIST_DELIVERY;
    }
}