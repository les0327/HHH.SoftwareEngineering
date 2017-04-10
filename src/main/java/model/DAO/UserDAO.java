package model.DAO;

import model.entity.User;
import model.persistence.HibernateUtility;

/**
 * Created on 07.03.2017.
 *
 * @author Les.
 * @version 1.0.
 */
public class UserDAO implements GenericDAO<User, Integer> {

    public User getByKey(Integer key) {
        return getByKey(key, User.class);
    }

    /**
     * Get user from database with this email
     * @param email - user email
     * @return user with this email or null if user doesn't exist
     */
    public User getByEmail(String email){
        return (User) HibernateUtility.getSessionFactory().openSession()
                .createQuery("FROM User WHERE email = :email")
                .setParameter("email", email)
                .uniqueResult();
    }
}
