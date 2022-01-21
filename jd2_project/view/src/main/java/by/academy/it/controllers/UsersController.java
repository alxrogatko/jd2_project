package by.academy.it.controllers;

import by.academy.it.FriendsService;
import by.academy.it.UserService;
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

    private final UserService userService;
    private final FriendsService friendsService;

    @Autowired
    public UsersController(UserService userService, FriendsService friendsService) {
        this.userService = userService;
        this.friendsService = friendsService;
    }

    @GetMapping("/users.html")
    public String getUsersList(Model model) {
        String id = String.valueOf(model.getAttribute("userId"));
        List<User> userList = userService.getUserList(id);
        model.addAttribute("user", userList);
        model.addAttribute("thisIsUsers", true);
        return "friends";
    }

    @GetMapping("/friends.html")
    public String getFriendsList(Model model) {
        String mainId = String.valueOf(model.getAttribute("userId"));
        model.addAttribute("thisIsMyFriends", true);
        List<Friends> friendsList = friendsService.showFriendsList(mainId);
        model.addAttribute("friends", friendsList);
        return "friends";
    }


    @GetMapping("/friends-requests.html")
    public String getFriendsRequestList(Model model, HttpServletRequest request) {
        model.addAttribute("thisIsMyFriends", false);
        String receiverId = String.valueOf(model.getAttribute("userId"));

        String requesterId = request.getParameter("button");
        model.addAttribute("friends", friendsService.getFriendRequests(receiverId));


        if (requesterId != null) {
            if (!requesterId.equals("decline")) {
                friendsService.updateFriendStatus(LocalDateTime.now(), requesterId, receiverId, "added");
            } else {
                friendsService.deleteFriendRequest(receiverId, requesterId);
            }
        }

        model.addAttribute("friends", friendsService.getFriendRequests(receiverId));

        return "friends";
    }

    @GetMapping("/{id}/profile.html")
    public String showUserProfile(@PathVariable("id") String id, Model model, HttpServletRequest request) {
        User user = userService.getUserById(id);
        String requesterId = String.valueOf(model.getAttribute("userId"));
        String requesterNickname = String.valueOf(model.getAttribute("userNickname"));

        if (!checkIfThisMainUserPage(id, requesterId)) {
            model.addAttribute("thisIsNotMainUserPage", true);
            String buttonRequestStatus = request.getParameter("button");
            String databaseRequestStatus = friendsService.getRequestStatus(id, requesterId);

            if (buttonRequestStatus != null && buttonRequestStatus.equals("request") && databaseRequestStatus.equals("none")) {
                addFriendAndTableAndSetStatus(LocalDateTime.now(), user.getNickname(), requesterNickname, requesterId, user.getId(), buttonRequestStatus);
            }

            databaseRequestStatus = friendsService.getRequestStatus(id, requesterId);

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

    private void addFriendAndTableAndSetStatus(LocalDateTime addDate, String receiverNickname, String requesterNickname, String requesterId, String receiverId, String status) {
        Friends friends = new Friends(requesterId, requesterNickname, receiverId, receiverNickname, addDate, status);
        friendsService.addFriend(friends);
    }
}
