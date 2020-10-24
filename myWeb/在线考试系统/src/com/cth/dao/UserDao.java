package com.cth.dao;

import com.cth.entity.User;
import com.cth.myUtil.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    JDBCUtil jdbc = new JDBCUtil();
    Connection con=jdbc.getConnection();
    PreparedStatement ps=null;
    ResultSet rs=null;

    public int userRegister(User user){
        String sql="insert into user(name,password,sex,email) value(?,?,?,?)";
        int i=0;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,user.getName());
            ps.setString(2,user.getPassword());
            ps.setString(3,user.getSex());
            ps.setString(4,user.getEmail());
            i = ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            jdbc.close(con,ps,rs);

        }
        return i;

    }
    public int userDelete(String userId){
        String sql ="delete from user where userId=?";
        int i=0;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,userId);
            i = ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            jdbc.close(con,ps,rs);

        }
        return i;

    }
    public List<User> userQuery(){
        ResultSet rs=null;
        List<User> list = new ArrayList<>();
        String sql ="select * from user ";
        try {
            ps = con.prepareStatement(sql);
            rs= ps.executeQuery();
            while(rs.next()){
                String userId=rs.getString("userId");
                String name=rs.getString("name");
                String sex=rs.getString("sex");
                String email=rs.getString("email");
                User u = new User(userId, name, null, sex, email);
                list.add(u);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            jdbc.close(con,ps,rs);
        //    jdbc.close();
        }
        return list;
    }
    public int userLogin(String name,String pwd){
        ResultSet rs=null;
        int i=0;
        String sql="select count(*) from user where name=? and password=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,name);
            ps.setString(2,pwd);
            rs = ps.executeQuery();
            while (rs.next())
            {
                i=rs.getInt("count(*)");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            jdbc.close(con,ps,rs);

        }
        return i;
    }
}
