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
import javax.servlet.http.HttpServletResponse;

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
        HttpServletRequest httpServletRequest = (HttpServletRequest) req;
        String contextString = httpServletRequest.getServletPath();
        if ((contextString + "/login").equals(httpServletRequest.getRequestURI())) {
            if (httpServletRequest.getSession().getAttribute("username") != null) {
                chain.doFilter(req, resp);
            } else {
                httpServletRequest.setAttribute("hint", "咦，你登录了吗？");
                httpServletRequest.getRequestDispatcher("login.jsp").forward(req, resp);
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
