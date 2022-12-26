package by.itacademy.jd2.messagetask.controller.api;

import by.itacademy.jd2.messagetask.dto.UserDto;
import by.itacademy.jd2.messagetask.exceptions.UserValidateException;
import by.itacademy.jd2.messagetask.service.api.IUserService;
import by.itacademy.jd2.messagetask.service.factories.UserServiceSingleton;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


@WebServlet(name = "LoginServlet", urlPatterns = "/api/login")
public class LoginServlet extends HttpServlet {
    private static final String LOGIN = "login";
    private static final String PASSWORD = "password";
    public static final String TAB = ",  ";
    public static final String UI = "ui";
    private final IUserService userService = UserServiceSingleton.getINSTANCE();


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html; charset=UTF-8");
        String login = req.getParameter(LOGIN);
        String password = req.getParameter(PASSWORD);
        String isUi = req.getParameter(UI);
        try {
            PrintWriter writer = resp.getWriter();
            if (login.isBlank() || password.isBlank()) {
                writer.write("Please input both parameters");
            } else {
                UserDto userDto = userService.get(login, password);
                HttpSession session = req.getSession();
                session.setAttribute("user", userDto);
                if (!isUi.isBlank()) {
                    resp.sendRedirect(req.getContextPath() + "/ui");
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (UserValidateException e) {
            List<String> userExceptionList = e.getUserExceptionList();
            String voteExceptions = String.join(TAB, userExceptionList);
            resp.sendError(HttpServletResponse.SC_EXPECTATION_FAILED, voteExceptions);
        }

    }
}

