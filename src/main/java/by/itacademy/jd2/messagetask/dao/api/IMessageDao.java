package by.itacademy.jd2.messagetask.dao.api;

import by.itacademy.jd2.messagetask.dao.api.Dao;
import by.itacademy.jd2.messagetask.domain.Message;

import java.util.List;

public interface IMessageDao extends Dao {
    List<Message> get(String login);
    void add (Message message);
}
