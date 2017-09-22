package snippets.jee.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public final class DBResourceManager {
    private static final String DRV = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql:///hrs?characterEncoding=utf8";
    private static final String UID = "user1";
    private static final String PWD = "37934bit";

    static {
        try {
            Class.forName(DRV);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private DBResourceManager() {
        throw new AssertionError();
    }

    /**
     * 打开数据库连接
     * @return 数据库连接对象
     */
    public static Connection openConnection() {
        try {
            return DriverManager.getConnection(URL, UID, PWD);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DbException(DbException.CONN_EX, e);
        }
    }

    static class DbException extends RuntimeException {

        private static final long serialVersionUID = 1L;
        public static final String RS_EX = "解析结果集时发生异常";
        public static final String EXEC_EX = "执行SQL语句时发生异常";
        public static final String CONN_EX = "无法建立数据库连接";
        public static final String DIS_EX = "无法关闭数据库连接";
        
        public DbException(String message, Throwable cause) {
            super(message, cause);
        }
    }

    /**
     * 关闭数据库连接
     * @param con
     */
    public static void closeConnection(Connection con) {
        try {
            if (con != null && !con.isClosed()) {
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DbException(DbException.DIS_EX, e);
        }
    }

    /**
     * 执行增删改操作
     * @param con 连接对象
     * @param sql SQL语句
     * @param params 替换SQL语句中占位符的参数
     * @return 受影响的行数
     */
    public static int executeUpdate(Connection con, String sql, Object... params) {
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            for (int i = 0; i < params.length; ++i) {
                stmt.setObject(i + 1, params[i]);
            }
            //2
            System.out.println(stmt);
            ///233
            return stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DbException(DbException.EXEC_EX, e);
        }
    }

    /**
     * 执行查询操作
     * @param con 数据库连接对象
     * @param sql SQL语句
     * @param params 替换SQL语句中占位符的参数
     * @return 结果集对象 (游标)
     */
    public static ResultSet executeQuery(Connection con, String sql, Object... params) {
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            for (int i = 0; i < params.length; ++i) {
                stmt.setObject(i + 1, params[i]);
            }
            return stmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DbException(DbException.EXEC_EX, e);
        }
    }
}
