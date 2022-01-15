package by.academy.it.controllers;

import by.academy.it.UserService;
import by.academy.it.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.util.List;

@Controller
@SessionAttributes({"userId", "userNickname"})
public class RegistrationController {

    private final UserService userService;

    @Autowired
    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/check-registration.html", method = RequestMethod.POST)
    public String checkInputData(
            HttpServletRequest request,
            @RequestParam("email") String email,
            @RequestParam("nickname") String nickname,
            @RequestParam("password") String password,
            @RequestParam("repassword") String repassword,
            @RequestParam(value = "age", required = false) String age,
            @RequestParam(value = "birthday", required = false) String birthday
    ) throws UnsupportedEncodingException {

        LocalDateTime currentTime = LocalDateTime.now();
        request.setCharacterEncoding("UTF-8");

        if (age.isEmpty()) {
            age = "Не указано";
        }
        if (birthday.isEmpty()) {
            birthday = "Не указано";
        }

        User user = new User(email.trim(), currentTime, password, currentTime, nickname, request.getParameter("gender"), age, birthday, currentTime);
        List<String> userList = userService.newUserRegistration(user, repassword);

        if (userList.isEmpty()) {
            return "successful-register";
        } else {
            request.setAttribute("exception", userList.get(0));
            return "registration";
        }
    }

    @GetMapping(path = "/registration.html")
    public String registration() {
        return "registration";
    }
}
