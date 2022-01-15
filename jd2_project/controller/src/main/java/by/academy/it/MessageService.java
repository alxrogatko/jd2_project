package by.academy.it;

import by.academy.it.dao.MessageDao;
import by.academy.it.pojo.Messages;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

    private final MessageDao messageDao;

    public MessageService(MessageDao messageDao) {
        this.messageDao = messageDao;
    }

    public void sendMessage(Messages messages) {
        messageDao.sendMessage(messages);
    }

    public List<Messages> getMessages(String dialogId) {
        return messageDao.readMessages(dialogId);
    }
}
