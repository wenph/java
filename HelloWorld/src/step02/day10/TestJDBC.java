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
public class TestJDBC {
    public static void main(String[] args) {
        // 连接数据库
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }
        String url = "jdbc:mysql://localhost:3306/aliguard_console" ;
        String username = "root" ;
        String password = "" ;
        try{
            Connection conn = DriverManager.getConnection(url, username, password);
            Statement statement = conn.createStatement();
            String sql = "select * from aliguard_hosts";
            ResultSet rs = statement.executeQuery(sql) ;
            while(rs.next()){
                String name = rs.getString("ip") ;
                System.out.println(name);
            }
            rs.close() ;
            statement.close();
            conn.close();
        }catch(SQLException se){
            System.out.println("数据库连接失败！");
            se.printStackTrace() ;
        }
    }
}
