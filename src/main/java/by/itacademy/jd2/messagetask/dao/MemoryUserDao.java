package by.itacademy.jd2.messagetask.dao;

import by.itacademy.jd2.messagetask.dao.api.IUserDao;
import by.itacademy.jd2.messagetask.domain.User;
import by.itacademy.jd2.messagetask.domain.UserRole;
import by.itacademy.jd2.messagetask.dto.UserDto;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class MemoryUserDao implements IUserDao {

    private final String ADMIN = "admin";
    private Map<String, User> userMap = new HashMap<>();

    public MemoryUserDao() {
        User admin = User.builder()
                .setLogin(ADMIN)
                .setPassword(ADMIN)
                .setFullName(ADMIN)
                .setBirthDate(null)
                .setRegisterDate(null)
                .setUserRole(UserRole.ADMIN)
                .build();
        userMap.put(ADMIN,admin);
    }

    @Override
    public UserDto get(String login) {
        User user = userMap.get(login);
        return mapUserToUserDto(user);
    }

    @Override
    public int userQuantity() {
        return userMap.size();
    }

    @Override
    public void add(User user) {
        String login = user.getLogin();
        userMap.put(login,user);
    }

    @Override
    public boolean exist(String login) {
        return userMap.containsKey(login);
    }

    @Override
    public UserDto validateUser(String login, String password) {
        User user = userMap.get(login);
        String actualPassword = user.getPassword();
        boolean isValidated = actualPassword.equals(password);
        UserDto userDto = mapUserToUserDto(user);
        return isValidated
                ? userDto
                : null;
    }

    @Override
    public boolean isAuthenticated(String login, String password) {
        User user = userMap.get(login);
        String actualPassword = (user!=null) ? user.getPassword():null;
        return password.equals(actualPassword);
    }

    @Override
    public void delete(String login) {
        userMap.remove(login);
    }

    private UserDto mapUserToUserDto(User user) {
        String login = user.getLogin();
        String fullName = user.getFullName();
        LocalDate registerDate = user.getRegisterDate();
        LocalDate birthDate = user.getBirthDate();
        UserRole userRole = user.getUserRole();
        return new UserDto(login, fullName, birthDate, registerDate, userRole);
    }
}
