package by.academy.it.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;

@Controller
@SessionAttributes({"userId", "userNickname"})
public class LogoutController {

    @GetMapping(value = "/logout.html")
    public View logout(HttpSession httpsession, SessionStatus status) {
        RedirectView redirectView = new RedirectView("/view/login.html");
        redirectView.setExposeModelAttributes(false);
        status.setComplete();
        httpsession.invalidate();
        return redirectView;
    }
}
