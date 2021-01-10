<%--
  Created by IntelliJ IDEA.
  User: LZY
  Date: 2020/12/23
  Time: 20:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
<form enctype="multipart/form-data" method="post" action="uploadControl.jsp">
    用户名：<input type="text" name="uname"><br>
    头像：<input type="file" name="myf"><br>
    <input type="submit" value="提交">
</form>
<form action=testServlet method="post">
    <input type="submit" value="测试servlet">
</form>
</body>
</html>
