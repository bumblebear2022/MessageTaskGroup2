package by.itacademy.jd2.messagetask.service.api;

import by.itacademy.jd2.messagetask.dto.UserDto;
import by.itacademy.jd2.messagetask.dto.UserDtoWithoutDate;

public interface IUserService {

    UserDto get(String login, String password);

    int userQuantity();

    boolean exist(String login);

    void add(UserDtoWithoutDate userDtoWithoutDate);
}
