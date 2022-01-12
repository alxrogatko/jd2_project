package by.academy.it.util;

import by.academy.it.pojo.Messages;
import org.hibernate.query.Query;

import java.util.List;

public class MessagesQueries {

    public static List<Messages> getMessagesList(String senderId, String receiverId) {
        Query<Messages> messagesQuery = SessionFactoryUtil.getSession().openSession().createQuery(
                "from Messages where senderId =: senderParam and receiverId =: receiverParam"
        );
        messagesQuery.setParameter("senderParam", senderId);
        messagesQuery.setParameter("receiverParam", receiverId);
        return messagesQuery.list();
    }
}
