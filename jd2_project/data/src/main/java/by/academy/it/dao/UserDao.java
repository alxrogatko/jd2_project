package by.academy.it.dao;

import by.academy.it.pojo.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class UserDao {

    @Autowired
    @Qualifier("usersSessionFactory")
    private SessionFactory sessionFactory;

    @Transactional
    public void addUser(User user) {
        Session session = sessionFactory.getCurrentSession();

        try {
            session.save(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<User> getUsersList(String id) {
        Session session = sessionFactory.openSession();

        Query<User> query = session.createQuery("from User where id !=: paramId", User.class);
        query.setParameter("paramId", id);

        List<User> userList = query.list();
        session.close();
        return userList;
    }

    public List<User> getUserByEmail(String email) {
        Session session = sessionFactory.openSession();

        Query<User> query = session.createQuery("from User where email =: paramEmail", User.class);
        query.setParameter("paramEmail", email);

        List<User> userList = query.list();
        session.close();
        return userList;
    }

    public User getUserById(String id) {
        Session session = sessionFactory.openSession();

        User user = session.get(User.class, id);

        session.close();
        return user;
    }
}
