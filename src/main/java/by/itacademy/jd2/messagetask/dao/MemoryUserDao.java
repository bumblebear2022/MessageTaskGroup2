package by.itacademy.jd2.messagetask.dao;

import by.itacademy.jd2.messagetask.domain.User;
import by.itacademy.jd2.messagetask.dto.UserDto;

public class MemoryUserDao implements IUserDao{

    @Override
    public UserDto get(String login) {
        return null;
    }

    @Override
    public void add(User user) {
    }

    @Override
    public boolean checkUser(String login) {
        return false;
    }

    @Override
    public UserDto validateUser(String login, String password) {
        return null;
    }

    @Override
    public void delete(String login) {

    }
}
