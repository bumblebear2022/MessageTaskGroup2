package by.itacademy.jd2.messagetask.service.api;

import by.itacademy.jd2.messagetask.dto.UserDto;

public interface IUserService {

    UserDto get(String login, String password);

    int userQuantity();

    boolean exist(String login);
}
