package my.delivery.app.command;

import my.delivery.app.dao.*;
import my.delivery.app.model.Distance;
import my.delivery.app.model.Fare;
import my.delivery.app.resourсesBundle.PageConfigManager;
import my.delivery.app.service.DeliveryCalculator;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Description: This describes actions of calculate price on main page
 * @author Ivanna Voloshchak
 */
public class CommandCalculate implements ICommand {
    public static Logger consLogger = Logger.getLogger("CONS");
    private GoodsTypeDao goodsTypeDao;
    private CityDao cityDao;
    private DistanceDao distanceDao;
    private FareDao fareDao;


    public CommandCalculate() {
        goodsTypeDao = DaoFactory.getDaoFactory().getGoodsTypeDao();
        cityDao = DaoFactory.getDaoFactory().getCityDao();
        distanceDao = DaoFactory.getDaoFactory().getDistanceDao();
        fareDao = DaoFactory.getDaoFactory().getFareDao();
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int goodsType = Integer.parseInt(request.getParameter("goods_type"));
        int from = Integer.parseInt(request.getParameter("from"));
        int to = Integer.parseInt(request.getParameter("to"));
        String weightStr = request.getParameter("weight");

        Fare fareValue = fareDao.getFareByIdGoodsType(goodsType);
        double minPrice = fareValue.getMinimumPrice();
        double pricePerKg = fareValue.getPricePerKilogram();
        double priceByKm = fareValue.getPricePerKilometer();
        Distance getDistanceValue = distanceDao.getDistanceByIdCity(from, to);
        int distance = getDistanceValue.getDistance();

        request.setAttribute("types", goodsTypeDao.getAllGoodsTypes());
        request.setAttribute("cities", cityDao.getAllCities());
        request.setAttribute("distances", distanceDao.getAllDistances());
        request.setAttribute("idGoodsType", goodsType);
        request.setAttribute("from", from);
        request.setAttribute("to", to);

        if (checkParseToDouble(weightStr) && Double.parseDouble(weightStr) >= 0) {
            double weight = Double.parseDouble(weightStr);
            double price = DeliveryCalculator.calculateDeliveryPrice(minPrice, pricePerKg, priceByKm, distance, weight);
            request.setAttribute("price", price);
            request.setAttribute("weight", weight);
            consLogger.info("Price for selected delivery values equals = " + price);
            return PageConfigManager.getProperty("path.page.index");
        } else {
            consLogger.error("Entered weight can't be parsed to Double " + weightStr);
            String errorMessage = "Please enter correct weight!";
            request.setAttribute("errorMessage", errorMessage);
            return PageConfigManager.getProperty("path.page.index");
        }

    }

    public boolean checkParseToDouble(String number) {
        try {
            Double.parseDouble(number);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }

    }
}
