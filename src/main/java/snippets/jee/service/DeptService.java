package snippets.jee.service;

import java.sql.SQLException;
import java.util.List;

import snippets.jee.dto.Dept;

public interface DeptService {

    /**
     * 添加新部门
     * @param dept 部门对象
     * @return 添加成功返回true否则返回false
     * @throws SQLException 
     */
    boolean addNewDept(Dept dept) throws SQLException;

    /**
     * 删除部门
     * @param no 部门编号
     * @return 删除成功返回true否则返回false
     */
    boolean removeDeptByNo(Integer no);

    /**
     * 根据部门获取部门信息
     */
    Dept getDeptByNo(Integer no);

    /**
     * 列出所有部门
     * @return 保存部门对象的列表容器
     */
    List<Dept> listAllDepts();

}
