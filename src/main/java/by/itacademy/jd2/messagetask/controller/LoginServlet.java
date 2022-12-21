package by.itacademy.jd2.messagetask.controller;

import by.itacademy.jd2.messagetask.domain.User;
import by.itacademy.jd2.messagetask.dto.UserDto;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Map;


@WebServlet(name = "LoginServlet", urlPatterns = "/login")
    public class LoginServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Map<String, String[]> parameterMap = req.getParameterMap();
        HttpSession session = req.getSession();

//        session.setAttribute("user",new UserDto());

    }
}
