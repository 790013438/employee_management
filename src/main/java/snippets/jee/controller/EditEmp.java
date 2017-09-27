package snippets.jee.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import snippets.jee.dto.EmpDTO;

@WebServlet(value="/editEmp")
public class EditEmp extends BaseServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idString = req.getParameter("no");
        int id = Integer.parseInt(idString);
        EmpDTO empDTO = getEmpService().getEmpByNo(id);
        req.getSession().setAttribute("emp", empDTO);
        req.getRequestDispatcher("editEmp.jsp").forward(req, resp);
    }

}
