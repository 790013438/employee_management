package snippets.jee.service.impl;

import java.sql.SQLException;

import org.apache.commons.codec.digest.DigestUtils;

import snippets.jee.dao.UserDAO;
import snippets.jee.dao.impl.UserDAOImpl;
import snippets.jee.dto.UserDTO;
import snippets.jee.service.UserService;

public class UserServiceImpl implements UserService {
    private UserDAO userDao = new UserDAOImpl();

    @Override
    public boolean login(String username, String password) {
        UserDTO temp = userDao.getUser(username);
        if (temp != null) {
            String md5 = DigestUtils.md5Hex(password);
            return temp.getPassword().equals(md5);
        }
        return false;
    }

    @Override
    public boolean register(UserDTO user) throws SQLException {
        UserDTO temp = userDao.getUser(user.getUsername());
        if (temp == null) {
            String md5 = DigestUtils.md5Hex(user.getPassword());
            user.setPassword(md5);
            return userDao.addUser(user);
        }
        return false;

    }

}
