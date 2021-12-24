package by.academy.it.controllers;

import by.academy.it.UserController;
import by.academy.it.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

@Controller
@SessionAttributes("userId")
public class FriendsController {

    private final UserController userController;

    @Autowired
    public FriendsController(UserController userController) {
        this.userController = userController;
    }

    @GetMapping("/users.html")
    public String getUsersList(Model model) {
        String id = String.valueOf(model.getAttribute("userId"));
        List<User> userList = userController.getUserList(id);
        model.addAttribute("user", userList);
        return "users";
    }

    @GetMapping("/friends.html")
    public String getFriendsList(Model model) {
        return "friends";
    }

    @GetMapping("/{id}/profile.html")
    public String showUserProfile(@PathVariable("id") String id, Model model) {
        User user = userController.getUserById(id);
        model.addAttribute("user", user);
        return "profile";
    }
}
