package snippets.jee.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import snippets.jee.dto.Dept;
import snippets.jee.dto.EmpDTO;
import snippets.jee.util.PageBean;

@WebServlet("/emp")
public class ShowEmpServlet extends BaseServlet {

    private static final long serialVersionUID = 1L;
    private static final int DEFAULT_PAGE = 1;
    private static final int DEFAULT_SIZE = 5;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Dept dept = (Dept) req.getSession().getAttribute("dept");
        String noString = req.getParameter("no");
        int no = Integer.parseInt(noString);
        if (dept == null || no != dept.getNo()) {
            dept = getDeptService().getDeptByNo(no);
            req.getSession().setAttribute("dept", dept);
        }
        if (dept != null) {
            int page = DEFAULT_PAGE;
            String pageStr = req.getParameter("page");
            if (pageStr != null) {
                try {
                    page = Integer.parseInt(pageStr);
                    page = page <= 0 ? DEFAULT_PAGE : page;
                } catch (NumberFormatException e) {
                }
            }
            int size = DEFAULT_SIZE;
            PageBean<EmpDTO> pageBean = getEmpService().listAllEmpsByDeptNo(dept.getNo(), page, size);
            req.setAttribute("empList", pageBean.getDataModel());
            req.setAttribute("totalPage", pageBean.getTotalPage());
            req.setAttribute("currentPage", pageBean.getCurrentPage());
            req.getRequestDispatcher("emp.jsp").forward(req, resp);
        }
    }
}
