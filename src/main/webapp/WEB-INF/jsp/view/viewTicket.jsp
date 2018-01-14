<%--@elvariable id="ticketId" type="java.lang.String"--%>
<%--@elvariable id="ticket" type="com.wrox.model.Ticket"--%>
<!DOCTYPE html>
<html>
<head>
    <title>Customer Support</title>
</head>
<body>
<a href="<c:url value="/wrox/login?logout" />">退出</a>
<h2>票据${ticketId}: <c:out value="${ticket.subject}"/>
</h2>
<i>客户名称 - ${fn:escapeXml(ticket.customerName)}
</i><br><br>
<c:out value="${ticket.body}"/><br><br>
<%-- numberOfAttachments属性并不存在，因为在底层的实质是调用getter方法 --%>
<c:if test="${ticket.numberOfAttachments > 0}">
    附件列表：
    <c:forEach items="${ticket.attachments}" var="attachment" varStatus="status">
        <c:if test="${!status.first}">, </c:if>
        <a href="<c:url value="/wrox/tickets">
            <c:param name="action" value="download"/>
            <c:param name="ticketId" value="${ticketId}"/>
            <c:param name="attachment" value="${attachment.name}"/>
        </c:url>"><c:out value="${attachment.name}"/></a>
    </c:forEach><br/><br/>
</c:if>
<a href="<c:url value="/wrox/tickets" />">Return to list tickets</a>
</body>
</html>
