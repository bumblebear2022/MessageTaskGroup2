package by.itacademy.jd2.messagetask.dao;

import by.itacademy.jd2.messagetask.dao.api.IMessageDao;
import by.itacademy.jd2.messagetask.domain.Message;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MemoryMessageDao implements IMessageDao {
    private final Map<String, List<Message>> toWhomMessages = new HashMap<>();

    @Override
    public List<Message> get(String login) {
        if (toWhomMessages.get(login) == null) {
            return null;
        } else if (toWhomMessages.get(login).size() == 0) {
            return null;
        } else {
            return toWhomMessages.get(login);
        }
    }

    @Override
    public void add(Message message) {
        String login = message.getToWhom();
        toWhomMessages.computeIfAbsent(login, k -> new ArrayList<>());
        toWhomMessages.get(login).add(message);
    }

    @Override
    public int messageQuantity() {
        Collection<List<Message>> values = toWhomMessages.values();
        int messageQuantity = 0;
        for (List<Message> list : values) {
            messageQuantity += list.size();
        }
        return messageQuantity;
    }
}
