package com.cth.controller;

import com.cth.dao.UserDao;
import com.cth.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * @autor 走我们钓鱼去
 * @date2020/10/3-8:55
 */
public class UserRegisterServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        String name,password,sex,email;
        name = request.getParameter("name");
        password = request.getParameter("password");
        sex = request.getParameter("sex");
        email = request.getParameter("email");
        if(sex!=null) {
            sex = sex.equals("1") ? "男" : "女";
        }

        Date statDate = new Date();
        User user = new User(null, name, password, sex, email);
        int updateResult= UserDao.addUser(user);
        Date endDate = new Date();

        System.out.println("创建用户花费时间："+(endDate.getTime()-statDate.getTime())+"毫秒");
        String out=(updateResult==1)?"<font color='green' size='45px'>信息注册成功</font>":"<font color='red' size='45px'>信息注册失败</font>";
        PrintWriter writer = response.getWriter();
        writer.print(out);

    }
}
