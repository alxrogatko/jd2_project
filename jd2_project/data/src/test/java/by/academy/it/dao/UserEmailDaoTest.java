package by.academy.it.dao;

import by.academy.it.pojo.UserEmail;
import by.academy.it.util.TestSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

public class UserEmailDaoTest extends TestSessionFactoryUtil {
    private static UserEmailDao userEmailDao;

    @BeforeAll
    static void setUp() {
        userEmailDao = new UserEmailDao(TestSessionFactoryUtil.sessionFactory);
    }

    @AfterAll
    static void tearDown() {
        userEmailDao = null;
    }

    @Test
    void addNewUser() {
        UserEmail userEmail = new UserEmail();
        LocalDateTime time = LocalDateTime.now();
        String email = "add-email-test@gmail.com";
        userEmail.setId("1");
        userEmail.setEmail(email);
        userEmail.setDate(time);

        userEmailDao.addNewUser(userEmail);

        Session session = sessionFactory.openSession();
        Query<UserEmail> query = session.createQuery("from UserEmail where email = : paramEmail", UserEmail.class);
        query.setParameter("paramEmail", email);
        List<UserEmail> listEmail = query.list();

        Assertions.assertEquals("1", listEmail.get(0).getId());
        Assertions.assertEquals(email, listEmail.get(0).getEmail());
        Assertions.assertEquals(time, listEmail.get(0).getDate());
        session.close();
    }
}