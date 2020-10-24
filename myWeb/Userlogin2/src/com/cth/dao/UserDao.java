package com.cth.dao;

import com.cth.JDBCUtil.JDBCUtil;
import com.cth.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {

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
            System.out.println(sql);
            rs=ps.executeQuery();
            System.out.println("rs的值为："+rs);
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
     *
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
     *
     * @param user 自定义User实体类
     * @return     返回添加1或0代表是否添加成功
     */
    public static int addUser(User user){
        Connection con=null;
        con= JDBCUtil.getConnection();
        String sql=" insert into user(name,password,sex,email) values(?,?,?,?)";
        PreparedStatement ps=null;
        int updateResult=0;
        System.out.println("查询前的结果是："+updateResult);
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,user.getName());
            ps.setString(2,user.getPassword());
            ps.setString(3,user.getSex());
            ps.setString(4,user.getEmail());
            updateResult = ps.executeUpdate();
            System.out.println("查询后的结果是："+updateResult);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {

            if (con != null) {
                JDBCUtil.close(null,ps,con);

            }
        }
        return updateResult;
    }

    /**
     *
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
