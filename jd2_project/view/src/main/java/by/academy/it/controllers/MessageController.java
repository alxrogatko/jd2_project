package by.academy.it.controllers;

import by.academy.it.DialogService;
import by.academy.it.MessageService;
import by.academy.it.UserService;
import by.academy.it.pojo.Dialog;
import by.academy.it.pojo.Messages;
import by.academy.it.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.util.List;

@Controller
@SessionAttributes({"userId", "userNickname", "receiverId"})
public class MessageController {

    private final MessageService messageService;
    private final DialogService dialogService;
    private final UserService userService;

    @Autowired
    public MessageController(UserService userService, MessageService messageService, DialogService dialogService) {
        this.userService = userService;
        this.messageService = messageService;
        this.dialogService = dialogService;
    }

    @PostMapping(value = "{id}/send.do")
    public String sendMessage(@PathVariable("id") String dialogId, HttpServletRequest request, Model model) throws UnsupportedEncodingException {
        String senderId = String.valueOf(model.getAttribute("userId"));
        String senderNickname = String.valueOf(model.getAttribute("userNickname"));
        String receiverId = String.valueOf(model.getAttribute("receiverId"));
        request.setCharacterEncoding("UTF-8");
        String message = request.getParameter("message");

        dialogService.updateDialogLastMessage(dialogId, message, senderNickname);
        Messages messages = new Messages(dialogId, senderId, receiverId, message, LocalDateTime.now());

        messageService.sendMessage(messages);

        return "redirect:/" + dialogId + "/chat.html";
    }

    @GetMapping(value = "{id}/chat.html")
    public String openChat(@PathVariable("id") String dialogId, Model model) {
        List<Messages> messagesList = messageService.getMessages(dialogId);
        model.addAttribute("showChat", true);
        model.addAttribute("messagesList", messagesList);
        model.addAttribute("dialogId", dialogId);
        return "messages";
    }

    @GetMapping(value = "/{id}/create-dialog.html")
    public String createDialog(@PathVariable("id") String receiverId, Model model) {
        String userId = String.valueOf(model.getAttribute("userId"));
        String userNickname = String.valueOf(model.getAttribute("userNickname"));
        User user = userService.getUserById(receiverId);
        List<Dialog> dialogList = dialogService.getDialog(userId, receiverId);
        Dialog dialog;

        if (dialogList.isEmpty()) {
            dialog = new Dialog(userId, userNickname, receiverId, user.getNickname(), "", "",LocalDateTime.now());
            dialogService.createDialog(dialog);
        } else {
            dialog = dialogList.get(0);
        }

        model.addAttribute("receiverId", receiverId);
        return "redirect:/" + dialog.getId() + "/chat.html";
    }

    @GetMapping(value = "/messages.html")
    public String showDialogs(Model model) {
        String userId = String.valueOf(model.getAttribute("userId"));
        List<Dialog> dialogList = dialogService.getDialogList(userId);
        model.addAttribute("showDialogList", true);
        model.addAttribute("dialogList", dialogList);
        return "messages";
    }

}
