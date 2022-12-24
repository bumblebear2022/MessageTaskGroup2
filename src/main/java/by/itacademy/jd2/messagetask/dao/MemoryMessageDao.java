package by.itacademy.jd2.messagetask.dao;

import by.itacademy.jd2.messagetask.dao.api.IMessageDao;
import by.itacademy.jd2.messagetask.domain.Message;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemoryMessageDao implements IMessageDao {
    private Map<String, List<Message>> toWhomMessages = new HashMap<>();


    @Override
    public List<Message> get(String login) {
        return null;
    }

    @Override
    public void add(Message message) {
        String login = message.getToWhom().getLogin();
        List<Message> messages = toWhomMessages.get(login);
        if(messages!=null){
            messages.add(message);
        }else {
            List<Message> newMessageList = new ArrayList<>();
            newMessageList.add(message);
            toWhomMessages.put(login,newMessageList);
        }
    }
}
