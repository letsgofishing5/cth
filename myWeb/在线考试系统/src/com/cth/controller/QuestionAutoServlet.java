package com.cth.controller;

import com.cth.dao.ExamDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class QuestionAutoServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ExamDao examDao = new ExamDao();
        List list = examDao.questionAuto();
//        request.setAttribute("list", list);
        HttpSession session = request.getSession(false);
        session.setAttribute("list",list);
        request.getRequestDispatcher("/questionAuto.jsp").forward(request,response);
    }
}
