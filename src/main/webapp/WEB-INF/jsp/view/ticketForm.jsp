<!DOCTYPE html>
<html>
<head>
    <title>Customer Support</title>
</head>
<body>
<a href="<c:url value="/wrox/login?logout" />">退出</a>
<h2>创建一张票据</h2>
<form method="post" action="tickets" enctype="multipart/form-data">
    <input type="hidden" name="action" value="create"/>
    Subject<br/>
    <input type="text" name="subject"><br/><br/>
    Body<br/>
    <textarea name="body" rows="5" cols="30"></textarea><br/><br/>
    <b>Attachments</b><br/>
    <input type="file" name="file1"/><br/><br/>
    <input type="submit" value="Submit"/>
</form>
</body>
</html>