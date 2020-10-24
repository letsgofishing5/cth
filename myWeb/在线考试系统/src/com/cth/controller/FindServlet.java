package com.cth.controller;

import com.cth.dao.ExamDao;
import com.cth.entity.Exam;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class FindServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String questionId = request.getParameter("questionId");
        ExamDao examDao = new ExamDao();
        Exam exam = examDao.queryQuestion(Integer.valueOf(questionId));
        request.setAttribute("exam", exam);
        request.getRequestDispatcher("/questionFind.jsp").forward(request,response);
    }
}
