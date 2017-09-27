
package snippets.jee.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import snippets.jee.dao.EmpDAO;
import snippets.jee.dto.EmpDTO;
import snippets.jee.util.DBResourceManager;
import snippets.jee.util.PageBean;

public class EmpDAOImpl implements EmpDAO {
    private static final String SELECT_EMP_BY_DEPT_SQL = 
        "select eno, ename, esex, ejob, estatus, etel from tb_emp where tb_dept_id=? limit ?,?";
    private static final String SELECT_EMP_COUNT_SQL = "select count(eno) from tb_emp where tb_dept_id=?";
    private static final String INSERT_EMP_SQL =
        "insert into tb_emp(eno, ename, esex, ejob, tb_emp_id, esal, ehiredate, estatus, ephoto, etel, tb_dept_id) values (?,?,?,?,?,?,?,?,?,?,?)";
    private static final String SELECT_EMP_SQL = 
            "select ephoto from tb_emp where eno=?";

    @Override
    public PageBean<EmpDTO> findEmpsByDeptNo(Integer no, int page, int size) {
        Connection connection = DBResourceManager.openConnection();
        ResultSet rs = DBResourceManager.executeQuery(connection, SELECT_EMP_BY_DEPT_SQL, no, (page - 1) * size, size);
        ResultSet rs2 = DBResourceManager.executeQuery(connection, SELECT_EMP_COUNT_SQL, no);
        List<EmpDTO> empList = new ArrayList<>();
        try {
            while (rs.next()) {
                EmpDTO empDTO = new EmpDTO();
                empDTO.setNo(rs.getInt("eno"));
                empDTO.setName(rs.getString("ename"));
                empDTO.setSex(rs.getBoolean("esex") ? "男" : "女");
                empDTO.setJob(rs.getString("ejob"));
                empDTO.setStatus(rs.getBoolean("estatus") ? "在职" : "离职");
                empDTO.setTel(rs.getString("etel"));
                empList.add(empDTO);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("37:)", e);
        }
        int total = 0;
        try {
            total = rs2.next() ? rs2.getInt(1) : 0;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e + "48:)");
        } finally {
            DBResourceManager.closeConnection(connection);
        }
        int totalPage = (total - 1) / size + 1;
        empList = empList.size() > 0 ? empList : Collections.emptyList();
        return new PageBean<>(empList, totalPage, page, size);
    }

    @Override
    public boolean save(EmpDTO empDTO) {
        Connection connection = DBResourceManager.openConnection();
        try {
            return DBResourceManager.executeUpdate(connection, INSERT_EMP_SQL, 
                    empDTO.getNo(), empDTO.getName(), "男".equals(empDTO.getSex()),
                    empDTO.getJob(), empDTO.getMgr().getId(), empDTO.getSalary(), 
                    empDTO.getHireDate(), "在职".equals(empDTO.getStatus()), empDTO.getPhoto(), 
                    empDTO.getTel(), empDTO.getDept().getId()) == 1;
        } finally {
            DBResourceManager.closeConnection(connection);
        }
    }

    @Override
    public boolean deleteByNo(Integer no) {
        return false;
    }

    @Override
    public boolean update(EmpDTO empDTO) {
        return false;
    }

    @Override
    public EmpDTO findByNo(Integer no) {
        Connection connection = DBResourceManager.openConnection();
        ResultSet rs = DBResourceManager.executeQuery(connection, SELECT_EMP_SQL, no);
        try {
            EmpDTO emp = null;
            if (rs.next()) {
                emp = new EmpDTO();
                emp.setPhoto(rs.getString("ephoto"));
            }
            return emp;
        } catch (SQLException e) {
            throw new RuntimeException("96 查找单个员工:)", e);
        } finally {
            DBResourceManager.closeConnection(connection);
        }
    }
}
