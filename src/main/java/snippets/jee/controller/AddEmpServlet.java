package snippets.jee.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import snippets.jee.dto.Dept;
import snippets.jee.dto.Emp;
import snippets.jee.util.CommonUtil;

@WebServlet("/addEmp")
public class AddEmpServlet extends BaseServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int no = Integer.parseInt(req.getParameter("no"));
        String name = req.getParameter("name");
        boolean sex = req.getParameter("sex").equals("1");
        String job = req.getParameter("job");
        double salary = Double.parseDouble(req.getParameter("salary"));
        String hireDateStr = req.getParameter("hiredate");
        System.out.println(hireDateStr);
        Date hireDate = CommonUtil.stringToDate("yyyy-MM-dd", hireDateStr);
        String tel = req.getParameter("tel");
        Emp emp = new Emp();
        emp.setNo(no);
        emp.setName(name);
        emp.setJob(job);
        emp.setSex(sex);
        emp.setSalary(salary);
        emp.setStatus(true);
        emp.setHireDate(hireDate);
        emp.setTel(tel);
        Emp mgr = new Emp();
        emp.setMgr(mgr);
        Part part = req.getPart("photo");
        if (part.getSize() > 0) {
            String originalName = part.getSubmittedFileName();
            String newFilename = CommonUtil.getUniqueFilename() +
                CommonUtil.getFilenameSuffix(originalName);
            String path = req.getServletContext().getRealPath("/images");
            part.write(path + "/" + newFilename);
            emp.setPhoto(newFilename);
        }
        int deptNo = Integer.parseInt(req.getParameter("dno"));
        Dept dept = new Dept();
        dept.setNo(deptNo);
        emp.setDept(dept);
        if (getEmpService().addNewEmp(emp)) {
            resp.sendRedirect("emp?no=" + deptNo);
        } else {
            req.setAttribute("hint", "添加失败!!!");
            req.getRequestDispatcher("add_emp.jsp").forward(req, resp);
        }
    }

}
