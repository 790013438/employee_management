package snippets.jee.controller;

import java.io.IOException;
import java.util.Map;

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
        String idString = req.getParameter("id");
        String noString = req.getParameter("no");
        String name = req.getParameter("name");
        String location = req.getParameter("location");
        Dept deptDTO = new Dept();
        if (noString != null) {
            int id = Integer.parseInt(idString);
            int no = Integer.parseInt(noString);
            deptDTO.setId(id);
            deptDTO.setNo(no);
            deptDTO.setName(name);
            deptDTO.setLocation(location);
        }
        try {
            getDeptService().updateDept(deptDTO);
        } catch (Throwable th) {
            req.setAttribute("hint", "更新失败:)" + th.getMessage());
            resp.sendRedirect("updateDept");
        }
     // 如果添加部门成功则先刷新缓存数据再重定向到查看部门页面
        @SuppressWarnings("unchecked")
        Map<Integer, Dept> map = (Map<Integer, Dept>) 
                req.getServletContext().getAttribute("cache");
        map.put(deptDTO.getId(), deptDTO);
        resp.sendRedirect("dept");
    }

    
}
