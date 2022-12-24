package by.itacademy.jd2.messagetask.controller.api;

import by.itacademy.jd2.messagetask.dao.MemoryUserDao;
import by.itacademy.jd2.messagetask.listeners.ActiveUserListener;
import by.itacademy.jd2.messagetask.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet(name = "StatisticsServlet", urlPatterns = "/api/admin/statistics")
    public class StatisticsServlet  extends HttpServlet {

    MemoryUserDao memoryUserDao = new MemoryUserDao();
    UserService userService = new UserService(memoryUserDao);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();

        int activeUserQuantity = ActiveUserListener.getQuantity();

        int registeredUsersQuantity = userService.userQuantity();

        int messages = 5;

        //writer.write
    }

}
