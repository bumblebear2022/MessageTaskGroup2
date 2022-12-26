package by.itacademy.jd2.messagetask.service;

import by.itacademy.jd2.messagetask.dao.api.IUserDao;
import by.itacademy.jd2.messagetask.domain.User;
import by.itacademy.jd2.messagetask.domain.UserRole;
import by.itacademy.jd2.messagetask.dto.UserDto;
import by.itacademy.jd2.messagetask.dto.UserDtoWithoutDate;
import by.itacademy.jd2.messagetask.exceptions.UserValidateException;
import by.itacademy.jd2.messagetask.service.api.IUserService;

import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UserService implements IUserService {


    public static final String USER_NOT_EXIST = "User not exist";
    public static final String INCORRECT_PASSWORD_FOR_USER = "Incorrect password for User: ";
    private final IUserDao userDao;

    public UserService(IUserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public UserDto get(String login, String password) {
        validate(login);
        return userDao.validateUser(login, password);
    }

    @Override
    public int userQuantity() {
        return userDao.userQuantity();
    }

    @Override
    public boolean validate(String login) {
        List<String> errors = new ArrayList<>();
        boolean isUserExist = userDao.exist(login);
        if (!isUserExist) {
            errors.add(USER_NOT_EXIST + login);
        }
        boolean isAuthenticated = userDao.isAuthenticated(login, "password");
        if (!isAuthenticated) {
            errors.add(INCORRECT_PASSWORD_FOR_USER + login);
        }
        if (!errors.isEmpty()) {
            throw new UserValidateException(errors);
        }else return true;
    }

    @Override
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
