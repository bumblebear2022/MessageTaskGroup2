package by.itacademy.jd2.messagetask.dto;

import by.itacademy.jd2.messagetask.domain.UserRole;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Objects;

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

    public static UserDtoBuilder builder() {
        return new UserDtoBuilder();
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDto userDto = (UserDto) o;
        return Objects.equals(login, userDto.login) && Objects.equals(fullName, userDto.fullName) && Objects.equals(birthDate, userDto.birthDate) && Objects.equals(registerDate, userDto.registerDate) && userRole == userDto.userRole;
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, fullName, birthDate, registerDate, userRole);
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "login='" + login + '\'' +
                ", fullName='" + fullName + '\'' +
                ", birthDate=" + birthDate +
                ", registerDate=" + registerDate +
                ", userRole=" + userRole +
                '}';
    }

    public static class UserDtoBuilder {
        private String login;
        private String fullName;
        private LocalDate birthDate;
        private LocalDate registerDate;
        private UserRole userRole;

        public UserDtoBuilder setLogin(String login) {
            this.login = login;
            return this;
        }

        public UserDtoBuilder setFullName(String fullName) {
            this.fullName = fullName;
            return this;
        }

        public UserDtoBuilder setBirthDate(LocalDate birthDate) {
            this.birthDate = birthDate;
            return this;
        }

        public UserDtoBuilder setRegisterDate(LocalDate registerDate) {
            this.registerDate = registerDate;
            return this;
        }

        public UserDtoBuilder setUserRole(UserRole userRole) {
            this.userRole = userRole;
            return this;
        }


        public UserDto build() {

            return new UserDto(login, fullName, birthDate,registerDate,userRole);
        }
    }

}
