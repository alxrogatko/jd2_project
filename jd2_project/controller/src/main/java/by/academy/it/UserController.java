package by.academy.it;

import by.academy.it.dao.UserDao;
import by.academy.it.dao.UserEmailDao;
import by.academy.it.dao.UserPasswordDao;
import by.academy.it.pojo.User;
import by.academy.it.pojo.UserEmail;
import by.academy.it.pojo.UserPassword;
import by.academy.it.validators.LoginValidation;
import by.academy.it.validators.RegisterValidation;

import java.time.LocalDateTime;
import java.util.List;

public class UserController {
    private final UserDao userDao;
    private final UserEmailDao userEmailDao;
    private final UserPasswordDao userPasswordDao;

    public UserController() {
        userDao = new UserDao();
        userEmailDao = new UserEmailDao();
        userPasswordDao = new UserPasswordDao();
    }

    public List<String> getErrorMessages(String email, String password, String repassword, String nickname) {
        return RegisterValidation.checkCanUserRegister(email, password, repassword, nickname);
    }

    public List<String> newUserRegistration(String email, String password, String repassword, String nickname, String gender, String age, String birthday) {
        List<String> messages = getErrorMessages(email, password, repassword, nickname);
        if (messages.isEmpty()) {
            User user = new User();
            LocalDateTime date = LocalDateTime.now();
            user.setEmail(email.trim());
            user.setLastEmailChangeDate(date);
            user.setPassword(password);
            user.setLastPasswordChangeDate(date);
            user.setNickname(nickname.trim());
            user.setGender(gender);
            user.setAge(age);
            user.setBirthday(birthday);
            user.setDate(date);
            userDao.addUser(user);
            addUserDataInTables(user);
        }
        return messages;
    }

    public void addUserDataInTables(User user) {
        UserEmail userEmail = new UserEmail();
        UserPassword userPassword = new UserPassword();
        userEmail.setId(user.getId());
        userEmail.setEmail(user.getEmail());
        userEmail.setDate(user.getLastEmailChangeDate());
        userPassword.setUserId(user.getId());
        userPassword.setPassword(user.getPassword());
        userPassword.setDate(user.getLastPasswordChangeDate());
        userEmailDao.addNewUser(userEmail);
        userPasswordDao.addUserData(userPassword);
    }

    public List<User> getUserByEmail(String email) {
        return userDao.getUserByEmail(email.trim());
    }

    public List<String> loginUser(String email, String password) {
        return LoginValidation.checkCanUserLogin(email, password);
    }
}
