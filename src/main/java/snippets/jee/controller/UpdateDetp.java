package snippets.jee.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import snippets.jee.dto.Dept;

@WebServlet(value="/updateDept")
public class UpdateDetp extends BaseServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idString = req.getParameter("id");
        int id = Integer.parseInt(idString);
        Dept deptDTO = getDeptService().getDeptByNo(id);
        req.getSession().setAttribute("dept", deptDTO);
        req.getRequestDispatcher("update_dept.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Dept deptDTO = (Dept) req.getSession().getAttribute("dept");
            getDeptService().updateDept(deptDTO);
        } catch (Throwable th) {
            req.setAttribute("hint", "更新失败:)" + th.getMessage());
            resp.sendRedirect("updateDept");
        }
        resp.sendRedirect("dept");
    }

    
}
