package snippets.jee.dao;

import java.util.List;

import snippets.jee.dto.Dept;

public interface DeptDAO {

    /**
     * 保存部门
     * @param dept 部门对象
     * @return 保存成功返回true否则返回false
     */
    boolean save(Dept dept);

    /**
     * 删除部门
     * @param no 部门编号
     * @return 删除成功返回true否则返回false
     */
    boolean deleteByNo(Integer no);

    /**
     * 更新部门
     * @param dept 部门对象
     * @return 更新成功返回true否则返回false
     */
    boolean update(Dept dept);

    /**
     * 根据部门编号查询部门
     * @param no 部门编号
     * @return 部门对象或null
     */
    Dept findById(Integer no);

    /**
     * 查询所有部门
     * @return 保存部门对象的列表容器
     */
    List<Dept> findAll();

    /**
     * 查询部门人数
     * @param no 部门编号
     * @return 部门人数
     */
    int countEmpByNo(Integer no);
}
