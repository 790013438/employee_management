package snippets.jee.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import snippets.jee.dto.Dept;

@WebServlet("/emp")
public class ShowEmpServlet extends BaseServlet {

    private static final long serialVersionUID = 1L;
    private static final int DEFAULT_PAGE = 1;

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
            // 1. 将对象转换成JSON格式的字符串返回给浏览器
            // { 'empList': [{'no': 1122, 'name': '骆昊',  ...}, {}, ...], 'totalPage': 4, 'currentPage': 2, 'pageSize': 5 }
            // Gson / Fastjson
            String jsonStr = "";
            // 2. 把JSON字符串输出到浏览器通过MIME类型告诉浏览器这里是JSON格式
            resp.setContentType("application/json;charset=utf-8");
            PrintWriter printWriter = resp.getWriter();
            printWriter.write(jsonStr);
            printWriter.close();
        }
    }
}
