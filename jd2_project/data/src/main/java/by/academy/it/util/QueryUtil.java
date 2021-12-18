package by.academy.it.util;

import by.academy.it.pojo.User;
import org.hibernate.query.Query;

import java.util.List;

public class QueryUtil {

    public static List<User> getUserByEmail(String email) {
        Query<User> userQuery = SessionFactoryUtil.getSession().openSession().createQuery(
                "from User where email =: paramEmail", User.class);
        userQuery.setParameter("paramEmail", email);
        return userQuery.list();
    }
}
