package snippets.jee.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import snippets.jee.service.DeptService;
import snippets.jee.service.impl.DeptServiceImpl;

@WebServlet("/dept")
public class ShowDeptServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private DeptService deptService = new DeptServiceImpl();

    @Override
    protected void service (HttpServletRequest httpServiceRequest, HttpServletResponse httpServiceResponse) throws ServletException, IOException {
        httpServiceRequest.setAttribute("deptList", deptService.listAllDepts());
        httpServiceRequest.getRequestDispatcher("dept.jsp").forward(httpServiceRequest, httpServiceResponse);
    }
}
