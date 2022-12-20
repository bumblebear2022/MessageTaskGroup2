package by.itacademy.jd2.messagetask.dao;

import by.itacademy.jd2.messagetask.domain.User;
import by.itacademy.jd2.messagetask.dto.UserDto;

public interface IUserDao extends Dao{
    UserDto get(String login);
    void add (User user);
    boolean checkUser (String login);
    UserDto validateUser (String login, String password);
    void delete(String login);
}
