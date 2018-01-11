<%
    String ticketId = (String) request.getAttribute("ticketId");
    Ticket ticket = (Ticket) request.getAttribute("ticket");
%>
<!DOCTYPE html>
<html>
<head>
    <title>Customer Support</title>
</head>
<body>
<a href="<c:url value="/wrox/login?logout" />">退出</a>
<h2>票据<%= ticketId %>:<%= ticket.getSubject() %>
</h2>
<i>客户名称 - <%= ticket.getCustomerName() %>
</i><br><br>
<%= ticket.getBody() %><br><br>
<%
    if (ticket.getNumberOfAttachments() > 0) {
%>附件列表：<%
    int i = 0;
    for (Attachment a : ticket.getAttachments()) {
        if (i++ > 0) {
            out.print(", ");
        }
%><a href="<c:url value="/wrox/tickets">
                        <c:param name="action" value="download"/>
    <c:param name="ticketId" value="<%= ticketId %>"/>
    <c:param name="attachment" value="<%= a.getName() %>"/>
                    </c:url>"><%= a.getName() %>
</a><%
        }
    }
%>
<a href="<c:url value="/wrox/tickets"/>">返回票据列表</a>
</body>
</html>