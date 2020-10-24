package com.cth.controller;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class TwoServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //都是变量声明
        int jiaozi_money=30;
        int noodles_money=20;
        int rich_money=10;
        int balance=0;
        int money=0;
        String userName=null;
        Cookie card=null;

        //接受信息
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        String food = request.getParameter("food");
        if(food!=null) {
            Cookie[] cookies = request.getCookies();
            for (Cookie cookie : cookies) {
                String key = cookie.getName();
                String value = cookie.getValue();
                if ("userName".equals(key)) {
                    userName = value;
                } else if ("money".equals(key)) {
                    money = Integer.valueOf(value);
                    if ("jiaozi".equals(food)) {
                        if (money < jiaozi_money) {
                            writer.print("用户余额不足，请充值");
                        } else {
                            balance = money - jiaozi_money;
                            card = new Cookie("money", balance + "");
                        }

                    } else if ("noodles".equals(food)) {
                        if (money < noodles_money) {
                            writer.print("用户余额不足，请充值");
                        } else {
                            balance = money - noodles_money;
                            card = new Cookie("money", balance + "");
                        }
                    } else if ("rich".equals(food)) {
                        if (money < rich_money) {
                            writer.print("用户余额不足，请充值");
                        } else {
                            balance = money - rich_money;
                            card = new Cookie("money", balance + "");
                        }
                    }
                }
            }
            response.addCookie(card);
            writer.print("用户：" + userName + " 余额：" + balance);
        }else{
            writer.print("未选餐");
        }
    }
}
