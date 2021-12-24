package by.academy.it.controllers;

import by.academy.it.FriendsController;
import by.academy.it.UserController;
import by.academy.it.pojo.Friends;
import by.academy.it.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.List;

@Controller
@SessionAttributes("userId")
public class UsersController {

    private final UserController userController;
    private final FriendsController friendsController;

    @Autowired
    public UsersController(UserController userController, FriendsController friendsController) {
        this.userController = userController;
        this.friendsController = friendsController;
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
    public String showUserProfile(@PathVariable("id") String id, Model model, HttpServletRequest request) {
        User user = userController.getUserById(id);
        String mainUserId = String.valueOf(model.getAttribute("userId"));

        if (!id.equals(mainUserId)) {
            String friendRequestStatus = request.getParameter("button");
            if (friendRequestStatus != null) {
                if (friendRequestStatus.equals("added")) {
                    Friends friends = new Friends(mainUserId, user.getId(), LocalDateTime.now(), "added");
                    friendsController.addFriend(friends);
                }
            }
        }
        model.addAttribute("user", user);
        return "profile";
    }
}
