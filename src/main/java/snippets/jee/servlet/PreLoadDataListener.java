package snippets.jee.servlet;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import snippets.jee.dto.Dept;
import snippets.jee.service.DeptService;
import snippets.jee.service.impl.ServiceFactory;

@WebServlet(value="/preLoadData", loadOnStartup=2)
public class PreLoadDataListener extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    public void init (ServletConfig servletConfig) {
        DeptService deptService = ServiceFactory.create(DeptService.class);
        List<Dept> deptList = deptService.listAllDepts();
        Map<Integer, Dept> cacheMap = new ConcurrentHashMap<>();
        for (Dept dept : deptList) {
            cacheMap.put(dept.getNo(), dept);
        }
        ServletContext servletContext = servletConfig.getServletContext();
        servletContext.setAttribute("cache", cacheMap);
    }

}
