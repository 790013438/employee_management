package snippets.jee.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/empDetail")
public class ShowEmpDetailServlet extends BaseServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String noString = req.getParameter("no");
        int no = Integer.parseInt(noString);
        req.setAttribute("emp", getEmpService().getEmpByNo(no));
        req.getRequestDispatcher("emp_detail.jsp").forward(req, resp);
    }
}
