package by.itacademy.jd2.messagetask.service;

import by.itacademy.jd2.messagetask.dao.api.IUserDao;
import by.itacademy.jd2.messagetask.dto.UserDto;
import by.itacademy.jd2.messagetask.service.api.IUserService;

public class UserService implements IUserService {

    private final IUserDao userDao;

    public UserService(IUserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public UserDto get(String login, String password) {
        return userDao.validateUser(login,password);
    }

    @Override
    public int userQuantity() {
        return userDao.userQuantity();
    }

    @Override
    public boolean exist(String login) {
        return userDao.exist(login);
    }
}
