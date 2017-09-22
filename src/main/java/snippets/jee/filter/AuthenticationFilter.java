package snippets.jee.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class AuthenticationFilter
 */
@WebFilter({ "/AuthenticationFilter", "/*" })
public class AuthenticationFilter implements Filter {

    /**
     * Default constructor. 
     */
    public AuthenticationFilter() {
    }

    /**
     * @see Filter#destroy()
     */
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, 
            FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        String servletPath = request.getServletPath();
        if (servletPath.equals("/dept") || servletPath.equals("/delDept") ||
                servletPath.equals("/addDept")) {
            if (request.getSession().getAttribute("username") != null) {
                chain.doFilter(req, resp);
            } else {
                request.setAttribute("hint", "未登录!!!");
                request.getRequestDispatcher("login.jsp").forward(req, resp);
            }
        } else {
            chain.doFilter(req, resp);
        }
    }

    /**
     * @see Filter#init(FilterConfig)
     */
    public void init(FilterConfig fConfig) throws ServletException {
    }

}
