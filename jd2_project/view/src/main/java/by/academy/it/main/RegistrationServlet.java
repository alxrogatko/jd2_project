package by.academy.it.main;

import by.academy.it.UserController;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class RegistrationServlet extends HttpServlet {
    private UserController userController;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        userController = new UserController();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        userController.newUserRegistration(email, password, "");
        writer.write("COOL");
    }
}
