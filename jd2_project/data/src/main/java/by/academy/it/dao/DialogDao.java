package by.academy.it.dao;

import by.academy.it.pojo.Dialog;
import by.academy.it.util.DialogQueries;
import by.academy.it.util.SessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DialogDao {

    private final SessionFactory sessionFactory;

    public DialogDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public DialogDao() {
        this(SessionFactoryUtil.getSession());
    }

    public void createDialog(Dialog dialog) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            session.save(dialog);
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

    public List<Dialog> getDialogList(String userId) {
        return DialogQueries.getDialogList(userId);
    }

    public boolean checkIfDialogExist(String firstUser, String secondUser) {
        return DialogQueries.checkIfDialogExist(firstUser, secondUser);
    }
}
