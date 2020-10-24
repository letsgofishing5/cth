<%@ page import="java.util.List" %>
<%@ page import="com.cth.entity.Exam" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: cthwmh
  Date: 2020/10/14
  Time: 20:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>tt</title>
</head>
<body>
    <center>
        <table border="1" style="font-size: 16px;font-weight: bold;">
            <tr style="background-color: aqua;align-content: center;">
                <td>题目编号：</td>
                <td>题目信息：</td>
                <td>A：</td>
                <td>B：</td>
                <td>C：</td>
                <td>D：</td>
                <td>正确答案：</td>
                <td colspan="2" align="center">操作</td>
            </tr>

            <c:forEach var="list" items="${list}">
               <tr>
                    <td>${list.getQuestionId()}</td>
                    <td>${list.getTitle()}</td>
                    <td>${list.getOptionA()}</td>
                    <td>${list.getOptionB()}</td>
                    <td>${list.getOptionC()}</td>
                    <td>${list.getOptionD()}</td>
                    <td align="center">${list.getAnswer()}</td>
                   <td><a href="/myWeb/questionDelete?questionId=${list.getQuestionId()}">删除试题</a> </td>
                   <td><a href="/myWeb/questionFind?questionId=${list.getQuestionId()}">详细信息</a> </td>
                </tr>
            </c:forEach>
        </table>
    </center>
</body>
</html>
