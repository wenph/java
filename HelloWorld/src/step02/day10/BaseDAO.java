package step02.day10;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by pinghua.wph on 2016/4/15.
 */
public class BaseDAO {
    private static Properties properties = new Properties();
    private static ThreadLocal<Connection> threadLocal = new ThreadLocal();
    /**
     * 在静态初始化中注册驱动
     * 驱动不需要重复注册，所以静态初始化最适合注册驱动
     */
    static {
        try {
            // 加载配置文件
            properties.load(BaseDAO.class.getClassLoader().getResourceAsStream("step02/day10/db.properties"));
            //加载驱动
            Class.forName(properties.getProperty("jdbc.driver"));      // 反射机制
            /**
             * com.mysql.jdbc.Driver
             * 在Class.forName()的时候被载入JVM
             */
//            Connection conn = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
            // 注册失败，通知调用者
            throw new RuntimeException(e);
        }
    }

    /**
     * 获取连接
     */
    protected static Connection getConnection() throws SQLException {
        // 如果同一个线程多个模块间要共享这个conn，则可以使用ThreadLocal类。
        Connection connection = threadLocal.get();
        if (connection == null) {
            connection = DriverManager.getConnection(
                    properties.getProperty("jdbc.url"),
                    properties.getProperty("jdbc.username"),
                    properties.getProperty("jdbc.password")
            );
            threadLocal.set(connection);
        }
        return connection;
    }

    /**
     * 关闭连接
     */
    protected static void closeConnection() {
        Connection conn = threadLocal.get();
        if (conn != null) {
            try {
                conn.close();
                threadLocal.remove();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
