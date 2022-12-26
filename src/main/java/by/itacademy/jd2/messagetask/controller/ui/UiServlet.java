package by.itacademy.jd2.messagetask.controller.ui;

import by.itacademy.jd2.messagetask.domain.Message;
import by.itacademy.jd2.messagetask.dto.StatisticsDto;
import by.itacademy.jd2.messagetask.service.api.IStatisticsService;
import by.itacademy.jd2.messagetask.service.factories.StatisticsServiceSingleton;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

@WebServlet(name = "UiServlet", urlPatterns = "/ui/*")
public class UiServlet extends HttpServlet {
    private static final Pattern WELCOME_PATTERN = Pattern.compile("^/ui$");
    private static final Pattern SIGN_UP_PATTERN = Pattern.compile("^/ui/signUp$");
    private static final Pattern SIGN_IN_PATTERN = Pattern.compile("^/ui/signIn$");
    private static final Pattern USER_MESSAGE_PATTERN = Pattern.compile("^/ui/user/message$");
    private static final Pattern USER_CHATS_PATTERN = Pattern.compile("^/ui/user/chats$");
    private static final Pattern ADMIN_STATISTICS_PATTERN = Pattern.compile("^/ui/admin/statistics$");

    private final IStatisticsService statisticsService = StatisticsServiceSingleton.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        ViewPage viewPage = parseURI(req.getRequestURI(),req.getContextPath());
        try {
            switch (viewPage) {
                case SIGN_UP: {
                    req.getRequestDispatcher("/view/signUp.jsp").forward(req, resp);
                }
                case SIGN_IN: {
                    req.getRequestDispatcher("/view/signIn.jsp").forward(req, resp);
                }
                case USER_MESSAGE: {
                    Message message1 = new Message(LocalDateTime.now(), "admin1", "admin1", "1test text");

                    List<Message> messages = new ArrayList<>();
                    messages.add(message1);
                    req.setAttribute("messages", messages);

                    req.getRequestDispatcher("/view/testMessage.jsp").forward(req, resp);
                }
                case USER_CHATS: {
                    req.getRequestDispatcher("/view/chats.jsp").forward(req, resp);
                }
                case ADMIN_STATISTICS: {
                    StatisticsDto statistics = statisticsService.getStatistics();
                    req.setAttribute("statistics", statistics);
                    req.getRequestDispatcher("/view/statistics.jsp").forward(req, resp);
                }
                case WELCOME: {
                    req.getRequestDispatcher("/view/welcome.jsp").forward(req, resp);
                }
            }
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    private ViewPage parseURI(String uri,String contextPath) {
        String endpoint = uri.replace(contextPath,"");

        boolean welcome = WELCOME_PATTERN.matcher(endpoint).matches();
        if (welcome) {
            return ViewPage.WELCOME;
        }
        boolean signUp = SIGN_UP_PATTERN.matcher(endpoint).matches();
        if (signUp) {
            return ViewPage.SIGN_UP;
        }
        boolean signIn = SIGN_IN_PATTERN.matcher(endpoint).matches();
        if (signIn) {
            return ViewPage.SIGN_IN;
        }
        boolean userMessage = USER_MESSAGE_PATTERN.matcher(endpoint).matches();
        if (userMessage) {
            return ViewPage.USER_MESSAGE;
        }
        boolean userChats = USER_CHATS_PATTERN.matcher(endpoint).matches();
        if (userChats) {
            return ViewPage.USER_CHATS;
        }
        boolean adminStatistics = ADMIN_STATISTICS_PATTERN.matcher(endpoint).matches();
        if (adminStatistics) {
            return ViewPage.ADMIN_STATISTICS;
        }
        throw new IllegalStateException();
    }

}
