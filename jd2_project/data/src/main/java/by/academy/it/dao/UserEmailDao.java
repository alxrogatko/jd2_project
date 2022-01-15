package by.academy.it.dao;

import by.academy.it.pojo.UserEmail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class UserEmailDao {

    @Autowired
    @Qualifier("usersSessionFactory")
    private SessionFactory sessionFactory;

    @Transactional
    public void addNewUser(UserEmail user) {
        Session session = sessionFactory.getCurrentSession();

        try {
            session.save(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
