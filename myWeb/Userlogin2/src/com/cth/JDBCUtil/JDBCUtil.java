package com.cth.JDBCUtil;

import javax.annotation.Resource;
import java.sql.*;
import java.util.ResourceBundle;

/**
 * @autor 走我们钓鱼去
 * @date2020/10/3-9:35
 */
public class JDBCUtil {
    public  static Connection getConnection(){
        Connection con=null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
        String url=bundle.getString("url");
        String user = bundle.getString("user");
        String password = bundle.getString("password");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url,user,password);
            System.out.println("数据库连接 成功");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return  con;
    }

    public static void close(ResultSet rs,PreparedStatement ps,Connection con){

        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (con != null) {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
