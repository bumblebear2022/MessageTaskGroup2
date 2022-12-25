package by.itacademy.jd2.messagetask.service;

import by.itacademy.jd2.messagetask.dao.api.IUserDao;
import by.itacademy.jd2.messagetask.domain.User;
import by.itacademy.jd2.messagetask.domain.UserRole;
import by.itacademy.jd2.messagetask.dto.UserDto;
import by.itacademy.jd2.messagetask.dto.UserDtoWithoutDate;
import by.itacademy.jd2.messagetask.service.api.IUserService;

import java.time.LocalDate;

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

    public void add(UserDtoWithoutDate userDtoWithoutDate) {
        User user = mapUserDtoWithoutDateToUser(userDtoWithoutDate);
        userDao.add(user);
    }
    private User mapUserDtoWithoutDateToUser(UserDtoWithoutDate userDtoWithoutDate){
        String login = userDtoWithoutDate.getLogin();
        String password = userDtoWithoutDate.getPassword();
        String fullName = userDtoWithoutDate.getFullName();
        LocalDate birthDate = userDtoWithoutDate.getBirthDate();
        UserRole userRole = userDtoWithoutDate.getUserRole();
        LocalDate localDate = LocalDate.now();
        return new User(login,password,fullName,birthDate,localDate,userRole);
    }
}
