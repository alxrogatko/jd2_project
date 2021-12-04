package by.academy.it.validators;

import by.academy.it.pojo.UserEmail;
import by.academy.it.pojo.UserPassword;
import by.academy.it.query.QueryUtil;

import java.util.ArrayList;
import java.util.List;

public class LoginValidation {

    public static List<String> checkCanUserLogin(String email, String password) {
        List<UserEmail> emailList = QueryUtil.getUserEmail(email);
        List<String> messages = new ArrayList<>();

        if (!emailList.isEmpty()) {
            List<UserPassword> passwordList = QueryUtil.getUserPassword(emailList.get(0).getId());
            if (!passwordList.get(0).getPassword().equals(password)) {
                messages.add("Пароль введен неверно");
            }
        } else {
            messages.add("Почта введена неверно");
        }
        return messages;
    }
}
