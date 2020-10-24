<%@ page import="java.util.List" %>
<%@ page import="com.cth.entity.Exam" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%--
  Created by IntelliJ IDEA.
  User: cthwmh
  Date: 2020/10/15
  Time: 8:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style type="text/css">
        #input{
            line-height: 35px;
            font-size: 25px;
        }
    </style>
</head>
<body>
<center>
    <form action="/myWeb/questionAutoCheck" method="get">
        <table border="1" >
            <tr style="background-color: aqua;align: center;">
                <td>题目编号：</td>
                <td>题目信息：</td>
                <td>A：</td>
                <td>B：</td>
                <td>C：</td>
                <td>D：</td>
                <td style="width: 100px;">正确答案：</td>
            </tr>
            <c:forEach items="${sessionScope.list}" var="list">
                <tr>
                    <td>${list.getQuestionId()}</td>
                    <td>${list.getTitle()}</td>
                    <td>${list.getOptionA()}</td>
                    <td>${list.getOptionB()}</td>
                    <td>${list.getOptionC()}</td>
                    <td>${list.getOptionD()}</td>
                    <td>
                        <input type="radio" name="answer_${list.getQuestionId()}" value="A"/>A
                        <input type="radio" name="answer_${list.getQuestionId()}" value="B"/>B
                        <input type="radio" name="answer_${list.getQuestionId()}" value="C"/>C
                        <input type="radio" name="answer_${list.getQuestionId()}" value="D"/>D
                    </td>
                </tr>
            </c:forEach>
        </table>
        <input type="submit" value="提交试卷" id="input"/>
        <input type="reset" id="input"/>
    </form>
</center>
</body>
</html>
