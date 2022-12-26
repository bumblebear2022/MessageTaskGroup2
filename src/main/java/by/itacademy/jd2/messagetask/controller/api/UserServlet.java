package by.itacademy.jd2.messagetask.controller.api;

import by.itacademy.jd2.messagetask.dto.UserDtoWithoutDate;
import by.itacademy.jd2.messagetask.service.api.IUserService;
import by.itacademy.jd2.messagetask.service.factories.UserServiceSingleton;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;


@WebServlet(name = "UserServlet", urlPatterns = "/api/user")
    public class UserServlet  extends HttpServlet {

    private final String LOGIN_PARAM = "login";
    private final String PASSWORD_PARAM = "password";
    private final String FULL_NAME_PARAM = "fullName";
    private final String BIRTHDATE_PARAM = "birthday";
    private final IUserService userService = UserServiceSingleton.getINSTANCE();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = resp.getWriter();

        String login = getValue(req, LOGIN_PARAM);
        String password = getValue(req, PASSWORD_PARAM);
        String fullName = getValue(req, FULL_NAME_PARAM);
        String birthDateString = (getValue(req, BIRTHDATE_PARAM));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate birthDate = (!birthDateString.isBlank())? LocalDate.parse(birthDateString, formatter):null;

        if (login.isBlank() || password.isBlank() || fullName.isBlank() || birthDate == null) {
            throw new IllegalArgumentException("Все поля должны быть заполнены!");
        }
        UserDtoWithoutDate user = new UserDtoWithoutDate(login,password,fullName, birthDate);
        saveSession(req, LOGIN_PARAM, user);
        userService.add(user);
        writer.write("<p> Вы зарегистрированы </p>");
    }


    public String getValue(HttpServletRequest req, String key){
        String val = req.getParameter(key);
        if (val == null){
            HttpSession session = req.getSession();
            if (!session.isNew()){
                val = (String) session.getAttribute(key);
            }
        }
        if (val == null){
            throw new IllegalArgumentException("Не переданы параметры");
        }
        return val;
    }

    private void saveSession(HttpServletRequest req, String key, UserDtoWithoutDate user){
        HttpSession session = req.getSession();
        session.setAttribute(key, user);
    }


    }



