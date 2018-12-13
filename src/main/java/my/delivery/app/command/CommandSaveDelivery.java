package my.delivery.app.command;

import my.delivery.app.dao.*;
import my.delivery.app.model.Delivery;
import my.delivery.app.model.Distance;
import my.delivery.app.model.Fare;
import my.delivery.app.service.DeliveryCalculator;

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
    private GoodsTypeDao goodsTypeDao;
    private CityDao cityDao;
    private DistanceDao distanceDao;
    private FareDao fareDao;

    public CommandSaveDelivery() {
        goodsTypeDao = new GoodsTypeDao();
        cityDao= new CityDao();
        distanceDao = new DistanceDao();
        fareDao= new FareDao();
        dao = new DeliveryDao();
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Delivery delivery = new Delivery();
        delivery.setSendersFirstName(request.getParameter("senders_first_name"));
        delivery.setSendersLastName(request.getParameter("senders_last_name"));
        delivery.setRecipientFirstName(request.getParameter("recipient_first_name"));
        delivery.setRecipientLastName(request.getParameter("recipient_last_name"));
        delivery.setFromCity(Integer.parseInt(request.getParameter("city_from_id")));
        delivery.setToCity(Integer.parseInt(request.getParameter("city_to_id")));
        delivery.setGoodsType(Integer.parseInt(request.getParameter("goods_type_id")));
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

        delivery.setPrice(calculatePrice(request));
        delivery.setPaymentStatus(request.getParameter("paymentStatus"));
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
    public Double calculatePrice(HttpServletRequest request){
        double weight= Double.parseDouble(request.getParameter("weight"));
        int goodsType = Integer.parseInt(request.getParameter("goods_type_id"));
        int from = Integer.parseInt(request.getParameter("city_from_id"));
        int to= Integer.parseInt(request.getParameter("city_to_id"));

        Fare fareValue= fareDao.getFareByIdGoodsType(goodsType);
        double minPrice= fareValue.getMinimumPrice();
        double pricePerKg= fareValue.getPricePerKilogram();
        double priceByKm=fareValue.getPricePerKilometer();

        Distance getDistanceValue= distanceDao.getDistanceByIdCity(from, to);
        int distance =getDistanceValue.getDistance();

        double price = DeliveryCalculator.calculateDeliveryPrice(minPrice, pricePerKg, priceByKm,distance,weight);
        return price;
    }
}