package com.cth.controller;

import com.cth.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class UserLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        String userName = request.getParameter("userName");
        String userPwd = request.getParameter("userPwd");
        System.out.println("用户名："+userName+"密码："+userPwd);
        int i = UserDao.loginUser(userName, userPwd);
        System.out.println("i的值为："+i);
        if(i==1){
            System.out.println("走得是考试页面");
            response.sendRedirect("/myWeb/index.html");
        }else{
            System.out.println("走的是重新登录页面");
            response.sendRedirect("/myWeb/errorLogin.html");
        }
    }


}
