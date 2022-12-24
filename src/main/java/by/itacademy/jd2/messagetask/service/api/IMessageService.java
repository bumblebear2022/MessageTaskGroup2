package by.itacademy.jd2.messagetask.service.api;

import by.itacademy.jd2.messagetask.domain.Message;
import by.itacademy.jd2.messagetask.dto.MessageDto;

import java.util.List;

public interface IMessageService {

    public List<Message> get(String s);

    public void add(MessageDto message);
}
