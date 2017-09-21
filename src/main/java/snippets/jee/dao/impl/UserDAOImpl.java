package snippets.jee.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import snippets.jee.dao.UserDAO;
import snippets.jee.dto.UserDTO;
import snippets.jee.util.DBResourceManager;

/**
 * material interview fulfill
 * @author 程淼
 * 
 */
public class UserDAOImpl implements UserDAO {

    private static final String SELECT_USER_SQL = "select password, email from tb_user where username=?";
    private static final String INSERT_USER_SQL = "insert into tb_user values (?,?,?)";

    @Override
    public UserDTO getUser(String name) {
        Connection connection = DBResourceManager.openConnection();
        ResultSet rs = DBResourceManager.executeQuery(connection, SELECT_USER_SQL, name);
        try {
            UserDTO user = null;
            if (rs.next()) {
                user = new UserDTO();
                user.setUsername(name);
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
            }
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("解析结果集时出现异常38:)", e);
        } finally {
            DBResourceManager.closeConnection(connection);
        }
    }

    @Override
    public boolean addUser(UserDTO userDTO) {
        Connection connection = DBResourceManager.openConnection();
        try {
            return DBResourceManager.executeUpdate(connection, INSERT_USER_SQL, 
                    userDTO.getUsername(), userDTO.getPassword(), userDTO.getEmail()) == 1;
        } finally {
            DBResourceManager.closeConnection(connection);
        }
    }

}
