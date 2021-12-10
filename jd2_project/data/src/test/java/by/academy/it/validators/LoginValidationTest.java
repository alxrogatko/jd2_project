package by.academy.it.validators;

import by.academy.it.pojo.User;
import by.academy.it.util.SessionFactoryUtil;
import by.academy.it.util.TestSessionFactoryUtil;
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

class LoginValidationTest extends TestSessionFactoryUtil {

    @BeforeAll
    static void setUp() {
        User user = new User();
        Session session = SessionFactoryUtil.getSession().openSession();
        Transaction transaction = session.beginTransaction();
        user.setEmail("test-login-validation@gmail.com");
        user.setPassword("6641782a");
        session.save(user);
        transaction.commit();
        session.close();
    }

    static Stream<Arguments> argsForLoginValidation() {
        return Stream.of(
                arguments(null, "test-login-validation@gmail.com", "6641782a"),
                arguments("Почта введена неверно", "test-validation@gmai.com", "6641782a"),
                arguments("Пароль введен неверно", "test-login-validation@gmail.com", "6641782aa")
        );
    }

    @ParameterizedTest
    @MethodSource("argsForLoginValidation")
    void checkCanUserLogin(String expected, String email, String password) {
        List<String> list = LoginValidation.checkCanUserLogin(email, password);
        String resultMessage;

        if (list.isEmpty()) {
            resultMessage = null;
        } else {
            resultMessage = list.get(0);
        }

        assertEquals(expected, resultMessage);
    }
}