package snippets.jee.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import snippets.jee.service.DeptService;
import snippets.jee.service.impl.DeptServiceImpl;

@WebServlet(value="/delDept")
public class DelDeptServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private DeptService deptService = new DeptServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String noString = req.getParameter("no");
        if (noString != null) {
            int no = Integer.parseInt(noString);
            deptService.removeDeptByNo(no);
        }
        resp.sendRedirect("dept");
    }
}
