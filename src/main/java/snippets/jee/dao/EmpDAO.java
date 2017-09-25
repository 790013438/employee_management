package snippets.jee.dao;

import java.util.List;

import snippets.jee.dto.Emp;

public interface EmpDAO {

    /**
     * 根据部门编号查找该部门所有员工
     * @param no 部门编号
     * @return 保存员工对象的列表容器
     */
    List<Emp> findEmpsByDeptNo(Integer no);

    /**
     * 保存员工
     * @param emp 员工对象
     * @return 保存成功返回true否则返回false
     */
    boolean save(Emp emp);

    /**
     * 删除员工
     * @param no 员工编号
     * @return 删除成功返回true否则返回false
     */
    boolean deleteByNo(Integer no);

    /**
     * 更新员工
     * @param emp 员工对象
     * @return 更新成功返回true否则返回false
     */
    boolean update(Emp emp);

    /**
     * 根据员工编号查找员工
     * @param no 员工编号
     * @return 员工对象或null
     */
    Emp findByNo(Integer no);

}
