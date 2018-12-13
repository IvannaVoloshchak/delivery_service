package my.delivery.app.command;

import my.delivery.app.dao.CityDao;
import my.delivery.app.dao.DistanceDao;
import my.delivery.app.dao.GoodsTypeDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CommandCalculate implements ICommand {
    private static String INDEX = "/index.jsp";
    private GoodsTypeDao goodsTypeDao;
    private CityDao cityDao;
    private DistanceDao distanceDao;

    public CommandCalculate(){
        goodsTypeDao = new GoodsTypeDao();
        cityDao= new CityDao();
        distanceDao = new DistanceDao();
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("types", goodsTypeDao.getAllGoodsTypes());
        request.setAttribute("cities", cityDao.getAllCities());
        request.setAttribute("distances", distanceDao.getAllDistances());


        return INDEX;
    }
}
