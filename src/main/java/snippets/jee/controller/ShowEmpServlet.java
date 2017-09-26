package snippets.jee.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

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
            // 1. 将对象转换成JSON格式的字符串返回给浏览器
            String jsonStr = JSON.toJSONString(pageBean);
            // 2. 把JSON字符串输出到浏览器通过MIME类型告诉浏览器这里是JSON格式
            resp.setContentType("application/json;charset=utf-8");
            PrintWriter printWriter = resp.getWriter();
            printWriter.write(jsonStr);
            printWriter.close();
        }
    }
}
