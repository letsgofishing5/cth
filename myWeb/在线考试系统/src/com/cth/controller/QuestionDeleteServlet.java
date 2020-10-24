package com.cth.controller;

import com.cth.dao.ExamDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class QuestionDeleteServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String questionId = request.getParameter("questionId");
        ExamDao examDao = new ExamDao();
        int i = examDao.deleteQuestion(Integer.valueOf(questionId));

        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        String str=(i==1)?"<font style='font-size:40px;color:green;'>删除成功</font>":"<font style='font-size:40px;color:red;'>删除失败</font>";
        writer.print(str);

    }
}
