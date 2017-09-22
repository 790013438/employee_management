package snippets.jee.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import snippets.jee.dto.UserDTO;

@WebServlet(value="/reg")
public class RegServlet extends BaseServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        if (username != null && password != null && email != null) {
            UserDTO user = new UserDTO();
            user.setUsername(username);
            user.setPassword(password);
            user.setEmail(email);
            if (getUserService().register(user)) {
                resp.sendRedirect("login.jsp");
            } else {
                req.setAttribute("hint", "注册失败! 请尝试更换用户名!");
                req.getRequestDispatcher("register.jsp").forward(req, resp);
            }
        } else {
            req.setAttribute("hint", "请输入有效的注册信息!");
            req.getRequestDispatcher("register.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        httpServletRequest.getRequestDispatcher("register.jsp").forward(httpServletRequest, httpServletResponse);
    }

}
