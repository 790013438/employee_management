package snippets.jee.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import snippets.jee.service.UserService;
import snippets.jee.service.impl.UserServiceImpl;

@WebServlet(urlPatterns="/login", loadOnStartup = 1)
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if (username != null && password != null) {
            if (userService.login(username, password)) {
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

}
