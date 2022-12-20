package by.itacademy.jd2.messagetask.dto;

import by.itacademy.jd2.messagetask.domain.UserRole;

import java.time.LocalDate;

public class UserDto {
    private final String login;
    private final String fullName;
    private final LocalDate birthDate;
    private final LocalDate registerDate;
    private final UserRole userRole;

    public UserDto(String login, String fullName, LocalDate birthDate, LocalDate registerDate, UserRole userRole) {
        this.login = login;
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.registerDate = registerDate;
        this.userRole = userRole;
    }

    public String getLogin() {
        return login;
    }

    public String getFullName() {
        return fullName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public LocalDate getRegisterDate() {
        return registerDate;
    }

    public UserRole getUserRole() {
        return userRole;
    }
}
