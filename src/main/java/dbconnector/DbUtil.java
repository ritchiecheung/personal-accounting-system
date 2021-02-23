package dbconnector;

import java.sql.*;

/**
 * @author Ritchie
 */
public class DbUtil {
    private String url = "jdbc:mysql://47.101.142.197:3306/bookkeeping?useUnicode=true&characterEncoding=utf8";
    private String username = "root";
    private String password = "zc20001220";
    Statement state ;
    Connection con;
    public Connection getCon() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection(url,username,password);
        return con;
    }

}
