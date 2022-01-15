package by.academy.it.dao;

import by.academy.it.pojo.Messages;
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
public class MessageDao {

    @Autowired
    @Qualifier("usersSessionFactory")
    private SessionFactory sessionFactory;

    @Transactional
    public void sendMessage(Messages messages) {
        Session session = sessionFactory.getCurrentSession();

        try {
            session.save(messages);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Messages> readMessages(String dialogId) {
        Session session = sessionFactory.openSession();

        Query<Messages> query = session.createQuery(
                "from Messages where dialogId =: dialogParam", Messages.class
        );
        query.setParameter("dialogParam", dialogId);

        List<Messages> messagesList = query.list();
        session.close();
        return messagesList;
    }
}
