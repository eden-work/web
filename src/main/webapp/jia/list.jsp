<%--@elvariable id="contacts" type="com.jia.Contact"--%>
<html>
<head>
    <title>Address Book</title>
</head>
<body>
<h2>联系人地址信息</h2>
<c:choose>
    <c:when test="${fn:length(contacts) == 0}">
        暂无联系人信息
    </c:when>
    <c:otherwise>
        <c:forEach items="${contacts}" var="contact">
            <b>
                <c:out value="${contact.lastName}, ${contact.firstName}"/>
            </b><br/>
            <c:out value="${contact.address}" /><br />
            <c:out value="${contact.phoneNumber}" /><br />
            <c:if test="${contact.birthday != null}">
                Birthday: ${contact.birthday}<br />
            </c:if>
            Created: ${contact.dateCreated}<br /><br />
        </c:forEach>
    </c:otherwise>
</c:choose>
</body>
</html>