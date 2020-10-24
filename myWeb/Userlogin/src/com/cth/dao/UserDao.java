package com.cth.dao;

import com.cth.myUtil.JDBCUtil;
import com.cth.entity.User;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {

    /**
     * 用户登录验证
     * @param userId 用户ID
     * @param password 用户密码
     * @return 返回1或0,1代表登录成功，0代表失败
     */
    public static int loginUser(String userId,String password){
        String sql = "select count(*) from user where name=? and password=?";
        Connection con=JDBCUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet rs=null;
        int result=0;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,userId);
            ps.setString(2,password);
            rs=ps.executeQuery();
            while (rs.next())
            {
                result = rs.getInt("count(*)");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtil.close(rs,ps,con);
        }
        return result;
    }

    /**
     *删除用户
     * @param userId 用户编号
     * @return 返回查询的结果1或0,1代表成功，0代表失败
     */
    public static int deleteUser(String userId){
        String sql = "delete from user where userId=?";

        Connection con = JDBCUtil.getConnection();
        PreparedStatement ps=null;
        int result =0;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, userId);
            result=ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtil.close(null,ps,con);
        }
        return result;



    }


    /**
     *添加用户
     * @param user 自定义User实体类
     * @return     返回添加1或0代表是否添加成功
     */
    public static int addUser(User user, HttpServletRequest request){
        Connection con=null;
        con= JDBCUtil.getConnection(request);
        String sql=" insert into user(name,password,sex,email) values(?,?,?,?)";
        PreparedStatement ps=null;
        int updateResult=0;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,user.getName());
            ps.setString(2,user.getPassword());
            ps.setString(3,user.getSex());
            ps.setString(4,user.getEmail());
            updateResult = ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtil.close(con,ps,null,request);
        }
        return updateResult;
    }
    public static int addUser(User user){
        Connection con=null;
        con= JDBCUtil.getConnection();
        String sql=" insert into user(name,password,sex,email) values(?,?,?,?)";
        PreparedStatement ps=null;
        int updateResult=0;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,user.getName());
            ps.setString(2,user.getPassword());
            ps.setString(3,user.getSex());
            ps.setString(4,user.getEmail());
            updateResult = ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
          JDBCUtil.close(null,ps,con);
        }
        return updateResult;
    }

    /**
     *查询用户
     * @return 查询的用户结果
     */
    public static List<User> queryUser(){
        String sql="select *  from  user";
        Connection con= JDBCUtil.getConnection();
        PreparedStatement ps=null;
        ResultSet resultSet = null;
        List<User> list=new ArrayList<>();
        try {
            ps = con.prepareStatement(sql);
            resultSet=ps.executeQuery();
            while (resultSet.next())
            {
                String userId = resultSet.getString("userId");
                String name = resultSet.getString("name");
                String password = resultSet.getString("password");
                String email = resultSet.getString("email");
                String sex = resultSet.getString("sex");
                User user=new User(userId,name,password,sex,email);
                list.add(user);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtil.close(resultSet,ps,con);
        }

        return list;
    }
}
