package by.academy.it.dao;

import by.academy.it.config.TestDaoConfig;
import by.academy.it.pojo.UserEmail;
import by.academy.it.util.TestSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import java.time.LocalDateTime;
import java.util.List;

import static by.academy.it.util.TestSessionFactoryUtil.sessionFactory;

@ContextConfiguration(classes = TestDaoConfig.class)
public class UserEmailDaoTest {

    @Autowired
    private UserEmailDao userEmailDao;

    @Test
    void addNewUser() {
        LocalDateTime time = LocalDateTime.now();
        String email = "add-email-test@gmail.com";
        UserEmail userEmail = new UserEmail("1", email, time);

        userEmailDao.addNewUser(userEmail);

        Session session = sessionFactory.openSession();
        Query<UserEmail> query = session.createQuery("from UserEmail where email = : paramEmail", UserEmail.class);
        query.setParameter("paramEmail", email);
        List<UserEmail> listEmail = query.list();

        Assertions.assertEquals("1", listEmail.get(0).getUserId());
        Assertions.assertEquals(email, listEmail.get(0).getEmail());
        Assertions.assertEquals(time, listEmail.get(0).getDate());
        session.close();
    }
}