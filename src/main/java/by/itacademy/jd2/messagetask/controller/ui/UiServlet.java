package by.itacademy.jd2.messagetask.controller.ui;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.regex.Pattern;

@WebServlet(name = "UiServlet", urlPatterns = "/ui/*")
public class UiServlet extends HttpServlet {

    private static final Pattern SIGN_UP_PATTERN = Pattern.compile("^/ui/signUp$");

    private static final Pattern SIGN_IN_PATTERN = Pattern.compile("^/ui/signIn$");

    private static final Pattern USER_MESSAGE_PATTERN = Pattern.compile("^/ui/user/message$");

    private static final Pattern USER_CHATS_PATTERN = Pattern.compile("^/ui/user/chats$");


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        ViewPage viewPage = parseURI(req.getRequestURI());
        try {
            switch (viewPage) {
                case SIGN_UP: {
                    req.getRequestDispatcher("/view/signUp.jsp").forward(req, resp);
                }
                case SIGN_IN: {
                    req.getRequestDispatcher("/view/signIn.jsp").forward(req, resp);
                }
                case USER_MESSAGE: {
                    req.getRequestDispatcher("/view/message.jsp").forward(req, resp);
                }
                case USER_CHATS: {
                    req.getRequestDispatcher("/view/chats.jsp").forward(req, resp);
                }
            }
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    private ViewPage parseURI(String uri) {

        boolean signUp = SIGN_UP_PATTERN.matcher(uri).matches();
        if (signUp) {
            return ViewPage.SIGN_UP;
        }
        boolean signIn = SIGN_IN_PATTERN.matcher(uri).matches();
        if (signIn) {
            return ViewPage.SIGN_IN;
        }
        boolean userMessage = USER_MESSAGE_PATTERN.matcher(uri).matches();
        if (userMessage) {
            return ViewPage.USER_MESSAGE;
        }
        boolean userChats = USER_CHATS_PATTERN.matcher(uri).matches();
        if (userChats) {
            return ViewPage.USER_CHATS;
        }
        throw new IllegalStateException();
    }

}
