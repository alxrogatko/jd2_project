package by.academy.it.dao;

import by.academy.it.util.SessionFactoryUtil;
import by.academy.it.pojo.UserInfo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class UserInfoDao {

    private final SessionFactory sessionFactory;

    public UserInfoDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public UserInfoDao() {
        this(SessionFactoryUtil.getSession());
    }

    public void addUserInfo(UserInfo userInfo) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            session.save(userInfo);
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
