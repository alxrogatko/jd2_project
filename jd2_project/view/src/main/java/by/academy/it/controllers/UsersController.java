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
@SessionAttributes({"userId", "userNickname"})
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
        model.addAttribute("thisIsMyFriends", true);
        return "friends";
    }


    @GetMapping("/friends-requests.html")
    public String getFriendsRequestList(Model model, HttpServletRequest request) {
        model.addAttribute("thisIsMyFriends", false);
        String id = String.valueOf(model.getAttribute("userId"));
        model.addAttribute("friends", friendsController.getFriendRequests(id));
        return "friends";
    }

    @GetMapping("/{id}/profile.html")
    public String showUserProfile(@PathVariable("id") String id, Model model, HttpServletRequest request) {
        User user = userController.getUserById(id);
        String requesterId = String.valueOf(model.getAttribute("userId"));
        String requesterNickname = String.valueOf(model.getAttribute("userNickname"));

        if (!checkIfThisMainUserPage(id, requesterId)) {
            model.addAttribute("thisIsNotMainUserPage", true);
            String buttonRequestButtonStatus = request.getParameter("button");
            String databaseRequestStatus = friendsController.getRequestStatus(id, requesterId);

            if (buttonRequestButtonStatus != null && buttonRequestButtonStatus.equals("request") && databaseRequestStatus.equals("none")) {
                addFriendAndTableAndSetStatus(user.getNickname(), requesterNickname, requesterId, user.getId(), buttonRequestButtonStatus);
            }

            databaseRequestStatus = friendsController.getRequestStatus(id, requesterId);

            switch (databaseRequestStatus) {
                case "none":
                    model.addAttribute("requestStatus", "none");
                    break;
                case "request":
                    model.addAttribute("requestStatus", "request");
                    break;
                case "added":
                    model.addAttribute("requestStatus", "added");
                    break;
            }
        }
        model.addAttribute("user", user);
        return "profile";
    }

    private boolean checkIfThisMainUserPage(String id, String userId) {
        return id.equals(userId);
    }

    private void addFriendAndTableAndSetStatus(String receiverNickname, String requesterNickname, String requesterId, String receiverId, String status) {
        LocalDateTime time = LocalDateTime.now();
        Friends friends = new Friends(requesterId, requesterNickname, receiverId, receiverNickname, time, status);
        friendsController.addFriend(friends);
    }
}
