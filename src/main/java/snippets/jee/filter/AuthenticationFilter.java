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
        String contextString = httpServletRequest.getContextPath();
        //Check if the current request is for /login. In that case
        //do nothing, else we will execute the request in loop
        //Intercept only if request is not /login
        if (!(contextString + "/login").equals(httpServletRequest.getRequestURI()) && 
                !(contextString + "/reg").equals(httpServletRequest.getRequestURI()) || 
                httpServletRequest.getSession().getAttribute("username") == null) {
                //User is not logged in. Redirect to /login
                ((HttpServletResponse)resp).sendRedirect(httpServletRequest.getContextPath() + "/login");
                //do not process this request further
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
