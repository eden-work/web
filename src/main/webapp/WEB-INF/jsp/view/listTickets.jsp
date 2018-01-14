<%--@elvariable id="ticketDatabase" type="java.util.Map<Integer,com.wrox.model.Ticket>"--%>
<!DOCTYPE>
<html>
<head>
    <title>Customer Support</title>
</head>
<body>
<a href="<c:url value="/wrox/login?logout" />">退出</a>
<h2>票据列表</h2>
<a href="<c:url value="/wrox/tickets">
        <c:param name="action" value="create"/>
        </c:url>">创建票据</a><br><br>
<c:choose>
    <c:when test="${fn:length(ticketDatabase) == 0}">
        <i>系统中暂时没有票据</i>
    </c:when>
    <c:otherwise>
        <c:forEach items="${ticketDatabase}" var="entry">
            票据 ${entry.key}&nbsp;
            <a href="<c:url value="/wrox/tickets">
                <c:param name="action" value="view"/>
                <c:param name="ticketId" value="${entry.key}"/>
            </c:url>">
                    ${fn:escapeXml(entry.value.subject)}
            </a>
            (客户： ${entry.value.customerName})<br/>
        </c:forEach>
    </c:otherwise>
</c:choose>
</body>
</html>