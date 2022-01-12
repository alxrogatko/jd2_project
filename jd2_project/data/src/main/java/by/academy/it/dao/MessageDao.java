package by.academy.it.dao;

import by.academy.it.pojo.Messages;
import by.academy.it.util.MessagesQueries;
import by.academy.it.util.SessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MessageDao {

    private final SessionFactory sessionFactory;

    public MessageDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public MessageDao() {
        this(SessionFactoryUtil.getSession());
    }

    public void sendMessage(Messages messages) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            transaction = session.beginTransaction();
            session.save(messages);
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

    public List<Messages> readMessages(String senderId, String receiverId) {
        return MessagesQueries.getMessagesList(senderId, receiverId);
    }
}
