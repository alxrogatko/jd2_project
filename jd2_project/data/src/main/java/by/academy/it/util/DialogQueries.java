package by.academy.it.util;

import by.academy.it.pojo.Dialog;
import org.hibernate.query.Query;

import java.util.List;

public class DialogQueries {

    public static List<Dialog> getDialogList(String userId) {
        Query<Dialog> dialogList = SessionFactoryUtil.getSession().openSession().createQuery(
                "from Dialog where firstUser =: idParam or secondUser =: idParam"
        );
        dialogList.setParameter("idParam", userId);
        return dialogList.list();
    }

    public static boolean checkIfDialogExist (String firstUser, String secondUser) {
        Query <Dialog> dialogList = SessionFactoryUtil.getSession().openSession().createQuery(
                "from Dialog where firstUser =: paramFirst and secondUser =: paramSecond or firstUser =: paramSecond and secondUser =: paramFirst"
        );
        dialogList.setParameter("paramFirst", firstUser);
        dialogList.setParameter("paramSecond", secondUser);
        return dialogList.list() != null && !dialogList.list().isEmpty();
    }
}
