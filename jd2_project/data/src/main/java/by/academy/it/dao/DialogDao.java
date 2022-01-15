package by.academy.it.dao;

import by.academy.it.pojo.Dialog;
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
public class DialogDao {

    @Autowired
    @Qualifier("usersSessionFactory")
    private SessionFactory sessionFactory;

    @Transactional
    public void createDialog(Dialog dialog) {
        Session session = sessionFactory.getCurrentSession();

        try {
            session.save(dialog);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Transactional
    public void updateDialogLastMessage(String dialogId, String message, String senderNickname) {
        Session session = sessionFactory.getCurrentSession();

        Query<?> query = session.createQuery(
                "update Dialog set lastMessage =: paramMessage, lastMessageSenderNickname =: paramNickname where id =: paramId"
        );
        query.setParameter("paramMessage", message);
        query.setParameter("paramNickname", senderNickname);
        query.setParameter("paramId", dialogId);

        query.executeUpdate();
    }

    public List<Dialog> getDialogList(String userId) {
        Session session = sessionFactory.openSession();

        Query<Dialog> query = session.createQuery(
                "from Dialog where firstUser =: idParam or secondUser =: idParam", Dialog.class
        );
        query.setParameter("idParam", userId);

        List<Dialog> dialogList = query.list();
        session.close();
        return dialogList;
    }

    public List<Dialog> getDialog(String firstUser, String secondUser) {
        Session session = sessionFactory.openSession();

        Query<Dialog> query = session.createQuery(
                "from Dialog where " +
                    "firstUser =: paramFirst and secondUser =: paramSecond " +
                    "or firstUser =: paramSecond and secondUser =: paramFirst", Dialog.class
        );
        query.setParameter("paramFirst", firstUser);
        query.setParameter("paramSecond", secondUser);

        List<Dialog> dialog = query.list();
        session.close();
        return dialog;
    }
}
