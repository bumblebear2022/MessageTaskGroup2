package by.itacademy.jd2.messagetask.filters;

import by.itacademy.jd2.messagetask.domain.UserRole;
import by.itacademy.jd2.messagetask.dto.UserDto;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = {"/ui/admin/*", "/api/admin/*"})
public class AdminSecurityFilter implements Filter {

    public static final String USER = "user";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        HttpSession session = req.getSession();
        if (session == null
                || session.getAttribute(USER) == null) {
            redirectToSignIn(req, resp);
            return;
        }
        UserDto userDto = (UserDto) session.getAttribute(USER);
        if (userDto.getUserRole() != UserRole.ADMIN) {
            redirectToSignIn(req, resp);
            return;
        }
        chain.doFilter(request, response);
    }

    private void redirectToSignIn(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String contextPath = req.getContextPath();
        resp.sendRedirect(contextPath + "/ui/signIn");
    }

    @Override
    public void destroy() {

    }
}
