package by.academy.it.main;

import by.academy.it.UserController;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
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
        String password = req.getParameter("password");
        String repassword = req.getParameter("repassword");
        RequestDispatcher requestDispatcher;

        List<String> messages = userController.newUserRegistration(email, password, repassword);
        if (messages.isEmpty()) {
            path = "/successful-register.html";
        } else {
            path = "/registration.jsp";
            req.setAttribute("exception", messages.get(0));

        }
        requestDispatcher = req.getRequestDispatcher(path);
        requestDispatcher.forward(req, resp);
    }
}
