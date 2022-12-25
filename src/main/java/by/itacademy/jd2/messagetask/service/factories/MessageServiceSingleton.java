package by.itacademy.jd2.messagetask.service.factories;

import by.itacademy.jd2.messagetask.dao.factories.MemoryMessageDaoSingleton;
import by.itacademy.jd2.messagetask.service.MessageService;

public class MessageServiceSingleton {
    private volatile static MessageService instance;

    private MessageServiceSingleton() {}

    public static MessageService getInstance() {
        if(instance == null){
            synchronized (MessageService.class){
                if(instance == null){
                    instance = new MessageService(MemoryMessageDaoSingleton.getInstance());
                }
            }
        }
        return instance;
    }
}
