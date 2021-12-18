package by.academy.it.controller;

import by.academy.it.dao.UserDao;
import by.academy.it.dao.UserEmailDao;
import by.academy.it.dao.UserPasswordDao;
import by.academy.it.pojo.User;
import by.academy.it.pojo.UserEmail;
import by.academy.it.pojo.UserPassword;
import by.academy.it.validators.LoginValidation;
import by.academy.it.validators.RegisterValidation;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserController {
    private final UserDao userDao;
    private final UserEmailDao userEmailDao;
    private final UserPasswordDao userPasswordDao;

    public UserController(UserDao userDao,
                          UserEmailDao userEmailDao,
                          UserPasswordDao userPasswordDao)
    {
        this.userDao = userDao;
        this.userEmailDao = userEmailDao;
        this.userPasswordDao = userPasswordDao;
    }

    public List<String> newUserRegistration(User user, String repassword) {
        List<String> messages = RegisterValidation.checkCanUserRegister(
                user.getEmail(),
                user.getPassword(),
                repassword,
                user.getNickname());

        if (messages.isEmpty()) {
            userDao.addUser(user);
            addUserDataInTables(user);
        }

        return messages;
    }

    private void addUserDataInTables(User user) {
        UserEmail userEmail = new UserEmail(
                user.getId(),
                user.getEmail(),
                user.getLastEmailChangeDate());
        UserPassword userPassword = new UserPassword(
                user.getId(),
                user.getPassword(),
                user.getLastPasswordChangeDate());

        userEmailDao.addNewUser(userEmail);
        userPasswordDao.addUserData(userPassword);
    }

    public List<User> getUserByEmail(String email) {
        return userDao.getUserByEmail(email.trim());
    }

    public List<User> getUserList() {
        return userDao.getUsersList();
    }

    public List<String> loginUser(String email, String password) {
        return LoginValidation.checkCanUserLogin(email.trim(), password);
    }
}
