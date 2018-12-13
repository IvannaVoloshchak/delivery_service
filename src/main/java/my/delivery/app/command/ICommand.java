package my.delivery.app.command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface ICommand {

    public String execute(HttpServletRequest request, HttpServletResponse responce) throws ServletException, IOException;
}
