package by.itacademy.jd2.messagetask.dao.factories;

import by.itacademy.jd2.messagetask.dao.MemoryMessageDao;
import by.itacademy.jd2.messagetask.dao.api.IMessageDao;

public class MemoryMessageDaoSingleton {
    private volatile static MemoryMessageDao INSTANCE;

    private MemoryMessageDaoSingleton() {
    }

    public static IMessageDao getInstance() {
        if(INSTANCE == null){
            synchronized (IMessageDao.class){
                if(INSTANCE == null){
                    INSTANCE = new MemoryMessageDao();
                }
            }
        }
        return INSTANCE;
    }
}
