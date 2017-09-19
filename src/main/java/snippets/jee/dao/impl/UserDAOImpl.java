package snippets.jee.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import snippets.jee.dao.UserDAO;
import snippets.jee.dto.UserDTO;

/**
 * material interview fulfill
 * @author 程淼
 * 
 */
public class UserDAOImpl implements UserDAO {

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public UserDTO getUser(String name) {
        UserDTO user = null;
        try (Connection connection = DriverManager.getConnection(
                    "jdbc:mysql:///hrs", "root", "123456")) {
            PreparedStatement stmt = connection.prepareStatement(
                    "select password, email from tb_user where username=?");
            stmt.setString(1, name);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                user = new UserDTO();
                user.setUsername(name);
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;

    }

    @Override
    public boolean addUser(UserDTO userDTO) {
        try (Connection connection = DriverManager.getConnection(
                    "jdbc:mysql:///hrs", "root", "123456")) {
            PreparedStatement stmt = connection.prepareStatement(
                    "insert into tb_user values (?,?,?)");
            stmt.setString(1, userDTO.getUsername());
            stmt.setString(2, userDTO.getPassword());
            stmt.setString(3, userDTO.getEmail());
            return stmt.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}
