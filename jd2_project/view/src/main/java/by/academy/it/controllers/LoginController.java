package by.academy.it.controllers;

import by.academy.it.UserController;
import by.academy.it.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class LoginController {

    private final UserController userController;

    @Autowired
    public LoginController(UserController userController) {
        this.userController = userController;
    }

    @RequestMapping(value = "/home.html", method = RequestMethod.POST)
    public String processInputData(@RequestParam("email") String email,
                                   @RequestParam("password") String password,
                                   Model model
    ) {
        List<String> messages = userController.loginUser(email, password);
        if (messages.isEmpty()) {
            List<User> user = userController.getUserByEmail(email);
            model.addAttribute("nickname", user.get(0).getNickname());
            model.addAttribute("gender", user.get(0).getGender());
            model.addAttribute("age", user.get(0).getAge());
            model.addAttribute("birthday", user.get(0).getBirthday());
            return "home";
        } else {
            model.addAttribute("exception", messages.get(0));
            return "login";
        }
    }

    @RequestMapping("/")
    public String showLoginForm() {
        return "login";
    }
}
