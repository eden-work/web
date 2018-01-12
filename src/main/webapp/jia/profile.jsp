<%--@elvariable id="user" type="com.wrox.User"--%>
<!DOCTYPE html>
<html>
<head>
    <title>User Profile</title>
</head>
<body>
用户ID：${user.userId}<br/>
用户名：${user.username} (共 ${user.username.length()} 个字符)<br/>
用户全名：${fn:escapeXml(user.lastName) += ", " += fn:escapeXml(user.firstName)}<br><br>
用户全名(未使用XML转义)：${user.lastName += ", " += user.firstName}<br><br>
<b>所有权限 (${fn:length(user.permissions)})</b><br><br>
USER: ${user.permissions["user"]}<br>
Moderator: ${user.permissions["moderator"]}<br>
Administrator: ${user.permissions["admin"]}
</body>
</html>