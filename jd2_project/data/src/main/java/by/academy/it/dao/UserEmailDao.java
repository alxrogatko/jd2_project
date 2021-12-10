package by.academy.it.dao;

import by.academy.it.pojo.UserEmail;
import by.academy.it.util.SessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

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
}
