package my.delivery.app.util;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;

public final class ConnectionPool {
    public static Logger consLogger = Logger.getLogger("CONS");
    private final static String DRIVER = PropertyUtil.getDbProperty("driver");
    private final static String URL = PropertyUtil.getDbProperty("url");
    private final static String USERNAME = PropertyUtil.getDbProperty("user");
    private final static String PASSWORD = PropertyUtil.getDbProperty("password");

    private static BasicDataSource dataSource;

    static {
        dataSource = new BasicDataSource();
        dataSource.setDriverClassName(DRIVER);
        dataSource.setUrl(URL);
        dataSource.setUsername(USERNAME);
        dataSource.setPassword(PASSWORD);
    }

    public static Connection getConnection(boolean autocommit) {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            connection.setAutoCommit(autocommit);
            return connection;
        } catch (SQLException e) {

            e.printStackTrace();
            consLogger.error("Can't connection to DB");
        }
        return connection;
    }

    public static void commitTransaction(Connection connection) {
        try {
            connection.commit();
            connection.setAutoCommit(true);
        } catch (SQLException e) {
            e.printStackTrace();
            consLogger.error("Can't finish transaction");
        }
    }

    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.setAutoCommit(true);
                connection.close();
            } catch (SQLException e) {
                consLogger.error("Can't close connection to DB");
            }
        }
    }

    public static void transactionRollback(Connection connection) {
        if (connection != null) {
            try {
                connection.rollback();
            } catch (SQLException e) {
                consLogger.error("Roll back from DB");
            }
        }
    }

}
