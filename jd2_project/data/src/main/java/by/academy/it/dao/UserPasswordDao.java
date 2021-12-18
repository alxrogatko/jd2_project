package by.academy.it.dao;

import by.academy.it.pojo.UserPassword;
import by.academy.it.util.SessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

@Component
public class UserPasswordDao {
    private final SessionFactory sessionFactory;

    public UserPasswordDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public UserPasswordDao() {
        this(SessionFactoryUtil.getSession());
    }

    public void addUserData(UserPassword user) {
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
