package snippets.jee.service;

import snippets.jee.dto.Emp;
import snippets.jee.util.PageBean;

public interface EmpService {

    /**
     * 添加新员工
     * @param emp 员工对象
     * @return 添加成功返回true否则返回false
     */
    boolean addNewEmp(Emp emp);

    /**
     * 根据部门编号列出部门所有员工
     * @param no 部门编号
     * @return 保存员工对象的列表容器
     */
    PageBean<Emp> listAllEmpsByDeptNo(Integer no, int page, int size);

}
