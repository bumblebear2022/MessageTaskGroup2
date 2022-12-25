package by.itacademy.jd2.messagetask.controller.api;

import by.itacademy.jd2.messagetask.dao.MemoryUserDao;
import by.itacademy.jd2.messagetask.dto.StatisticsDto;
import by.itacademy.jd2.messagetask.listeners.ActiveUserListener;
import by.itacademy.jd2.messagetask.service.UserService;
import by.itacademy.jd2.messagetask.service.api.IStatisticsService;
import by.itacademy.jd2.messagetask.service.factories.StatisticsServiceSingleton;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "StatisticsServlet", urlPatterns = "/api/admin/statistics")
    public class StatisticsServlet  extends HttpServlet {

    private final IStatisticsService statisticsService = StatisticsServiceSingleton.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = resp.getWriter();

        StatisticsDto statistics = statisticsService.getStatistics();
        int activeUsers = statistics.getActiveUsers();
        int messageQuantity = statistics.getMessageQuantity();
        int registeredUsers = statistics.getRegisteredUsers();

        writer.write("<p> Active users: " + activeUsers +"</p>");
        writer.write("<p> Message quantity: " + messageQuantity +"</p>");
        writer.write("<p> Registered users: " + registeredUsers +"</p>");
    }

}
