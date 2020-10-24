package com.cth.controller;

import com.cth.dao.UserDao;
import com.cth.entity.User;
import com.cth.myUtil.JDBCUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.List;

public class QueryServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        UserDao userDao =new UserDao();
        List<User> users = userDao.userQuery();
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.print("<center><table border='1' align='center'>");
        writer.print("<tr><td>用户id</td><td>用户名</td><td>密码</td><td>性别</td><td>邮箱</td><td>操作</td></tr>");
        for (User user : users) {
            writer.print("<tr>");
            writer.print("<td>"+user.getUserId()+"</td>");
            writer.print("<td>"+user.getName()+"</td>");
            writer.print("<td>****</td>");
            writer.print("<td>"+user.getSex()+"</td>");
            writer.print("<td>"+user.getEmail()+"</td>");
            writer.print("<td><a href='/myWeb/userDelete?userId="+user.getUserId()+"'>删除用户</a></td>");
            writer.print("</tr>");
        }
        writer.print("</table></center>");
    }
}
