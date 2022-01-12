package by.academy.it.controllers;

import by.academy.it.DialogService;
import by.academy.it.MessageService;
import by.academy.it.pojo.Dialog;
import by.academy.it.pojo.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@SessionAttributes({"userId", "userNickname"})
public class MessageController {

    private final MessageService messageService;
    private final DialogService dialogService;

    @Autowired
    public MessageController(MessageService messageService, DialogService dialogService) {
        this.messageService = messageService;
        this.dialogService = dialogService;
    }

    @GetMapping(value = "/{id}/create-dialog.html")
    public String createDialog(@PathVariable("id") String id, Model model) {
        String userId = String.valueOf(model.getAttribute("userId"));

        if (dialogService.checkIfDialogExist(userId, id)) {
            List<Messages> messagesList = messageService.getMessages(userId, id);
            model.addAttribute("messagesList", messagesList);
        } else {
            Dialog dialog = new Dialog(userId, id, "", LocalDateTime.now());
            dialogService.createDialog(dialog);
        }
        return "messages";
    }

    @GetMapping(value = "/{id}/messages.html")
    public String showChat(@PathVariable("id") String id, Model model) {
        return "messages";
    }

}
