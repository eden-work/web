<!DOCTYPE html>
<html>
<head>
    <title>Customer Support</title>
</head>
<body>
<h2>登录</h2>
您必须登录这个系统<br><br>
<%
    if ((boolean) request.getAttribute("loginFailed")) {
%>
<b>用户名或密码输入错误，请再试一次！</b><br><br>
<%
    }
%>
<form action="login" method="post">
    用户名：<br>
    <input type="text" name="userName"/><br><br>
    密码：<br>
    <input type="password" name="password"/><br><br>

    <input type="submit" value="登录">
</form>
</body>
</html>