package my.delivery.app.command;

import my.delivery.app.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CommandRegistrationUser implements ICommand{
    private static String REGISTRATION= "/registration.jsp";
    private UserDao userDao;
    public CommandRegistrationUser(){
        userDao= new UserDao();
    }
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        return REGISTRATION;
    }
}