package by.itacademy.jd2.messagetask.controller.api;

import by.itacademy.jd2.messagetask.dto.UserDto;
import by.itacademy.jd2.messagetask.service.api.IUserService;
import by.itacademy.jd2.messagetask.service.factories.UserServiceSingleton;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet(name = "LoginServlet", urlPatterns = "/api/login")
public class LoginServlet extends HttpServlet {
    private static final String LOGIN = "login";
    private static final String PASSWORD = "password";
    IUserService userService = UserServiceSingleton.getINSTANCE();


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        String login = req.getParameter(LOGIN);
        String password = req.getParameter(PASSWORD);

        try {
            if (login == null || password == null) {
                resp.sendError(HttpServletResponse.SC_FORBIDDEN, "Wrong login or password");
            }
            boolean isUserExist = userService.exist(login);
            if (!isUserExist) {
                resp.sendError(HttpServletResponse.SC_FORBIDDEN, "User not exist");
            }

            UserDto userDto = userService.get(login, password);
            if (userDto == null) {
                resp.sendError(HttpServletResponse.SC_FORBIDDEN, "Wrong password");
            } else {
                HttpSession session = req.getSession();
                session.setAttribute("user", userDto);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            req.getRequestDispatcher("/view/welcome.jsp").forward(req, resp);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
