package snippets.jee.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

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
            try {
                if (getDeptService().addNewDept(dept)) {
                 // 如果添加部门成功则先刷新缓存数据再重定向到查看部门页面
                    @SuppressWarnings("unchecked")
                    Map<Integer, Dept> map = (Map<Integer, Dept>) 
                            req.getServletContext().getAttribute("cache");
                    map.put(dept.getId(), dept);
                    resp.sendRedirect("dept");
                } else {
                    req.setAttribute("hint", "添加部门失败!");
                    req.getRequestDispatcher("add_dept.jsp").forward(req, resp);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            req.setAttribute("hint", "请输入完整的部门信息");
            req.getRequestDispatcher("add_dept.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        httpServletRequest.getRequestDispatcher("add_dept.jsp").forward(httpServletRequest, httpServletResponse);
    }

}
