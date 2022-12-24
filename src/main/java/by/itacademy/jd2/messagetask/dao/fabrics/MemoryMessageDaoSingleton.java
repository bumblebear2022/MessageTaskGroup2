package by.itacademy.jd2.messagetask.dao.fabrics;

import by.itacademy.jd2.messagetask.dao.MemoryMessageDao;
import by.itacademy.jd2.messagetask.dao.api.IMessageDao;

public class MemoryMessageDaoSingleton {
    private volatile static MemoryMessageDao instance;

    private MemoryMessageDaoSingleton() {
    }

    public static IMessageDao getInstance() {
        if(instance == null){
            synchronized (IMessageDao.class){
                if(instance == null){
                    instance = new MemoryMessageDao();
                }
            }
        }
        return instance;
    }
}
