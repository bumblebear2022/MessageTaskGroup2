package by.itacademy.jd2.messagetask.dto;

import by.itacademy.jd2.messagetask.domain.UserRole;

import java.time.LocalDate;

public class UserDtoWithoutDate {
    private final String login;
    private final String password;
    private final String fullName;
    private final LocalDate birthDate;
    private final UserRole userRole;


    public UserDtoWithoutDate(String login, String password, String fullName, LocalDate birthDate) {
        this.login = login;
        this.password = password;
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.userRole = UserRole.USER;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getFullName() {
        return fullName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public UserRole getUserRole() {
        return userRole;
    }
}
