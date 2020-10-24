package com.cth.myUtil;

import java.sql.*;
import java.util.ResourceBundle;

public class JDBCUtil {
    Connection con =null;
    PreparedStatement ps=null;
    ResultSet rs=null;
    ResourceBundle bundle=null;

    public Connection getConnection() {
        bundle = ResourceBundle.getBundle("jdbc");
        String jdbc = bundle.getString("jdbc");
        String url = bundle.getString("url");
        String user = bundle.getString("user");
        String pwd = bundle.getString("password");
        try {
            Class.forName(jdbc);
            con = DriverManager.getConnection(url, user, pwd);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
    public void close(Connection con,PreparedStatement ps,ResultSet rs){
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

    public void close(){
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException throwable) {
                throwable.printStackTrace();
            }
        }
        if (ps != null) {
            try {
                ps.close();
                System.out.println("ps通道关闭");
            } catch (SQLException throwable) {
                throwable.printStackTrace();
            }
        }
        if (con != null) {
            try {
                con.close();
            } catch (SQLException throwable) {
                throwable.printStackTrace();
            }
        }
    }
}
