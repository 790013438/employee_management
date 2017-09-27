package snippets.jee.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import snippets.jee.dto.Dept;

@WebServlet("/dept")
public class ShowDeptServlet extends BaseServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void service (HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        httpServletRequest.getSession().removeAttribute("dept");
        @SuppressWarnings("unchecked")
        Map<Integer, Dept> map = (Map<Integer, Dept>) httpServletRequest.getServletContext().getAttribute("cache");
        httpServletRequest.setAttribute("deptList", new ArrayList<>(map.values()));
        httpServletRequest.getRequestDispatcher("dept.jsp").forward(httpServletRequest, httpServletResponse);
    }
}
