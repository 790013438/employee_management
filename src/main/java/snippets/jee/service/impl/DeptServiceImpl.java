package snippets.jee.service.impl;

import java.util.List;

import snippets.jee.dao.DeptDAO;
import snippets.jee.dao.impl.DeptDAOImpl;
import snippets.jee.dto.Dept;
import snippets.jee.service.DeptService;

public class DeptServiceImpl implements DeptService {

private DeptDAO deptDAO = new DeptDAOImpl();
    
    @Override
    public List<Dept> listAllDepts() {
        return deptDAO.findAll();
    }

    @Override
    public boolean removeDeptByNo(Integer no) {
        if (deptDAO.countEmpByNo(no) == 0) {
            return deptDAO.deleteByNo(no);
        }
        return false;
    }

    @Override
    public boolean addNewDept (Dept dept) {
        return deptDAO.save(dept);
    }

    @Override
    public Dept getDeptByNo(Integer no) {
        return deptDAO.findById(no);
    }
}
