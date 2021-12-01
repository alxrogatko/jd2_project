package by.academy.it.dao;

import by.academy.it.data.SessionFactoryUtil;
import by.academy.it.pojo.UserEmail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.io.Serializable;

public class UserEmailDao {
    private final SessionFactory sessionFactory;

    public UserEmailDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public UserEmailDao() {
        this(SessionFactoryUtil.getSession());
    }

    public void addNewUser(UserEmail user) {
        Session session = sessionFactory.openSession();
        Serializable id = null;
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            id = session.save(user);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void deleteUser(UserEmail user) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            session.delete(user);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public UserEmail getUserById(String id) {
        Session session = sessionFactory.openSession();
        return session.get(UserEmail.class, id);
    }

    public UserEmail getUserByEmail(String email) {
        Session session = sessionFactory.openSession();
        return session.get(UserEmail.class, email);
    }
}
