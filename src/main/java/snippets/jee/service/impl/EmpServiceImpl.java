package snippets.jee.service.impl;

import snippets.jee.dao.EmpDAO;
import snippets.jee.dao.impl.EmpDAOImpl;
import snippets.jee.dto.EmpDTO;
import snippets.jee.service.EmpService;
import snippets.jee.util.PageBean;

public class EmpServiceImpl implements EmpService {
    private EmpDAO empDao = new EmpDAOImpl();

    @Override
    public boolean addNewEmp(EmpDTO empDTO) {
        return empDao.save(empDTO);
    }

    @Override
    public PageBean<EmpDTO> listAllEmpsByDeptNo(Integer no, int page, int size) {
        return empDao.findEmpsByDeptNo(no, page, size);
    }

    @Override
    public EmpDTO getEmpByNo(int no) {
        return empDao.findByNo(no);
    }
}
