package snippets.jee.service.impl;

import java.util.List;

import snippets.jee.dao.EmpDAO;
import snippets.jee.dao.impl.EmpDAOImpl;
import snippets.jee.dto.Emp;
import snippets.jee.service.EmpService;

public class EmpServiceImpl implements EmpService {
    private EmpDAO empDao = new EmpDAOImpl();

    @Override
    public boolean addNewEmp(Emp emp) {
        return empDao.save(emp);
    }

    @Override
    public List<Emp> listAllEmpsByDeptNo(Integer no) {
        return empDao.findEmpsByDeptNo(no);
    }
}
