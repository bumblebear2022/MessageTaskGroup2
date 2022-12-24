package by.itacademy.jd2.messagetask.service.factories;

import by.itacademy.jd2.messagetask.dao.factories.UserDaoSingleton;
import by.itacademy.jd2.messagetask.service.UserService;
import by.itacademy.jd2.messagetask.service.api.IUserService;

public class UserServiceSingleton {
    private volatile static IUserService INSTANCE;

    private UserServiceSingleton() {
    }

    public static IUserService getINSTANCE() {
        if (INSTANCE == null) {
            synchronized (UserServiceSingleton.class) {
                if (INSTANCE == null) {
                    INSTANCE = new UserService(UserDaoSingleton.getINSTANCE());
                }
            }
        }
        return INSTANCE;
    }
}

