package by.academy.it.main;

import by.academy.it.UserController;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {
    private UserController userController;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        userController = new UserController();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter writer = resp.getWriter();
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        if (userController.loginUser(email, password)) {
            writer.write("COOL");
        } else {
            writer.write("NOT COOL");
        }
    }
}
