<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sending messages</title>
</head>
<body>
<c:choose>
  <c:when test="${empty messageLock}">
    <form method="post" action="${pageContext.request.contextPath}/api/message?messageLock=used">

    Login: <input type="text" name="To" value="" /><br/>

    Text: <input type="text" name="Text" value="" /><br/>

    <input type="submit" value="Send" /><br/>
    </form>
  </c:when>
  <c:otherwise>
    ${messageLock}<br/>
    <%
    session.removeAttribute("messageLock");
    %>
  </c:otherwise>
</c:choose>
    <form method="post" action="${pageContext.request.contextPath}">
    <input type="submit" value="Back to main page" /><br/>
    </form>
</body>
</html>
