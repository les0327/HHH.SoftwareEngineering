package model.DAO;

import model.entity.Advert;

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

}
