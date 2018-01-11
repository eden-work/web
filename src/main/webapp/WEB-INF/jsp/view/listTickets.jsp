<%@page import="java.util.Map" %>
<%
    @SuppressWarnings("unchecked")
    Map<Integer, Ticket> map = (Map<Integer, Ticket>) request.getAttribute("ticketDatabase");
%>
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
<%
    if (map.size() == 0) {
%><i>系统中暂时没有票据</i><%
} else {
    for (int id : map.keySet()) {
        String idString = id + "";
        Ticket ticket = map.get(id);
%>票据 #<%= idString %> <a href="<c:url value="/wrox/tickets">
                 <c:param name="action" value="view"/>
                 <c:param name="ticketId" value="<%= idString %>"/>
</c:url>"><%= ticket.getSubject() %>
</a> (客户：<%= ticket.getCustomerName() %>)<br><%
        }
    }
%>
</body>
</html>