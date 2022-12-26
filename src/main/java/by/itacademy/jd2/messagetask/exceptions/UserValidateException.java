package by.itacademy.jd2.messagetask.exceptions;

import java.util.List;

public class UserValidateException extends RuntimeException{
    private final List<String> userExceptionList;

    public UserValidateException(List<String> userExceptionList) {
        this.userExceptionList = userExceptionList;
    }

    public List<String> getUserExceptionList() {
        return userExceptionList;
    }
}
