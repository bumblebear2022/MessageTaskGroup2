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
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        String contextPath = req.getContextPath();
        HttpSession session = req.getSession();
        if ((session != null) && (session.getAttribute("user") != null)) {
            UserDto userDto = (UserDto) session.getAttribute("user");
            if(userDto.getUserRole().equals(UserRole.ADMIN)){
                chain.doFilter(request, response);
            }else {
                resp.sendRedirect(contextPath + "/signIn");
            }
        } else {
            resp.sendRedirect(contextPath + "/signIn");
        }
    }

    @Override
    public void destroy() {

    }
}
