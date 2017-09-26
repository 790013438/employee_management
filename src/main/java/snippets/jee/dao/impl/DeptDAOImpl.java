package snippets.jee.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import snippets.jee.dao.DeptDAO;
import snippets.jee.dto.Dept;
import snippets.jee.util.DBResourceManager;

public class DeptDAOImpl implements DeptDAO {

    private static final String SELECT_DEPT_SQL = "select dname, dloc from tb_dept where id=?";
    private static final String SELECT_ALL_DEPT_SQL = "select id, dno, dname, dloc from tb_dept";
    private static final String INSERT_DEPT_SQL = "insert into tb_dept(dno, dname, dloc) values (?,?,?)";
    private static final String DELETE_DEPT_SQL = "delete from tb_dept where dno=?";
    private static final String UPDATE_DEPT_SQL = "update tb_dept set dname=?, dloc=? where dno=?";
    private static final String COUNT_EMP_SQL = "select count(eno) from tb_emp where eno=?";

    @Override
    public boolean save(Dept dept) {
        Connection connection = DBResourceManager.openConnection();
        try {
            return DBResourceManager.executeUpdate(connection, INSERT_DEPT_SQL, 
                    dept.getNo(), dept.getName(), dept.getLocation()) == 1;
        } finally {
            DBResourceManager.closeConnection(connection);
        }
    }

    @Override
    public boolean deleteByNo(Integer no) {
        Connection connection = DBResourceManager.openConnection();
        try {
            return DBResourceManager.executeUpdate(connection, DELETE_DEPT_SQL, no) == 1;
        } finally {
            DBResourceManager.closeConnection(connection);
        }
    }

    @Override
    public boolean update(Dept dept) {
        Connection connection = DBResourceManager.openConnection();
        try {
            return DBResourceManager.executeUpdate(connection, UPDATE_DEPT_SQL, 
                    dept.getName(), dept.getLocation(), dept.getNo()) == 1;
        } finally {
            DBResourceManager.closeConnection(connection);
        }
    }

    @Override
    public List<Dept> findAll() {
        List<Dept> deptList = new ArrayList<>();
        Connection connection = DBResourceManager.openConnection();
        ResultSet rs = DBResourceManager.executeQuery(connection, SELECT_ALL_DEPT_SQL);
        try {
            while (rs.next()) {
                Dept dept = new Dept();
                dept.setId(rs.getInt("id"));
                dept.setNo(rs.getInt("dno"));
                dept.setName(rs.getString("dname"));
                dept.setLocation(rs.getString("dloc"));
                deptList.add(dept);
            }
            return deptList.size() > 0 ? deptList : Collections.emptyList();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("70:)", e);
        } finally {
            DBResourceManager.closeConnection(connection);
        }
    }

    @Override
    public int countEmpByNo(Integer no) {
        Connection connection = DBResourceManager.openConnection();
        ResultSet rs = DBResourceManager.executeQuery(connection, COUNT_EMP_SQL, no);
        try {
            return rs.next() ? rs.getInt(1) : 0;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("84:)", e);
        } finally {
            DBResourceManager.closeConnection(connection);
        }
    }

    @Override
    public Dept findById(Integer no) {
        Connection connection = DBResourceManager.openConnection();
        ResultSet rs = DBResourceManager.executeQuery(connection, SELECT_DEPT_SQL, no);
        try {
            Dept dept = null;
            if (rs.next()) {
                dept = new Dept();
                dept.setNo(no);
                dept.setName(rs.getString("dname"));
                dept.setLocation(rs.getString("dloc"));
            }
            return dept;
        } catch (SQLException e) {
            throw new RuntimeException("106:)", e);
        } finally {
            DBResourceManager.closeConnection(connection);
        }
    }
}
