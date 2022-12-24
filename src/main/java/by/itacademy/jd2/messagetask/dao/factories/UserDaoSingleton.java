package by.itacademy.jd2.messagetask.dao.factories;

import by.itacademy.jd2.messagetask.dao.api.IUserDao;
import by.itacademy.jd2.messagetask.dao.MemoryUserDao;

public class UserDaoSingleton {

        private volatile static IUserDao INSTANCE;

        private UserDaoSingleton() {
        }

        public static IUserDao getINSTANCE() {
            if (INSTANCE == null) {
                synchronized (UserDaoSingleton.class) {
                    if (INSTANCE == null) {
                        INSTANCE = new MemoryUserDao();
                    }
                }
            }
            return INSTANCE;
        }

}
