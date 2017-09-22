package snippets.jee.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value="/login", loadOnStartup=1)
public class LoginServlet extends BaseServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if (username != null && password != null) {
            if (getUserService().login(username, password)) {
                req.getSession().setAttribute("username", username);
                resp.sendRedirect("dept");
            } else {
                req.setAttribute("hint", "用户名或密码错误!");
                req.getRequestDispatcher("login.jsp").forward(req, resp);
            }
        } else {
            req.setAttribute("hint", "请输入有效的登录信息!");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServeltResponse) throws ServletException, IOException {
        httpServletRequest.getRequestDispatcher("login.jsp").forward(httpServletRequest, httpServeltResponse);
    }

}
