package my.delivery.app.command;

import my.delivery.app.dao.*;
import my.delivery.app.dao.implementation.CityDaoImpl;
import my.delivery.app.dao.implementation.DistanceDaoImpl;
import my.delivery.app.dao.implementation.FareDaoImpl;
import my.delivery.app.dao.implementation.GoodsTypeDaoImpl;
import my.delivery.app.model.Distance;
import my.delivery.app.model.Fare;
import my.delivery.app.service.DeliveryCalculator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CommandCalculate implements ICommand {
    private static String INDEX = "/index.jsp";
    private GoodsTypeDao goodsTypeDao;
    private CityDao cityDao;
    private DistanceDao distanceDao;
    private FareDao fareDao;

    public CommandCalculate(){
        goodsTypeDao = DaoFactory.getDaoFactory().getGoodsTypeDao();
        cityDao= DaoFactory.getDaoFactory().getCityDao();
        distanceDao = DaoFactory.getDaoFactory().getDistanceDao();
        fareDao= DaoFactory.getDaoFactory().getFareDao();
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       double weight= Double.parseDouble(request.getParameter("weight"));
       int goodsType = Integer.parseInt(request.getParameter("goods_type"));
       int from = Integer.parseInt(request.getParameter("from"));
       int to= Integer.parseInt(request.getParameter("to"));

        Fare fareValue= fareDao.getFareByIdGoodsType(goodsType);
        double minPrice= fareValue.getMinimumPrice();
        double pricePerKg= fareValue.getPricePerKilogram();
        double priceByKm=fareValue.getPricePerKilometer();

        Distance getDistanceValue= distanceDao.getDistanceByIdCity(from, to);
        int distance =getDistanceValue.getDistance();

        double price = DeliveryCalculator.calculateDeliveryPrice(minPrice, pricePerKg, priceByKm,distance,weight);
        request.setAttribute("types", goodsTypeDao.getAllGoodsTypes());
        request.setAttribute("cities", cityDao.getAllCities());
        request.setAttribute("distances", distanceDao.getAllDistances());
        request.setAttribute("price", price);
        request.setAttribute("weight", weight);
        request.setAttribute("idGoodsType",goodsType);
        request.setAttribute("from", from);
        request.setAttribute("to", to);

        return INDEX;
    }
}
