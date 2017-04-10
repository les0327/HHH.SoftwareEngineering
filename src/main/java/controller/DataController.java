package controller;

import lombok.Getter;
import lombok.Setter;
import model.DAO.ActionDAO;
import model.DAO.AdvertDAO;
import model.DAO.UserDAO;
import model.entity.Action;
import model.entity.Advert;
import model.entity.User;

import java.util.List;

/**
 * Created on 08.04.2017.
 *
 * @author Les.
 * @version 1.0.
 */
public class DataController {

    private @Getter static UserDAO   userDAO   = new UserDAO();
    private @Getter static AdvertDAO advertDAO = new AdvertDAO();
    private @Getter static ActionDAO actionDAO = new ActionDAO();

    private @Getter @Setter static User currentUser;
    private @Getter @Setter static List<Advert> adverts;
    private @Getter @Setter static List<Action> userActions;


    public static void updateAdverts(){
        adverts = advertDAO.getAllValid();
    }

    public static void updateUserActions(){
        userActions = actionDAO.getUserActions(currentUser);
    }
}
