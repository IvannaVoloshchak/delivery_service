package my.delivery.app.command;

import my.delivery.app.resourсesBundle.PageConfigManager;
import my.delivery.app.util.ConnectionPool;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CommandSetLocale implements ICommand {
    private static final Logger LOGGER =Logger.getLogger(ConnectionPool.class);
    private static String LOGIN = "/login.jsp";

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        //if (session.getAttribute("sessionId") !=null && !session.getId().equals(session.getAttribute("sessionId"))) {
        //    LOGGER.info("Session " + session.getId() + " has finished");
        //   // return LOGIN;
        //    return PageConfigManager.getProperty("path.page.login");
        //}

        String key = request.getParameter("currentPage");
        String locale = request.getParameter("locale");
        session.setAttribute("locale", locale);

        if (locale.equals("1")) {
            LOGGER.info("Locale EN was setted");
        } else {
            LOGGER.info("Locale UA was setted");
        }

        return PageConfigManager.getProperty(key);
    }
}
