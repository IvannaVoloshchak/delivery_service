/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package my.delivery.app.controller;


import my.delivery.app.command.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 *
 * @author KMM
 */
public class ControllerHelper {

    private static ControllerHelper instance = null;
    HashMap<String, ICommand> commands = new HashMap<String, ICommand>();

    public ControllerHelper() {
        commands.put("index", new CommandIndex());
        commands.put("listDelivery", new CommandDeliveryList());
        commands.put("delete", new CommandDeleteDelivery());
        commands.put("edit", new CommandEditDelivery());
        commands.put("save", new CommandSaveDelivery());
        commands.put("insert", new CommandCreateDelivery());
        commands.put("calculate", new CommandCalculate());
        commands.put ("payment", new CommandPayment());
        commands.put("paid", new CommandPayForDelivery());
        commands.put("registration", new CommandRegistrationUser());
        commands.put("addUser", new CommandAddUser());

    }

    public ICommand getCommand(HttpServletRequest request) {
        ICommand action = commands.get(request.getParameter("action"));
        if (action == null) {
            action = new CommandIndex();
        }
        return action;
    }

    public static ControllerHelper getInstance() {
        if (instance == null) {
            instance = new ControllerHelper();
        }
        return instance;
    }
}
