package snippets.jee.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/dept")
public class ShowDeptServlet extends BaseServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void service (HttpServletRequest httpServiceRequest, HttpServletResponse httpServiceResponse) throws ServletException, IOException {
        httpServiceRequest.setAttribute("deptList", getDeptService().listAllDepts());
        httpServiceRequest.getRequestDispatcher("dept.jsp").forward(httpServiceRequest, httpServiceResponse);
    }
}
