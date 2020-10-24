package com.cth.controller;

import com.cth.dao.ExamDao;
import com.cth.entity.Exam;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class QuestionServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1、获取HTML页面值
        String title = request.getParameter("title");
        String optionA = request.getParameter("optionA");
        String optionB = request.getParameter("optionB");
        String optionC = request.getParameter("optionC");
        String optionD = request.getParameter("optionD");
        String answer = request.getParameter("answer");
        Exam e = new Exam(null,title,optionA,optionB,optionC,optionD,answer);
        ExamDao ed = new ExamDao();
        int i = ed.addQuestion(e);
        if(i==1){
            response.sendRedirect("/myWeb/question_Add.html");
        }else{
            response.setContentType("text/html;charset=utf-8");
            PrintWriter writer = response.getWriter();
            writer.print("<font style='color:red;font-size:40px;'>试题添加失败</font>");
        }

    }
}
