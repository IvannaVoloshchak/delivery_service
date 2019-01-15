package my.delivery.app.command;

import my.delivery.app.dao.*;
import my.delivery.app.model.Delivery;
import my.delivery.app.model.Distance;
import my.delivery.app.model.Fare;
import my.delivery.app.model.User;
import my.delivery.app.resourсesBundle.PageConfigManager;
import my.delivery.app.service.DeliveryCalculator;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
/**
        * Description: This describes actions of add new delivery and set price for it.
        * @author Ivanna Voloshchak
        */
public class CommandSaveDelivery implements ICommand {
    public static Logger consLogger = Logger.getLogger("CONS");
    private DeliveryDao dao;
    private GoodsTypeDao goodsTypeDao;
    private CityDao cityDao;
    private DistanceDao distanceDao;
    private FareDao fareDao;

    public CommandSaveDelivery() {
        goodsTypeDao = DaoFactory.getDaoFactory().getGoodsTypeDao();
        cityDao = DaoFactory.getDaoFactory().getCityDao();
        dao = DaoFactory.getDaoFactory().getDeliveryDao();
        distanceDao = DaoFactory.getDaoFactory().getDistanceDao();
        fareDao = DaoFactory.getDaoFactory().getFareDao();
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        User user = (User) session.getAttribute("user");
        Delivery delivery = new Delivery();
        if (request.getParameter("user_id") == "") {
            delivery.setUserId(user.getId());
        } else {
            delivery.setUserId(Integer.parseInt(request.getParameter("user_id")));
        }
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
            consLogger.error("Wrong type of date, it should be yyyy-MM-dd ");
        }

        delivery.setPrice(calculatePrice(request));
        delivery.setPaymentStatus(request.getParameter("paymentStatus"));
        String id = request.getParameter("id");
        if (id == null || id.isEmpty()) {
            consLogger.info("Delivery created: " + delivery);
            dao.addDelivery(delivery);
        } else {
            delivery.setId(Integer.parseInt(id));
            consLogger.info("Delivery updated: " + delivery);
            dao.updateDelivery(delivery);
        }

        UserTypeDao userTypeDao = DaoFactory.getDaoFactory().getUserTypeDao();
        List<Delivery> deliveryList;
        if (user.getTypeId().equals(userTypeDao.getUserTypeByName("operator").getId())) {
            deliveryList = dao.getAllDeliveries();
        } else {
            deliveryList = dao.getDeliveriesByUserId(user.getId());
        }
        consLogger.info("List of deliveries was uploaded: " + deliveryList);
        request.setAttribute("deliveries", deliveryList);
        return  PageConfigManager.getProperty("path.page.listDelivery");
    }

    public Double calculatePrice(HttpServletRequest request) {
        double weight = Double.parseDouble(request.getParameter("weight"));
        int goodsType = Integer.parseInt(request.getParameter("goods_type_id"));
        int from = Integer.parseInt(request.getParameter("city_from_id"));
        int to = Integer.parseInt(request.getParameter("city_to_id"));

        Fare fareValue = fareDao.getFareByIdGoodsType(goodsType);
        double minPrice = fareValue.getMinimumPrice();
        double pricePerKg = fareValue.getPricePerKilogram();
        double priceByKm = fareValue.getPricePerKilometer();

        Distance distanceValue = distanceDao.getDistanceByIdCity(from, to);
        int distance = distanceValue.getDistance();

        double price = DeliveryCalculator.calculateDeliveryPrice(minPrice, pricePerKg, priceByKm, distance, weight);
        return price;
    }
}