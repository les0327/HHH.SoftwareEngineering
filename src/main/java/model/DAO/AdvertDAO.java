package model.DAO;

import model.entity.Advert;
import model.persistence.HibernateUtility;

import java.util.List;

/**
 * Created on 01.04.2017.
 *
 * @author Les.
 * @version 1.0.
 */
public class AdvertDAO implements GenericDAO<Advert, Integer> {

    public Advert getByKey(Integer key) {
        return getByKey(key, Advert.class);
    }

    /**
     * @return list of not deleted adverts
     */
    public List<Advert> getAllValid(){
        return (List<Advert>) HibernateUtility.getSessionFactory().openSession()
                .createQuery("FROM Advert WHERE valid = :valid")
                .setParameter("valid", true)
                .list();
    }
}
