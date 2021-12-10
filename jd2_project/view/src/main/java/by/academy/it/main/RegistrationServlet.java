package by.academy.it.main;

import by.academy.it.UserController;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public class RegistrationServlet extends HttpServlet {
    private UserController userController;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        userController = new UserController();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String path;
        String email = req.getParameter("email");
        String nickname = req.getParameter("nickname");
        String password = req.getParameter("password");
        String repassword = req.getParameter("repassword");
        String gender = req.getParameter("gender");
        String age = req.getParameter("age");
        String birthday = req.getParameter("birthday");
        RequestDispatcher requestDispatcher;
        List<String> messages = userController.newUserRegistration(email, password, repassword, nickname, gender, age, birthday);

        if (messages.isEmpty()) {
            path = "/successful-register.jsp";
        } else {
            path = "/registration.jsp";
            req.setAttribute("exception", messages.get(0));

        }
        requestDispatcher = req.getRequestDispatcher(path);
        requestDispatcher.forward(req, resp);
    }
}
