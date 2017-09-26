package snippets.jee.db.connection;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.apache.tomcat.jdbc.pool.PoolProperties;

/**
 * Singleton Factory class to create JDBC database connection
 */
public class DatabaseConnectionFactory {
    //singleton instance
    private static DatabaseConnectionFactory databaseConnectionFactory = new DatabaseConnectionFactory();

    private DataSource dataSource = null;

    //Make the construction private
    private DatabaseConnectionFactory() {}

    /**
     * Must be called before any other method in this class,
     * Initializes the data source and saves it in an instance variable
     * 
     * @throws IOException
     * 
     */
    public synchronized void init() throws IOException {
        //Check if init was already called
        if (dataSource != null)
            return;

        //load db.properties file first
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("db.properties");
        Properties dbProperties = new Properties();
        dbProperties.load(inputStream);
        inputStream.close();

        //create Tom cat specific pool properties
        PoolProperties poolProperties = new PoolProperties();
        poolProperties.setUrl("jdbc:mysql://" + dbProperties.getProperty("db_host") + ":" + dbProperties.getProperty("db_port") + "/" + dbProperties.getProperty("db_name") + "?characterEncoding=utf8");
        poolProperties.setUsername(dbProperties.getProperty("db_user_name"));
        poolProperties.setPassword(dbProperties.getProperty("db_password"));
        poolProperties.setMaxActive(10);

        dataSource = new DataSource();
        dataSource.setPoolProperties(poolProperties);
    }

    //Private access to singleton instance
    public static DatabaseConnectionFactory getDatabaseConnectionFactory() {
        return databaseConnectionFactory;
    }

    //returns database connection object
    public Connection getConnection() throws SQLException {
        if (dataSource == null) {
            throw new SQLException("Error initializing datasource");
        }
        return dataSource.getConnection();
    }

}
