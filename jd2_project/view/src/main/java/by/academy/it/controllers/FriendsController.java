package by.academy.it.controllers;

import by.academy.it.UserController;
import by.academy.it.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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
        model.addAttribute("user", userList);
        return "friends";
    }

    @GetMapping("/{id}")
    public String showFriendProfile(@PathVariable("id") String id, Model model) {
        User user = userController.getUserById(id);
        model.addAttribute("nickname", user.getNickname());
        model.addAttribute("gender", user.getGender());
        model.addAttribute("age", user.getAge());
        model.addAttribute("birthday", user.getBirthday());
        return "profile";
    }
}
