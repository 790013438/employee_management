package snippets.jee.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value="/delEmp")
public class DelEmpServlet extends BaseServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String noString = req.getParameter("no");
        if (noString != null) {
            int no = Integer.parseInt(noString);
            if (getDeptService().removeDeptByNo(no)) {
                resp.sendRedirect("emp");
            } else {
                req.setAttribute("hint", "删除员工失败");
            }
        }
    }

}
