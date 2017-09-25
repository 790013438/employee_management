package snippets.jee.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/emp")
public class ShowEmpServlet extends BaseServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String noString = req.getParameter("no");
        String name = req.getParameter("name");
        if (noString != null) {
            int no = Integer.parseInt(noString);
            req.setAttribute("deptNo", no);
            req.setAttribute("deptName", name);
            req.setAttribute("empList", getEmpService().listAllEmpsByDeptNo(no));
            req.getRequestDispatcher("emp.jsp").forward(req, resp);
        }
    }
}
