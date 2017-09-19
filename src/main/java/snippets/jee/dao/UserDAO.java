package snippets.jee.dao;

import java.sql.SQLException;

import snippets.jee.dto.UserDTO;

/**
 * material interview aim
 * @author 程淼
 * 
 */
public interface UserDAO {

    /**
     * 根据用户名查找用户
     * @param username 用户名
     * @return 用户对象
     * @throws SQLException 
     */
    public UserDTO getUser (String name);

    /**
     * 保存用户
     * @param user 用户对象
     * @return 
     */
    public boolean addUser (final UserDTO course);
}
