package by.academy.it.dao;

import by.academy.it.pojo.User;
import by.academy.it.util.QueryUtil;
import by.academy.it.util.SessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserDao {

    private final SessionFactory sessionFactory;

    public UserDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public UserDao() {
        this(SessionFactoryUtil.getSession());
    }

    public void addUser(User user) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            session.save(user);
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

    public List<User> getUsersList() {
        Query<User> query = SessionFactoryUtil.getSession().openSession().createQuery("from User", User.class);
        return query.list();
    }

    public List<User> getUserByEmail(String email) {
        return QueryUtil.getUserByEmail(email);
    }

    public User getUserById(String id) {
        Session session = SessionFactoryUtil.getSession().openSession();
        return session.get(User.class, id);
    }
}
