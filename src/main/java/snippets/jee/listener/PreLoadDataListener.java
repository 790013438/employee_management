package snippets.jee.listener;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import snippets.jee.dto.Dept;
import snippets.jee.service.DeptService;
import snippets.jee.service.impl.ServiceFactory;

@WebListener
public class PreLoadDataListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent evt) {
        DeptService deptService = ServiceFactory.create(DeptService.class);
        List<Dept> deptList = deptService.listAllDepts();
        Map<Integer, Dept> cacheMap = new ConcurrentHashMap<>();
        for (Dept dept : deptList) {
            cacheMap.put(dept.getNo(), dept);
        }
        ServletContext servletContext = evt.getServletContext();
        servletContext.setAttribute("cache", cacheMap);
    }

    @Override
    public void contextDestroyed(ServletContextEvent evt) {
    }

}
