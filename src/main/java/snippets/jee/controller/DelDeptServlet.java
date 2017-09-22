package snippets.jee.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value="/delDept")
public class DelDeptServlet extends BaseServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String noString = req.getParameter("no");
        if (noString != null) {
            int no = Integer.parseInt(noString);
            String responseTextString = getDeptService().removeDeptByNo(no) ? "success" : "failed";
            PrintWriter printWriter = resp.getWriter();
            printWriter.write(responseTextString);
            printWriter.close();
        }
    }
}
