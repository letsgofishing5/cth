package com.cth.controller;

import com.cth.dao.UserDao;
import com.cth.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String sex = request.getParameter("sex");
        String email = request.getParameter("email");
        if(sex.equals("1")){
            sex = "男";
        }else{
            sex = "女";
        }
        User user = new User(null, name, password, sex, email);
        UserDao u = new UserDao();
        int i = u.userRegister(user);
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        String str=(i==1)?"<font style='color:green;font-size:40px;'>注册成功</font>":"<font style='color:red;font-size:40px;'>注册失败</font>";
        writer.print(str);

    }

}
