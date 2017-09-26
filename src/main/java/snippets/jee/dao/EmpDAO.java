package snippets.jee.dao;

import snippets.jee.dto.EmpDTO;
import snippets.jee.util.PageBean;

public interface EmpDAO {

    /**
     * 根据部门编号查找该部门所有员工
     * @param no 部门编号
     * @return 保存员工对象的列表容器
     */
    PageBean<EmpDTO> findEmpsByDeptNo(Integer no, int page, int size);

    /**
     * 保存员工
     * @param empDTO 员工对象
     * @return 保存成功返回true否则返回false
     */
    boolean save(EmpDTO empDTO);

    /**
     * 删除员工
     * @param no 员工编号
     * @return 删除成功返回true否则返回false
     */
    boolean deleteByNo(Integer no);

    /**
     * 更新员工
     * @param empDTO 员工对象
     * @return 更新成功返回true否则返回false
     */
    boolean update(EmpDTO empDTO);

    /**
     * 根据员工编号查找员工
     * @param no 员工编号
     * @return 员工对象或null
     */
    EmpDTO findByNo(Integer no);

}
