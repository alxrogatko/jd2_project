package by.academy.it.main;

import by.academy.it.UserController;
import by.academy.it.pojo.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
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
        String path;
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        RequestDispatcher requestDispatcher;
        List<String> messages = userController.loginUser(email, password);

        if (messages.isEmpty()) {
            path = "/home.jsp";
            List<User> user = userController.getUserByEmail(email);
            req.setAttribute("nickname", user.get(0).getNickname());
            req.setAttribute("gender", user.get(0).getGender());
            req.setAttribute("age", user.get(0).getAge());
            req.setAttribute("birthday", user.get(0).getBirthday());
        } else {
            path = "/login.jsp";
            req.setAttribute("exception", messages.get(0));
        }
        requestDispatcher = req.getRequestDispatcher(path);
        requestDispatcher.forward(req, resp);
    }
}
