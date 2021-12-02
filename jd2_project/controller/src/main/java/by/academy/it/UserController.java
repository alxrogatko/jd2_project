package by.academy.it;

import by.academy.it.dao.UserEmailDao;
import by.academy.it.dao.UserPasswordDao;
import by.academy.it.pojo.UserEmail;
import by.academy.it.pojo.UserPassword;
import by.academy.it.validators.LoginValidation;
import by.academy.it.validators.RegisterValidation;

import java.time.LocalDateTime;

public class UserController {
    private final UserEmailDao userEmailDao;
    private final UserPasswordDao userPasswordDao;

    public UserController() {
        userEmailDao = new UserEmailDao();
        userPasswordDao = new UserPasswordDao();
    }

    public boolean newUserRegistration(String email, String password, String repassword) {
        if (RegisterValidation.checkCanUserRegister(email, password, repassword)) {
            UserEmail userEmail = new UserEmail();
            UserPassword userPassword = new UserPassword();
            userEmail.setEmail(email.trim());
            userEmailDao.addNewUser(userEmail);
            userPassword.setUserId(userEmail.getId());
            userPassword.setPassword(password);
            userPassword.setDate(LocalDateTime.now());
            userPasswordDao.addUserData(userPassword);
            return true;
        }
        return false;
    }

    public boolean loginUser(String email, String password) {
        return LoginValidation.checkCanUserLogin(email, password);
    }
}
