package by.itacademy.jd2.messagetask.service;

import by.itacademy.jd2.messagetask.dao.api.IMessageDao;
import by.itacademy.jd2.messagetask.domain.Message;
import by.itacademy.jd2.messagetask.dto.MessageDto;
import by.itacademy.jd2.messagetask.service.api.IMessageService;

import java.util.List;

public class MessageService implements IMessageService {

    private final IMessageDao dao;

    public MessageService(IMessageDao dao) {
        this.dao = dao;
    }

    public List<Message> get(String login) {
        return dao.get(login);
    }

    public void add(MessageDto message) {
        dao.add(new Message(message));
    }


    @Override
    public int userQuantity() {
        return dao.messageQuantity();
    }
}
