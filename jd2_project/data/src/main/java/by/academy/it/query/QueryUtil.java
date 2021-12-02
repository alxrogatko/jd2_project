package by.academy.it.query;

import by.academy.it.data.SessionFactoryUtil;
import by.academy.it.pojo.UserEmail;
import by.academy.it.pojo.UserPassword;
import org.hibernate.query.Query;

import java.util.List;

public class QueryUtil {

    public static List<UserEmail> getUserEmail(String email) {
        Query<UserEmail> emailQuery = SessionFactoryUtil.getSession().openSession().createQuery(
                "from UserEmail where email =: paramEmail", UserEmail.class);
        emailQuery.setParameter("paramEmail", email.trim());
        return emailQuery.list();
    }

    public static List<UserPassword> getPassword(String id) {
        Query<UserPassword> passwordQuery = SessionFactoryUtil.getSession().openSession().createQuery(
                "from UserPassword where userId =: paramId", UserPassword.class);
        passwordQuery.setParameter("paramId", id);
        return passwordQuery.list();
    }
}
