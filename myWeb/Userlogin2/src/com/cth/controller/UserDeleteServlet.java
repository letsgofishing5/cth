package com.cth.controller;

import com.cth.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "UserDeleteServlet")
public class UserDeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userId = request.getParameter("userId");
        response.setContentType("text/html;charset=utf-8");
        int result = UserDao.deleteUser(userId);
        String out = null;
        PrintWriter writer = response.getWriter();
        out=result==1?"<font size='45px' color='green'>用户删除成功</font>":"<font size='45px' color='red'>用户删除失败</font>";
        writer.print(out);
    }
}
