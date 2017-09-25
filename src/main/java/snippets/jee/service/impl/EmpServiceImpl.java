package snippets.jee.service.impl;

import snippets.jee.dao.EmpDAO;
import snippets.jee.dao.impl.EmpDAOImpl;
import snippets.jee.dto.Emp;
import snippets.jee.service.EmpService;
import snippets.jee.util.PageBean;

public class EmpServiceImpl implements EmpService {
    private EmpDAO empDao = new EmpDAOImpl();

    @Override
    public boolean addNewEmp(Emp emp) {
        return empDao.save(emp);
    }

    @Override
    public PageBean<Emp> listAllEmpsByDeptNo(Integer no, int page, int size) {
        return empDao.findEmpsByDeptNo(no, page, size);
    }
}
