package model.DAO;

import model.persistence.HibernateUtility;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.Serializable;
import java.util.List;

/**
 * Created on 07.03.2017.
 *
 * @author Les.
 * @version 1.0.
 */
interface GenericDAO<E, K extends Serializable> {

    /**
     * Allows to get all entities from data base
     * @return array with all entities
     */
    default List<E> getAll(Class<E> eClass){
        List<E> adverts = null;
        Session session = null;
        try {
            session = HibernateUtility.getSessionFactory().openSession();
            adverts = (List<E>)session.createCriteria(eClass).list();
            session.close();
        } catch (Exception e){
            e.printStackTrace();
        }   finally {
            if (session != null && session.isOpen())
                session.close();
        }
        return adverts;
    }

    /**
     * Allows to get model.entity by key
     * @param key - primary key of model.entity
     * @return model.entity with current key
     */
    default E getByKey(K key, Class<E> eClass) {
        Session session = null;
        E entity = null;
        try {
            session = HibernateUtility.getSessionFactory().openSession();
            entity = (E) session.load(eClass, key);
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen())
                session.close();
        }
        return entity;
    }

    /**
     * Save model.entity to data base
     * @param entity - model.entity that we want to save
     */
    default void save(E entity){
        Session session = null;
        try {
            session = HibernateUtility.getSessionFactory().openSession();
            Transaction t = session.beginTransaction();
            session.save(entity);
            t.commit();
            session.close();
        } catch (Exception e){
            throw e;
        } finally {
            if (session != null && session.isOpen())
                session.close();
        }
    }

    /**
     * Update model.entity from data base
     * @param entity - model.entity that we want to update
     */
    default void update(E entity){
        Session session = null;
        try {
            session = HibernateUtility.getSessionFactory().openSession();
            Transaction t = session.beginTransaction();
            session.update(entity);
            t.commit();
            session.close();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen())
                session.close();
        }
    }

    /**
     * Delete model.entity from data base
     * @param entity - model.entity to delete
     */
    default void delete(E entity){
        Session session = null;
        try {
            session = HibernateUtility.getSessionFactory().openSession();
            Transaction t = session.beginTransaction();
            session.delete(entity);
            t.commit();
            session.close();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen())
                session.close();
        }
    }
}
