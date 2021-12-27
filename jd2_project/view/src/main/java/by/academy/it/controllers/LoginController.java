package by.academy.it.controllers;

import by.academy.it.UserController;
import by.academy.it.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@SessionAttributes({"userId", "userNickname"})
public class LoginController {

    private final UserController userController;

    @Autowired
    public LoginController(UserController userController) {
        this.userController = userController;
    }

    @PostMapping(value = "/home.html")
    public String processInputData(@RequestParam("email") String email,
                                   @RequestParam("password") String password,
                                   Model model
    ) {
        List<String> messages = userController.loginUser(email, password);
        if (messages.isEmpty()) {
            User user = userController.getUserByEmail(email).get(0);
            model.addAttribute("user", user);
            model.addAttribute("userId", user.getId());
            model.addAttribute("userNickname", user.getNickname());
            return "redirect:" + user.getId() + "/profile.html";
        } else {
            model.addAttribute("exception", messages.get(0));
            return "login";
        }
    }

    @GetMapping("/")
    public String showLoginForm() {
        return "login";
    }
}
