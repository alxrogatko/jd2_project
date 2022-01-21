package by.academy.it.controllers;

import by.academy.it.UserService;
import by.academy.it.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

@Controller
@SessionAttributes({"userId", "userNickname"})
public class LoginController {

    private final UserService userService;

    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/authorization.do")
    public String processInputData(@RequestParam("email") String email,
                                   @RequestParam("password") String password,
                                   Model model
    ) {
        List<String> messages = userService.loginUser(email, password);
        if (messages.isEmpty()) {
            User user = userService.getUserByEmail(email).get(0);
            model.addAttribute("user", user);
            model.addAttribute("userId", user.getId());
            model.addAttribute("userNickname", user.getNickname());
            return "redirect:/" + user.getId() + "/profile.html";
        } else {
            model.addAttribute("exception", messages.get(0));
            return "login";
        }
    }

    @GetMapping(value = {"/", "/login.html"})
    public String showLoginForm() {
        return "login";
    }
}
