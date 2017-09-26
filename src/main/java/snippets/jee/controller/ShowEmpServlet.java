package snippets.jee.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import snippets.jee.dto.EmpDTO;
import snippets.jee.util.PageBean;

@WebServlet("/emp")
public class ShowEmpServlet extends BaseServlet {

    private static final long serialVersionUID = 1L;
    private static final int DEFAULT_PAGE = 1;
    private static final int DEFAULT_SIZE = 5;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String noString = req.getParameter("no");
        String name = req.getParameter("name");
        int page = DEFAULT_PAGE;
        int size = DEFAULT_SIZE;
        if (noString != null) {
            int no = Integer.parseInt(noString);
            req.setAttribute("deptNo", no);
            req.setAttribute("deptName", name);
            PageBean<EmpDTO> pageBean = getEmpService().listAllEmpsByDeptNo(no, page, size);
            req.setAttribute("empList", pageBean.getDataModel());
            req.setAttribute("totalPage", pageBean.getTotalPage());
            req.setAttribute("currentPage", pageBean.getCurrentPage());
            req.getRequestDispatcher("emp.jsp").forward(req, resp);
        }
    }
}
