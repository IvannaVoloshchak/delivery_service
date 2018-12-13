package my.delivery.app.command;

import my.delivery.app.dao.*;
import my.delivery.app.model.Delivery;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CommandCreateDelivery implements ICommand {

    private static String INSERT_OR_EDIT = "/delivery.jsp";
    private DeliveryDao dao;
    private GoodsTypeDao goodsTypeDao;
    private CityDao cityDao;

    public CommandCreateDelivery() {
        goodsTypeDao = new GoodsTypeDao();
        cityDao= new CityDao();

        dao = new DeliveryDao();
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("types", goodsTypeDao.getAllGoodsTypes());
        request.setAttribute("cities", cityDao.getAllCities());

        return INSERT_OR_EDIT;
    }
}
