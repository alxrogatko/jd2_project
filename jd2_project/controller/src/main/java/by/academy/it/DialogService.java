package by.academy.it;

import by.academy.it.dao.DialogDao;
import by.academy.it.pojo.Dialog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DialogService {

    private final DialogDao dialogDao;

    public DialogService(DialogDao dialogDao) {
        this.dialogDao = dialogDao;
    }

    public void createDialog(Dialog dialog) {
        dialogDao.createDialog(dialog);
    }

    public List<Dialog> getDialogList(String userId) {
        return dialogDao.getDialogList(userId);
    }

    public boolean checkIfDialogExist(String firstUser, String secondUser) {
        return dialogDao.checkIfDialogExist(firstUser, secondUser);
    }

}
