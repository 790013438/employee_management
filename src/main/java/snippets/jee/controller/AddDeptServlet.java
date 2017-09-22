package snippets.jee.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import snippets.jee.dto.Dept;

@WebServlet(value="/addDept", loadOnStartup = 1)
public class AddDeptServlet extends BaseServlet {
    
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String noString = req.getParameter("no");
        String name = req.getParameter("name");
        String location = req.getParameter("location");
        if (noString != null) {
            int no = Integer.parseInt(noString);
            Dept dept = new Dept();
            dept.setNo(no);
            dept.setName(name);
            dept.setLocation(location);
            if (getDeptService().addNewDept(dept)) {
                resp.sendRedirect("dept");
            } else {
                req.setAttribute("hint", "添加部门失败!");
                req.getRequestDispatcher("add_dept.jsp").forward(req, resp);
            }
        } else {
            req.setAttribute("hint", "请输入完整的部门信息");
            req.getRequestDispatcher("add_dept.jsp").forward(req, resp);
        }
    }

}