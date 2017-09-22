package snippets.jee.controller;

import javax.servlet.http.HttpServlet;

import snippets.jee.service.DeptService;
import snippets.jee.service.UserService;
import snippets.jee.service.impl.ServiceFactory;

public class BaseServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * 获取用户业务对象
     */
    protected UserService getUserService() {
        return ServiceFactory.create(UserService.class);
    }

    /**
     * 获取部门业务对象
     */
    protected DeptService getDeptService() {
        return ServiceFactory.create(DeptService.class);
    }
}
