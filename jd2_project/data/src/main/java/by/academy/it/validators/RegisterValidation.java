package by.academy.it.validators;

import by.academy.it.util.QueryUtil;

import java.util.ArrayList;
import java.util.List;

public class RegisterValidation {

    public static List<String> checkCanUserRegister(String email, String password, String repassword, String nickname) {
        List<String> message = new ArrayList<>();

        if (!RegexValidation.checkEmailFormat(email)) {
            message.add("Неверный формат почты");
        } else if (!RegexValidation.checkPasswordFormat(password)) {
            message.add("Неверный формат пароля");
        } else {
            if (!QueryUtil.getUserByEmail(email).isEmpty()) {
                message.add("Пользователь с такой почтой уже существует");
            } else if (nickname.isEmpty()) {
                message.add("Введите имя аккаунта");
            } else if (!password.equals(repassword)) {
                message.add("Пароли не совпадают");
            }
        }
        return message;
    }
}
