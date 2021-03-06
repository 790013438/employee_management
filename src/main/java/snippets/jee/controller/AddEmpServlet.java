package snippets.jee.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import snippets.jee.dto.Dept;
import snippets.jee.dto.EmpDTO;
import snippets.jee.util.CommonUtil;

@WebServlet(value = "/addEmp", loadOnStartup = 1)
@MultipartConfig(maxFileSize = 10 * 1024 * 1024)
public class AddEmpServlet extends BaseServlet {
    private static final int DEFAULT_IMAGE_WIDTH = 200;
    private static final int DEFAULT_IMAGE_HEIGHT = 150;

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse resp) throws ServletException, IOException {
        int no = Integer.parseInt(httpServletRequest.getParameter("no"));
        String name = httpServletRequest.getParameter("name");
        boolean sex = httpServletRequest.getParameter("sex").equals("1");
        String job = httpServletRequest.getParameter("job");
        double salary = Double.parseDouble(httpServletRequest.getParameter("salary"));
        String hireDateStr = httpServletRequest.getParameter("hiredate");
        Date hireDate = CommonUtil.stringToDate("yyyy-MM-dd", hireDateStr);
        String tel = httpServletRequest.getParameter("tel");
        EmpDTO empDTO = new EmpDTO();
        empDTO.setNo(no);
        empDTO.setName(name);
        empDTO.setJob(job);
        empDTO.setSex(sex ? "男" : "女");
        empDTO.setSalary(salary);
        empDTO.setStatus("在职");
        empDTO.setHireDate(hireDate);
        empDTO.setTel(tel);
        EmpDTO mgr = new EmpDTO();
        empDTO.setMgr(mgr);
        Part part = httpServletRequest.getPart("photo");
        if (part.getSize() > 0) {
            String newFilename = CommonUtil.getUniqueFilename() + ".png";
            String path = httpServletRequest.getServletContext().getRealPath("/images");
            File file = new File(path + "/" + newFilename);
            file.mkdir();
            CommonUtil.compressImage(part.getInputStream(), file, DEFAULT_IMAGE_WIDTH, DEFAULT_IMAGE_HEIGHT);
            empDTO.setPhoto(newFilename);
        }
        int deptNo = Integer.parseInt(httpServletRequest.getParameter("dno"));
        Dept dept = new Dept();
        dept.setId(deptNo);
        empDTO.setDept(dept);
        if (getEmpService().addNewEmp(empDTO)) {
            resp.sendRedirect("toEmp?no=" + deptNo);
        } else {
            httpServletRequest.setAttribute("hint", "添加失败!!!");
            httpServletRequest.getRequestDispatcher("add_emp.jsp").forward(httpServletRequest, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        httpServletRequest.getRequestDispatcher("add_emp.jsp").forward(httpServletRequest, httpServletResponse);
    }

}
