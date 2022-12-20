package by.itacademy.jd2.messagetask.dao;

import by.itacademy.jd2.messagetask.domain.Message;
import by.itacademy.jd2.messagetask.domain.User;
import by.itacademy.jd2.messagetask.dto.UserDto;

import java.util.List;

public interface IMessageDao extends Dao{
    List<Message> get(String login);
    void add (Message message);
}
