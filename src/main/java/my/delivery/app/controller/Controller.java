/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package my.delivery.app.controller;



import my.delivery.app.command.ICommand;
import my.delivery.app.manager.Message;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Controller", urlPatterns = {"/Controller"})
public class Controller extends HttpServlet {
    
    ControllerHelper controllerHelper = ControllerHelper.getInstance();

    public Controller() {
        super();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //SessionLogic.print(request,response);
        //CookieLogic.setCokkie(response);
        //CookieLogic.printCookie(request,response);
        String page = null;
        try {
            ICommand action = controllerHelper.getCommand(request);
            page = action.execute(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
            request.setAttribute("messageError", Message.getInstance().getProperty(Message.SERVLET_EXECPTION));
            //page = Config.getInstance().getProperty(Config.ERROR);
        } catch (IOException e) {
            e.printStackTrace();
            request.setAttribute("messageError", Message.getInstance().getProperty(Message.IO_EXCEPTION));
            //page = Config.getInstance().getProperty(Config.ERROR);
        }
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
        dispatcher.forward(request, response);
  }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
