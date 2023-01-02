package by.itacademy.jd2.messagetask.controller.api;

import by.itacademy.jd2.messagetask.domain.Message;
import by.itacademy.jd2.messagetask.dto.MessageDto;
import by.itacademy.jd2.messagetask.dto.UserDto;
import by.itacademy.jd2.messagetask.service.api.IMessageService;
import by.itacademy.jd2.messagetask.service.api.IUserService;
import by.itacademy.jd2.messagetask.service.factories.MessageServiceSingleton;
import by.itacademy.jd2.messagetask.service.factories.UserServiceSingleton;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


@WebServlet(name = "MessageServlet", urlPatterns = "/api/message")
    public class MessageServlet extends HttpServlet {

    private final IMessageService messageService = MessageServiceSingleton.getInstance();

    private final IUserService userService = UserServiceSingleton.getINSTANCE();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        HttpSession session = req.getSession();
        UserDto user = (UserDto) session.getAttribute("user");
        if (user == null) {
            throw new ServletException();
        }
        List<Message> list = messageService.get(user.getLogin());
        if (list != null) {
            int counter = 1;
            for (Message p : list) {
                writer.write("<br><span style='color: MidnightBlue;'>"
                        + counter
                        + p.getSendDateTime().getMinute()
                        + ":"
                        + p.getSendDateTime().getSecond()
                        + " - " + p.getText()
                        + "!" + "</span><br>"
                );
                ++counter;
            }
        } else {
            writer.write("<br><span style='color: MidnightBlue;'> У вас пока нет входящих сообщений </span><br>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        UserDto user = (UserDto) session.getAttribute("user");
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        String text = req.getParameter("Text");
        String forWhom = req.getParameter("To");
        if (req.getParameter("messageLock") != null) {
            if (text != null && forWhom != null) {
                if (userService.exist(forWhom)) {
                    messageService.add(new MessageDto(user.getLogin(), forWhom, text));
                    session.setAttribute("messageLock", "Ваше сообщение отправлено!");
                } else {
                    session.setAttribute("messageLock", "Пользователя не существует!");
                }
            } else {
                session.setAttribute("messageLock", "Не хватает данных о получателе или тексте сообщения!");
            }
            req.getRequestDispatcher("/view/message.jsp").forward(req, resp);
        } else {
            if (text != null && forWhom != null) {
                if (userService.exist(forWhom)) {
                    messageService.add(new MessageDto(user.getLogin(), forWhom, text));
                    writer.write("<br><span style='color: MidnightBlue;'> Ваше сообщение отправлено! </span><br>");
                } else {
                    writer.write("<br><span style='color: MidnightBlue;'> Пользователя не существует! </span><br>");
                }
            } else {
                writer.write("<br><span style='color: MidnightBlue;'> Не хватает данных о получателе или тексте сообщения! </span><br>");
            }
        }
    }
}
