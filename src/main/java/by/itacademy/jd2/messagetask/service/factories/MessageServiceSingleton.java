package by.itacademy.jd2.messagetask.service.factories;

import by.itacademy.jd2.messagetask.dao.factories.MemoryMessageDaoSingleton;
import by.itacademy.jd2.messagetask.service.MessageService;
import by.itacademy.jd2.messagetask.service.api.IMessageService;

public class MessageServiceSingleton {
    private volatile static MessageService INSTANCE;

    private MessageServiceSingleton() {}

    public static IMessageService getInstance() {
        if(INSTANCE == null){
            synchronized (MessageService.class){
                if(INSTANCE == null){
                    INSTANCE = new MessageService(MemoryMessageDaoSingleton.getInstance());
                }
            }
        }
        return INSTANCE;
    }
}
