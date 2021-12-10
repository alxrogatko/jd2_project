package by.academy.it.validators;

import by.academy.it.pojo.User;
import by.academy.it.util.QueryUtil;

import java.util.ArrayList;
import java.util.List;

public class LoginValidation {

    public static List<String> checkCanUserLogin(String email, String password) {
        List<User> userList = QueryUtil.getUserByEmail(email);
        List<String> messages = new ArrayList<>();

        if (!userList.isEmpty()) {
            if (!userList.get(0).getPassword().equals(password)) {
                messages.add("Пароль введен неверно");
            }
        } else {
            messages.add("Почта введена неверно");
        }
        return messages;
    }
}
