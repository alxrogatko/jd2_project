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

public class LoginServlet extends HttpServlet {
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
        String path = null;
        PrintWriter writer = resp.getWriter();
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        RequestDispatcher requestDispatcher;
        List<String> messages = userController.loginUser(email, password);

        if (messages.isEmpty()) {
            writer.write("COOL");
        } else {
            path = "/login.jsp";
            req.setAttribute("exception", messages.get(0));
        }
        requestDispatcher = req.getRequestDispatcher(path);
        requestDispatcher.forward(req, resp);
    }
}
