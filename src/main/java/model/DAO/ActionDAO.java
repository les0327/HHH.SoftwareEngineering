package model.DAO;

import model.entity.Action;
import org.hibernate.Session;
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


}
