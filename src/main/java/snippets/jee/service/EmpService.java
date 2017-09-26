package snippets.jee.service;

import snippets.jee.dto.EmpDTO;
import snippets.jee.util.PageBean;

public interface EmpService {

    /**
     * 添加新员工
     * @param empDTO 员工对象
     * @return 添加成功返回true否则返回false
     */
    boolean addNewEmp(EmpDTO empDTO);

    /**
     * 根据部门编号列出部门所有员工
     * @param no 部门编号
     * @return 保存员工对象的列表容器
     */
    PageBean<EmpDTO> listAllEmpsByDeptNo(Integer no, int page, int size);

    /**
     * 根据员工编号查询员工
     * @param no 员工编号
     * @return 员工对象或null
     */
    EmpDTO getEmpByNo(int no);
}
