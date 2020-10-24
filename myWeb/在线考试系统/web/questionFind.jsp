<%--
  Created by IntelliJ IDEA.
  User: cthwmh
  Date: 2020/10/14
  Time: 21:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
    <form action="/myWeb/questionAdd" method="get">
        <table border="1" align="center">
            <tr>
                <td>题目编号：</td>
                <td>${requestScope.exam.questionId} </td>
            </tr>

            <tr>
                <td>题目信息：</td>
                <td>${requestScope.exam.title}</td>
            </tr>
            <tr>
                <td>A：</td>
                <td>${requestScope.exam.optionA} </td>
            </tr>
            <tr>
                <td>B：</td>
                <td>${requestScope.exam.optionB}</td>
            </tr>
            <tr>
                <td>C：</td>
                <td>${requestScope.exam.optionC}</td>
            </tr>
            <tr>
                <td>D：</td>
                <td>${requestScope.exam.optionD}</td>
            </tr>
            <tr>
                <td>正确答案：</td>
                <td>
                    ${requestScope.exam.answer}
                </td>
            </tr>
        </table>
    </form>
</center>

</body>
</html>
