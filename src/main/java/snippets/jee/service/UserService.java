package snippets.jee.service;

import java.sql.SQLException;

import snippets.jee.dto.UserDTO;

/**
 * 用户业务接口
 * @author 程淼
 */
public interface UserService {

    /**
     * 登录
     * @param username 用户名
     * @param password 密码
     * @return 登录成功返回true
     * @throws SQLException 
     */
    boolean login (String username, String password) throws SQLException;
    
    /**
     * 注册
     * @param user 用户对象
     * @return 注册成功返回true
     * @throws SQLException 
     */
    boolean register (UserDTO user) throws SQLException;
}
