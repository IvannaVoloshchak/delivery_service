package my.delivery.app.controller;

import my.delivery.app.dao.CityDao;
import my.delivery.app.dao.DeliveryDao;
import my.delivery.app.dao.DistanceDao;
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
    private static String USER= "/login.jsp";
    private static String REGISTRATION= "/registration.jsp";
    private DeliveryDao dao;
    private GoodsTypeDao goodsTypeDao;
    private CityDao cityDao;
    private DistanceDao distanceDao;

    public DeliveryController() {
        super();
        dao = new DeliveryDao();
        goodsTypeDao = new GoodsTypeDao();
        cityDao= new CityDao();
        distanceDao = new DistanceDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward = "";
        String action = request.getParameter("action");
        if (action == null) {
            forward = INDEX;
            request.setAttribute("types", goodsTypeDao.getAllGoodsTypes());
            request.setAttribute("cities", cityDao.getAllCities());
            request.setAttribute("distances", distanceDao.getAllDistances());
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
        } else if (action.equalsIgnoreCase("insert")) {
            forward = INSERT_OR_EDIT;
        } else if (action.equalsIgnoreCase("calculate")) {
            forward = INDEX;

        }else if(action.equalsIgnoreCase("signIn")){
            forward= USER;
    }
    else if(action.equalsIgnoreCase("registration")){
            forward= REGISTRATION;


        }else {
            forward = INDEX;
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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



// String username = request.getParameter("username");
//        String password = request.getParameter("password");
//        User user = userService.find(username, password);
//
//        if (user != null) {
//            request.getSession().setAttribute("user", user);
//            response.sendRedirect("home");
//        }
//        else {
//            request.setAttribute("error", "Unknown user, please try again");
//            request.getRequestDispatcher("/login.jsp").forward(request, response);
//        }
//    }
    }
