package by.academy.it.validators;

import by.academy.it.pojo.UserEmail;
import by.academy.it.pojo.UserPassword;
import by.academy.it.query.QueryUtil;

import java.util.List;

public class LoginValidation {

    public static boolean checkCanUserLogin(String email, String password) {
        List<UserEmail> emailList = QueryUtil.getUserEmail(email);
        if (!emailList.isEmpty()) {
            List<UserPassword> passwordList = QueryUtil.getPassword(emailList.get(0).getId());
            return emailList.get(0).getEmail().equals(email.trim()) &&
                    passwordList.get(0).getPassword().equals(password);
        } else {
            return false;
        }
    }
}
