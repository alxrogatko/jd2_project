package by.academy.it.main;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.Writer;

public class HomeServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nickname = req.getParameter("nickname");
        String gender = req.getParameter("gender");
        String birthday = req.getParameter("birthday");
        Writer writer = resp.getWriter();
        writer.write("<html><meta charset=UTF-8>" + nickname + " " + gender + " " + birthday + "</html>");
    }
}
