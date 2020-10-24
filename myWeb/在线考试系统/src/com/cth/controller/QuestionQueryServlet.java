package com.cth.controller;

import com.cth.dao.ExamDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class QuestionQueryServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ExamDao examDao=new ExamDao();
        List list = examDao.queryQuestion();
        request.setAttribute("list",list);
        request.getRequestDispatcher("/questionQuery.jsp").forward(request,response);
    }
}
