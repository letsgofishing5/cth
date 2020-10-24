package com.cth.myUtil;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.sql.*;
import java.util.Iterator;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * @autor 走我们钓鱼去
 * @date2020/10/3-9:35
 */
public class JDBCUtil {

    /**
     * 获取MySQL数据库连接
     * @return
     */
    public  static Connection getConnection(HttpServletRequest request)
    {
        Connection con=null;
        ServletContext application=request.getServletContext();
        Map map = (Map) application.getAttribute("key");
        Iterator it = map.keySet().iterator();
        while (it.hasNext())
        {
            con =(Connection) it.next();
            if((boolean)map.get(con)){
                map.put(con, false);
                break;
            }
        }
        return con;
    }
    public static void close(Connection con,PreparedStatement ps,ResultSet rs,HttpServletRequest request){
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
        ServletContext application=request.getServletContext();
        Map map =(Map) application.getAttribute("key");
        map.put(con, true);
    }
    public  static Connection getConnection(){
        Connection con=null;
        ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
        String url =bundle.getString("url");
        String user =bundle.getString("user");
        String password = bundle.getString("password");
        String jdbc = bundle.getString("jdbc");
        try {
            Class.forName(jdbc);
            con = DriverManager.getConnection(url,user,password);
            System.out.println("数据库连接 成功");

        } catch (Exception e) {
            e.printStackTrace();
        }

        return  con;
    }

    /**
     * 关闭通道
     * @param ps
     * @param con
     * @param request
     */
    public static void close(PreparedStatement ps,Connection con,HttpServletRequest request){
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        ServletContext application = request.getServletContext();
        application.setAttribute(con.toString(),true);
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
