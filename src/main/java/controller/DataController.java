package controller;

import lombok.AccessLevel;
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
class DataController {

    private @Getter(AccessLevel.PACKAGE) static UserDAO userDAO     = new UserDAO();
    private @Getter(AccessLevel.PACKAGE) static AdvertDAO advertDAO = new AdvertDAO();
    private @Getter(AccessLevel.PACKAGE) static ActionDAO actionDAO = new ActionDAO();

    private @Getter(AccessLevel.PACKAGE) @Setter(AccessLevel.PACKAGE) static User currentUser;
    private @Getter(AccessLevel.PACKAGE) @Setter(AccessLevel.PACKAGE) static List<Advert> adverts;
    private @Getter(AccessLevel.PACKAGE) @Setter(AccessLevel.PACKAGE) static List<Action> userActions;


    static void updateAdverts(){
        adverts = advertDAO.getAll(Advert.class);
    }

    static void updateUserActions(){

    }
}
