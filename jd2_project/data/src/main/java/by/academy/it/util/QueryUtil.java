package by.academy.it.util;

import by.academy.it.pojo.User;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class QueryUtil {

    public static List<User> getUserByEmail(String email) {
        Session session = SessionFactoryUtil.getSession().openSession();

        Query<User> userQuery = session.createQuery(
                "from User where email =: paramEmail", User.class);
        userQuery.setParameter("paramEmail", email);

        List<User> userList = userQuery.list();
        session.close();
        return userList;
    }
}
