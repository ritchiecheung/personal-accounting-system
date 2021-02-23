import dao.UserDao;
import dbconnector.DbUtil;
import enity.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * @author : Ritchie Zhang
 * @date : 2020/6/23 0023
 * @description： TODO
 * @modifiedBy：
 * @version: 1.0
 */
public class app  extends JFrame {
    UserDao userDao= new UserDao();
    User users = new User();
    DbUtil db = new DbUtil();
    private JTextField account;
    private JTextField pwd;
    private JTextField user;
    private JLabel l1,l2,l3;
    private JButton b1,b2;
    public app() throws Exception {
        super("注册新用户");
        pwd = new JTextField(18);
        account = new JTextField(18);
        user = new JTextField(18);
        l1 = new JLabel("账号");
        l2 = new JLabel("密码");
        l3 = new JLabel("用戶名");
        b1=new JButton("注册");
        b2= new JButton("登录");
        this.setLayout(new FlowLayout());
        this.add(l1);
        this.add(account);
        this.add(l2);
        this.add(pwd);
        this.add(l3);
        this.add(user);
        this.add(b1);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                users.setAccount(account.getText());
                users.setPassword(pwd.getText());
                users.setUsername(user.getText());
                try {
                    Connection connection = db.getCon();
                    userDao.register(connection,users);
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

            }
        });
        this.add(b2);
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                users = new User(account.getText(),pwd.getText(),user.getText());
                Connection connection = null;
                try {
                    connection = db.getCon();
                    User currentUser = userDao.login(connection,users);
                    if(currentUser!=null){
                        JOptionPane.showMessageDialog(null,"登录成功");
                    }else{
                        JOptionPane.showMessageDialog(null,"用户名或者密码或者账号错误");
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        this.setSize(280,180);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }

    public static void main(String[] args) throws Exception {
        new app();
    }
}
