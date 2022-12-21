package by.itacademy.jd2.messagetask.controller;

import by.itacademy.jd2.messagetask.dto.UserDto;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet(name = "MessageServlet", urlPatterns = "/api/message")
    public class MessageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //сообщения для текущего пользователя

        HttpSession session = req.getSession();
        Object user = session.getAttribute("user");
        UserDto userDto = (UserDto) user;
        //service
        //dao
        //getMessages
        //writer write messages
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //отправлять сообщение
    }
}
