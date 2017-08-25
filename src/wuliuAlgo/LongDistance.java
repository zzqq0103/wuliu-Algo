package wuliuAlgo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by kerry on 2017-08-25.
 */

public class LongDistance {

    public static void main(String[] args) throws Exception {
        //要连接的数据库URL
        String url = "jdbc:mysql://localhost:3306/logistics";
        //连接的数据库时使用的用户名
        String username = "root";
        //连接的数据库时使用的密码
        String password = "ironzhang110";

        //1.加载驱动
        //DriverManager.registerDriver(new com.mysql.jdbc.Driver());不推荐使用这种方式来加载驱动
        Class.forName("com.mysql.jdbc.Driver");//推荐使用这种方式来加载驱动
        //2.获取与数据库的链接
        Connection conn = DriverManager.getConnection(url, username, password);

        //3.获取用于向数据库发送sql语句的statement
        Statement st = conn.createStatement();

        String sql = "select * from  depot";
        //4.向数据库发sql,并获取代表结果集的resultset
        ResultSet rs = st.executeQuery(sql);

        //5.取出结果集的数据
        while(rs.next()){
            System.out.println("id=" + rs.getObject("id"));
            System.out.println("depotSite=" + rs.getObject("depotSite"));
            System.out.println("orderId=" + rs.getObject("orderId"));
            System.out.println("inDepotTim=" + rs.getObject("inDepotTim"));
            System.out.println("outDepotTim=" + rs.getObject("outDepotTim"));
        }

        //6.关闭链接，释放资源
        rs.close();
        st.close();
        conn.close();
    }
}