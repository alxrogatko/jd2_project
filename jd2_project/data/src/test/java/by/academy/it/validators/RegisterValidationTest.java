package by.academy.it.validators;

import by.academy.it.pojo.User;
import by.academy.it.util.SessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class RegisterValidationTest {

    static Stream<Arguments> registerValidationTest() {
        return Stream.of(
                arguments(null, "test-register-validation@gmail.com", "6641782a", "6641782a", "tokamo"),
                arguments("Неверный формат почты", "test-register-validation.com", "6641782a", "6641782a", "tokamo"),
                arguments("Неверный формат пароля", "test-register-validation@gmail.com", "6641_782", "6641_782", "tokamo"),
                arguments("Пользователь с такой почтой уже существует", "test-register-validation@mail.ru", "6641782a", "6641782a", "tokamo"),
                arguments("Введите имя аккаунта", "test-register-validation@gmail.com", "6641782a", "6641782a", ""),
                arguments("Пароли не совпадают", "test-register-validation@gmail.com", "6641782aa", "6641782a", "tokamo")

        );
    }

    @ParameterizedTest
    @MethodSource("registerValidationTest")
    void checkCanUserRegister(String expected, String email, String password, String repassword, String nickname) {
        List<String> list = RegisterValidation.checkCanUserRegister(email, password, repassword, nickname);
        String resultMessage;

        if (list.isEmpty()) {
            resultMessage = null;
        } else {
            resultMessage = list.get(0);
        }

        assertEquals(expected, resultMessage);
    }
}