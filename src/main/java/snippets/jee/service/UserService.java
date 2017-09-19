package snippets.jee.service;

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
     */
    boolean login (String username, String password);
    
    /**
     * 注册
     * @param user 用户对象
     * @return 注册成功返回true
     */
    boolean register (UserDTO user);
}
