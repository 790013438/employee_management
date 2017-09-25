package snippets.jee.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import snippets.jee.dao.EmpDAO;
import snippets.jee.dto.Emp;
import snippets.jee.util.DBResourceManager;
import snippets.jee.util.PageBean;

public class EmpDAOImpl implements EmpDAO {
    private static final String SELECT_EMP_BY_DEPT_SQL = 
        "select eno, ename, esex, ejob, estatus, etel from tb_emp where tb_dept_id=? limit ?,?";
    private static final String SELECT_EMP_COUNT_SQL = "select count(eno) from tb_emp where tb_dept_id=?";
    private static final String INSERT_EMP_SQL =
        "insert into tb_emp(eno, ename, esex, ejob, tb_emp_id, esal, ehiredate, estatus, ephoto, etel, tb_dept_id) values (?,?,?,?,?,?,?,?,?,?,?)";

    @Override
    public PageBean<Emp> findEmpsByDeptNo(Integer no, int page, int size) {
        Connection connection = DBResourceManager.openConnection();
        ResultSet rs = DBResourceManager.executeQuery(connection, SELECT_EMP_BY_DEPT_SQL, no, (page - 1) * size, size);
        ResultSet rs2 = DBResourceManager.executeQuery(connection, SELECT_EMP_COUNT_SQL, no);
        List<Emp> empList = new ArrayList<>();
        try {
            while (rs.next()) {
                Emp emp = new Emp();
                emp.setNo(rs.getInt("eno"));
                emp.setName(rs.getString("ename"));
                emp.setSex(rs.getBoolean("esex"));
                emp.setJob(rs.getString("ejob"));
                emp.setStatus(rs.getBoolean("estatus"));
                emp.setTel(rs.getString("etel"));
                empList.add(emp);
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
        }
        int totalPage = (total - 1) / size + 1;
        return new PageBean<>(empList, totalPage, page, size);
    }

    @Override
    public boolean save(Emp emp) {
        Connection connection = DBResourceManager.openConnection();
        try {
            return DBResourceManager.executeUpdate(connection, INSERT_EMP_SQL, 
                    emp.getNo(), emp.getName(), emp.getSex(),
                    emp.getJob(), emp.getMgr().getId(), emp.getSalary(), 
                    emp.getHireDate(), emp.getStatus(), emp.getPhoto(), 
                    emp.getTel(), emp.getDept().getId()) == 1;
        } finally {
            DBResourceManager.closeConnection(connection);
        }
    }

    @Override
    public boolean deleteByNo(Integer no) {
        return false;
    }

    @Override
    public boolean update(Emp emp) {
        return false;
    }

    @Override
    public Emp findByNo(Integer no) {
        return null;
    }
}
