package by.academy.it.dao;

import by.academy.it.pojo.UserPassword;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class UserPasswordDao {

    @Autowired
    @Qualifier("usersSessionFactory")
    private SessionFactory sessionFactory;

    @Transactional
    public void addUserData(UserPassword user) {
        Session session = sessionFactory.getCurrentSession();

        try {
            session.save(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
