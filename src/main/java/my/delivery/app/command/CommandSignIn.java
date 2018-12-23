package my.delivery.app.command;

import my.delivery.app.dao.DaoFactory;
import my.delivery.app.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CommandSignIn implements ICommand {
    private static String INDEX = "/index.jsp";
    private static String LISTDELIVERY = "/listDelivery.jsp";
    private UserDao userDao;

    public CommandSignIn() {
        userDao = DaoFactory.getDaoFactory().getUserDao();
    }

    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);

        try {

            String login = request.getParameter("login");
            String password = request.getParameter("password");
            if (password.equalsIgnoreCase("admin")) {
                session.setAttribute("login", login);
                //  response.sendRedirect("listDelivery.jsp");

            } else {
                response.sendRedirect("delivery.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

//        if (session.getAttribute("sessionId") == null) {
//            session.setAttribute("sessionId", sessionId);
//            System.out.println("Session " + session.getId() + " has started");
//        }
//        UserDaoImpl userDao= new UserDaoImpl();
//        String login = request.getParameter("login");
//        String password = request.getParameter("password");
//        User user = null;
//        try {
//            user = userDao.checkUser(login, password);
//        } catch (Exception e) {
//            session.setAttribute("errorMessage", Message.getInstance());
//            session.setAttribute("previousPage", "Index");
//            System.out.println("Can't get user account. DB error");
//            return Message.getProperty("error");
//        }

//        if (user != null) {
//            try {
//                user = userDao.();
//            } catch (DataBaseWorkException e) {
//                session.setAttribute("errorMessage", MessageConfigManager.getProperty(e.getMessage()));
//                session.setAttribute("previousPage", "path.page.login");
//                LOGGER.error("Can't get user. DB error", e.getCause());
//                return PageConfigManager.getProperty("path.page.error");
//            }
//            LOGGER.info("Account was found");
//        } else {
//            LOGGER.info("Account was not found");
//            request.setAttribute("errorLoginMessage", true);
//            return PageConfigManager.getProperty("path.page.login");
//        }


        return INDEX;
    }
}
