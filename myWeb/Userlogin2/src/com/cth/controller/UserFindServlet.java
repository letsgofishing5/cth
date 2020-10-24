package com.cth.controller;

import com.cth.dao.UserDao;
import com.cth.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "UserFindServlet")
public class UserFindServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> users = UserDao.queryUser();
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.print("<center>");
        writer.print("<table border='1'>");
        writer.print("<tr>");
        writer.print("<td>用户编号</td>");
        writer.print("<td>用户姓名</td>");
        writer.print("<td>用户密码</td>");
        writer.print("<td>用户性别</td>");
        writer.print("<td>用户邮箱</td>");
        writer.print("<td>操作</td>");
        writer.print("</tr>");
        for (User user : users) {
            writer.println("<tr>");
            writer.print("<td>"+user.getUserId()+"</td>");
            writer.print("<td>"+user.getName()+"</td>");
            writer.print("<td>*****</td>");
            writer.print("<td>"+user.getSex()+"</td>");
            writer.print("<td>"+user.getEmail()+"</td>");
            writer.print("<td><a href='/myWeb/userDelete?userId="+user.getUserId()+"'>删除用户</a> </td>");
            writer.println("</tr>");
        }
        writer.print("</table>");
        writer.print("</center>");
    }
}
