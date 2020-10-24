package com.cth.controller;

import com.cth.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class DeleteServlet extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userId = request.getParameter("userId");
        UserDao u = new UserDao();
        int i = u.userDelete(userId);
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        String str=(i==1)?"<font style='color:green;font-size:40px;'>删除成功</font>":"<font style='color:green;font-size:40px;'>删除成功</font>";
        writer.print(str);
    }
}
