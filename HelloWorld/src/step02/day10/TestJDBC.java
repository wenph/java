package step02.day10;

import java.sql.*;

/**
 * Created by pinghua.wph on 2016/4/14.
 */

/**
 * V <==> Service <==> DAO <==> DB
 * Service层：提供接口
 * DAO层：提供对象到数据库的转换
 */
public class TestJDBC extends BaseDAO{
    public static void main(String[] args) {
        try{
            Connection conn = getConnection();
            Connection conn2 = getConnection();
            System.out.println(conn.equals(conn2));         // false，不是单例模式
            /**
             * 如果同一个线程多个模块间要共享这个conn，则可以使用ThreadLocal类。
             */
//            Statement statement = conn.createStatement();
//            String sql = "select * from aliguard_hosts";
            /**
             * 预编译SQL语句
             * 将sql中的变化的内容用“？”代替
             */
            String sql = "SELECT * from aliguard_hosts WHERE ip=?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, "10.97.188.32");
//            System.out.println(statement);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                String name = rs.getString("ip") ;
                System.out.println(name);
            }
            rs.close() ;
            statement.close();
            closeConnection(conn);
        }catch(SQLException se){
            System.out.println("数据库连接失败！");
            se.printStackTrace() ;
        }
    }
}
