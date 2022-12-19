package by.itacademy.jd2.messagetask.domain;

import java.time.LocalDate;

public class User {
    private final String login;
    private final String password;
    private final String fullName;
    private final LocalDate birthDate;
    private final LocalDate registerDate;
    private final UserRole userRole;

    public User(String login, String password, String fullName, LocalDate birthDate, LocalDate registerDate, UserRole userRole) {
        this.login = login;
        this.password = password;
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.registerDate = registerDate;
        this.userRole = userRole;
    }

    public static UserBuilder builder(){
        return new UserBuilder();
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

    public LocalDate getRegisterDate() {
        return registerDate;
    }

    public UserRole getUserRole() {
        return userRole;
    }


    public static class UserBuilder {

      private String login;
      private String password;
      private String fullName;
      private LocalDate birthDate;
      private LocalDate registerDate;
      private UserRole userRole;

        private UserBuilder() {
        }

        public UserBuilder setLogin(String login) {
            this.login = login;
            return this;
        }

        public UserBuilder setPassword(String password) {
            this.password = password;
            return this;
        }

        public UserBuilder setFullName(String fullName) {
            this.fullName = fullName;
            return this;
        }

        public UserBuilder setBirthDate(LocalDate birthDate) {
            this.birthDate = birthDate;
            return this;
        }

        public UserBuilder setRegisterDate(LocalDate registerDate) {
            this.registerDate = registerDate;
            return this;
        }

        public UserBuilder setUserRole(UserRole userRole) {
            this.userRole = userRole;
            return this;
        }

        public User build(){
            return new User(login,password,fullName,birthDate,registerDate,userRole);
        }
    }
}
