package dao;
import dbconnector.DbUtil;
import enity.User;

import java.sql.*;


/**
 * @author Ritchie
 */
public class UserDao {
   DbUtil db = new DbUtil();

    public UserDao() throws Exception {
    }

    /**
     * 注册
     * @param user
     */
    public void register(Connection connection ,User user) throws SQLException, ClassNotFoundException {
        String sql = "insert into userinfo (account,password,username) values('"+user.getAccount()+"','"+user.getPassword()+"','"+user.getUsername()+"')";
        connection = db.getCon();
        try {
            Statement state =connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            state.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    /**
     * 登录操作
     * @param con
     * @param user
     * @return
     * @throws Exception
     */
    public User login(Connection con,User user) throws Exception {
        User result = null;
        String sql = "select * from userinfo where account=? and password=? and username=?";
        con = db.getCon();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1,user.getAccount());
        ps.setString(2,user.getPassword());
        ps.setString(3,user.getUsername());
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            result = new User();
            int id = rs.getInt("id");
            result.setAccount(rs.getString("account"));
            result.setPassword(rs.getString("password"));
            result.setUsername(rs.getString("username"));

            user.setId(id);
        }
        return result;
    }



}
