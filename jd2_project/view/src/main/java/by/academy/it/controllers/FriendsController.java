package by.academy.it.controllers;

import by.academy.it.controller.UserController;
import by.academy.it.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class FriendsController {

    private final UserController userController;

    @Autowired
    public FriendsController(UserController userController) {
        this.userController = userController;
    }

    @GetMapping("/friends.html")
    public String getFriendsList(Model model) {
        List<User> userList = userController.getUserList();
        model.addAttribute("users", userList);
        return "friends";
    }
}
