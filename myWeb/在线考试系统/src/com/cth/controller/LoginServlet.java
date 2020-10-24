package com.cth.controller;

import com.cth.dao.UserDao;
import com.cth.myUtil.JDBCUtil;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String name = request.getParameter("userName");
        String pwd = request.getParameter("password");
        UserDao userDao=new UserDao();
        int i=userDao.userLogin(name, pwd);
        if(i==0) {
            response.sendRedirect("/myWeb/index_errorLogin.html");
            return ;
        }else{
            HttpSession session = request.getSession();
            System.out.println("loginServlet中的session="+session);
            response.sendRedirect("/myWeb/main.html");
        }

    }


}
