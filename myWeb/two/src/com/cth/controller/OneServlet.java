package com.cth.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * @autor 走我们钓鱼去
 * @date2020/10/2-11:26
 */
public class OneServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //通过 请求信息获取 Method
       String re= request.getMethod().toString();
       //通过 请求信息获取 URL
       String q=request.getRequestURL().toString();
       //通过请求信息 获取URI
       String uri=request.getRequestURI().toString();
        Enumeration<String> parameterNames = request.getParameterNames();
        while(parameterNames.hasMoreElements()){
            String name=parameterNames.nextElement();
            System.out.println("获取的元素名称："+name);
            System.out.println("name="+request.getParameter(name));
        }
        //设置字符集格式
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.print("得到的方法名是："+re+"url="+q+"<br/>uri="+uri);
        System.out.println("得到的方法名是："+re+"url="+q+"<br/>uri="+uri);
    }
    public OneServlet(){
        System.out.println("已加载");
    }
}
