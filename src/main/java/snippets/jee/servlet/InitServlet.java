package snippets.jee.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import snippets.jee.db.connection.DatabaseConnectionFactory;

/**
 * Servlet implementation class InitServlet
 */
@WebServlet(value="/iniServlet", loadOnStartup=1)
public class InitServlet extends HttpServlet implements ServletContextListener {

    private static final long serialVersionUID = 1L;

    public InitServlet() {
        super();
    }

    public void init (ServletConfig config) throws ServletException {
        try {
            DatabaseConnectionFactory.getDatabaseConnectionFactory().init();
        } catch (IOException e) {
            config.getServletContext().log(e.getLocalizedMessage(), e);
        }
    }

    @Override
    public void contextInitialized(ServletContextEvent evt) {
        try {
            DatabaseConnectionFactory.getDatabaseConnectionFactory().init();
        } catch (IOException e) {
            evt.getServletContext().log(e.getLocalizedMessage(), e);
        }
    }
}
