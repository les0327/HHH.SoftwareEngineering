package model.DAO;

import model.entity.Action;
import model.entity.ActionType;
import model.entity.Advert;
import model.entity.User;
import model.persistence.HibernateUtility;

import java.util.List;

/**
 * Created on 07.03.2017.
 *
 * @author Les.
 * @version 1.0.
 */
public class ActionDAO implements GenericDAO<Action, Integer>{

    public Action getByKey(Integer key) {
        return getByKey(key, Action.class);
    }

    /**
     * Get action by advert and its type
     * @param advert - advert registered by this action
     * @param type   - type of this action
     * @return action
     */
    public Action getByAdvert(Advert advert, ActionType type){
        return (Action) HibernateUtility.getSessionFactory().openSession()
                .createQuery("FROM Action WHERE advert = :advert and type = :type")
                .setParameter("advert", advert)
                .setParameter("type", type).uniqueResult();
    }

    /**
     * Get action history of user
     * @param user - current user
     * @return list of user's actions
     */
    public List<Action> getUserActions(User user){
        return (List<Action>) HibernateUtility.getSessionFactory().openSession()
                .createQuery("FROM Action WHERE author = :user")
                .setParameter("user", user)
                .list();
    }
}
