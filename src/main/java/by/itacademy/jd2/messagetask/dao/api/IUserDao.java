package by.itacademy.jd2.messagetask.dao.api;

import by.itacademy.jd2.messagetask.dao.api.Dao;
import by.itacademy.jd2.messagetask.domain.User;
import by.itacademy.jd2.messagetask.dto.UserDto;

public interface IUserDao extends Dao {
    UserDto get(String login);
    int userQuantity();
    void add (User user);
    boolean exist(String login);
    UserDto validateUser (String login, String password);
    void delete(String login);
}
