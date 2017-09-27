package snippets.jee.service.impl;

import snippets.jee.dao.EmpDAO;
import snippets.jee.dao.impl.EmpDAOImpl;
import snippets.jee.dto.EmpDTO;
import snippets.jee.service.EmpService;
import snippets.jee.util.PageBean;

public class EmpServiceImpl implements EmpService {
    private EmpDAO empDAO = new EmpDAOImpl();

    @Override
    public boolean addNewEmp(EmpDTO empDTO) {
        return empDAO.save(empDTO);
    }

    @Override
    public PageBean<EmpDTO> listAllEmpsByDeptNo(Integer no, int page, int size) {
        return empDAO.findEmpsByDeptNo(no, page, size);
    }

    @Override
    public EmpDTO getEmpByNo(int no) {
        return empDAO.findByNo(no);
    }

    @Override
    public boolean removeEmpByNo(Integer no) {
        return empDAO.deleteByNo(no);
    }
}
