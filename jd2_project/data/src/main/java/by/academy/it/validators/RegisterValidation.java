package by.academy.it.validators;

import by.academy.it.query.QueryUtil;

public class RegisterValidation {

    public static boolean checkCanUserRegister(String email, String password, String repassword) {
        return QueryUtil.getUserEmail(email).isEmpty() && password.equals(repassword);
    }
}
