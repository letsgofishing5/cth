package com.cth.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @autor 走我们钓鱼去
 * @date2020/10/2-9:31
 */
@WebServlet(name = "OneServlet")
public class OneServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String result="http://<br/>www.baidu.com";
        PrintWriter writer = response.getWriter();
        //writer.print(result);
        response.sendRedirect(result);
        System.out.println("one doGet()方法执行了 ");
    }
    public OneServlet(){
        System.out.println("OneServlet构造方法执行了");
    }
}
