package com.cth.controller;

import com.cth.entity.Exam;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class QuestionAutoCheckServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        List<Exam> question = (List<Exam>) session.getAttribute("list");
        int score=0;
        for (Exam exam : question) {
            String answer = exam.getAnswer();
            Integer questionId = exam.getQuestionId();
            String userAnswer = request.getParameter("answer_" + questionId);
            if(answer.equals(userAnswer)){
                score++;
            }
        }
        session.setAttribute("score",score);
        session.setAttribute("totalScore",question.size());
        request.getRequestDispatcher("/scoreShow.jsp").forward(request,response);
    }
}
