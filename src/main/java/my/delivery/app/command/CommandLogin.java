package my.delivery.app.command;

import my.delivery.app.dao.DaoFactory;
import my.delivery.app.dao.UserDao;
import my.delivery.app.resourсesBundle.PageConfigManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CommandLogin implements ICommand {

    private UserDao userDao;

    public CommandLogin() {
        userDao = DaoFactory.getDaoFactory().getUserDao();
    }

    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        return PageConfigManager.getProperty("path.page.login");
    }
}
