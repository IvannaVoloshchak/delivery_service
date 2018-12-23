package my.delivery.app.util;

import org.apache.log4j.Logger;

import javax.sql.DataSource;

public class ConnectionPool {
//    private final static Logger logger = Logger.getLogger(ConnectionPool.class);
//    private static ConnectionPool instance = null;
//    private static final String TOMCAT_JNDI_NAME="java:comp/env";
//    private DataSource pool;
//    private final String DATASOURCE;
//
//    public ConnectionPool() {
//        DATASOURCE = Config.getInstance().getProperty(Config.DATASOURCE);
//        initialPool();
//    }
//
//    public static synchronized ConnectionPool getInstance() {
//        if (instance == null) {
//            instance = new ConnectionPool();
//        }
//        return instance;
//    }
//
//    private void initialPool(){
//        try{
//            Context initContext = new InitialContext();
//            Context envContext = (Context) initContext.lookup(TOMCAT_JNDI_NAME);
//            pool = (DataSource)envContext.lookup(DATASOURCE);
//        }catch(NamingException e){
//            e.printStackTrace();
//        }
//    }
//
//    public synchronized Connection getConnection() throws SQLException{
//        return pool.getConnection();
//    }
//
//    public void closeConnection(Connection connection){
//        try{
//            if(connection != null){
//                connection.close();
//            }
//        }catch(SQLException e){
//            e.printStackTrace();
//        }
//    }
}
