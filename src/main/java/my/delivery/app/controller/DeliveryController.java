package my.delivery.app.controller;

import my.delivery.app.dao.DeliveryDao;
import my.delivery.app.dao.GoodsTypeDao;
import my.delivery.app.model.Delivery;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DeliveryController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static String INDEX = "/index.jsp";
    private static String INSERT_OR_EDIT = "/delivery.jsp";
    private static String LIST_DELIVERY = "/listDelivery.jsp";
    private DeliveryDao dao;
    private GoodsTypeDao goodsTypeDao;

    public DeliveryController() {
        super();
        dao = new DeliveryDao();
        goodsTypeDao = new GoodsTypeDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward = "";
        String action = request.getParameter("action");
        if (action == null) {
            forward = INDEX;
            request.setAttribute("types", goodsTypeDao.getAllGoodsTypes());
        } else if (action.equalsIgnoreCase("delete")) {
            int id = Integer.parseInt(request.getParameter("id"));
            dao.deleteDelivery(id);
            forward = LIST_DELIVERY;
            request.setAttribute("deliveries", dao.getAllDeliveries());
        } else if (action.equalsIgnoreCase("edit")) {
            forward = INSERT_OR_EDIT;
            int id = Integer.parseInt(request.getParameter("id"));
            Delivery delivery = dao.getDeliveryById(id);
            request.setAttribute("delivery", delivery);
        } else if (action.equalsIgnoreCase("listDelivery")) {
            forward = LIST_DELIVERY;
            request.setAttribute("deliveries", dao.getAllDeliveries());
        } else if (action.equalsIgnoreCase("index")) {
            forward = INDEX;
            request.setAttribute("types", goodsTypeDao.getAllGoodsTypes());
        } else {
            forward = INSERT_OR_EDIT;
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Delivery delivery = new Delivery();
        delivery.setSenders_name(request.getParameter("senders_name"));
        delivery.setRecipient_name(request.getParameter("recipient_name"));
        delivery.setSenders_address(request.getParameter("senders_address"));
        delivery.setRecipient_address(request.getParameter("senders_address"));
        delivery.setDelivery_type(request.getParameter("delivery_type"));
        delivery.setWeight(Double.parseDouble(request.getParameter("weight")));
        try {
            Date sent_date = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("sent_date"));
            delivery.setSent_date(sent_date);
            Date delivery_date = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("delivery_date"));
            delivery.setDelivery_date(delivery_date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        String id = request.getParameter("id");
        if (id == null || id.isEmpty()) {
            dao.addDelivery(delivery);
        } else {
            delivery.setId(Integer.parseInt(id));
            dao.updateDelivery(delivery);
        }
        RequestDispatcher view = request.getRequestDispatcher(LIST_DELIVERY);
        request.setAttribute("deliveries", dao.getAllDeliveries());
       view.forward(request, response);

    }
}