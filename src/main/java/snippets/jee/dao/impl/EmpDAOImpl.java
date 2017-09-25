package snippets.jee.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import snippets.jee.dao.EmpDAO;
import snippets.jee.dto.Emp;
import snippets.jee.util.DBResourceManager;

public class EmpDAOImpl implements EmpDAO {
    private static final String SELECT_EMP_BY_DEPT_SQL = 
        "select eno, ename, esex, ejob, estatus, etel from tb_emp where tb_dept_id=?";
    private static final String INSERT_EMP_SQL =
        "insert into tb_emp values (?,?,?,?,?,?,?,?,?,?,?)";

    @Override
    public List<Emp> findEmpsByDeptNo(Integer no) {
        Connection connection = DBResourceManager.openConnection();
        ResultSet rs = DBResourceManager.executeQuery(connection, SELECT_EMP_BY_DEPT_SQL, no);
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
        return empList.size() > 0 ? empList : Collections.emptyList();
    }

    @Override
    public boolean save(Emp emp) {
        Connection connection = DBResourceManager.openConnection();
        try {
            return DBResourceManager.executeUpdate(connection, INSERT_EMP_SQL, 
                    emp.getNo(), emp.getName(), emp.getSex(),
                    emp.getJob(), emp.getMgr().getNo(), emp.getSalary(), 
                    emp.getHireDate(), emp.getStatus(), emp.getPhoto(), 
                    emp.getTel(), emp.getDept().getNo()) == 1;
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
