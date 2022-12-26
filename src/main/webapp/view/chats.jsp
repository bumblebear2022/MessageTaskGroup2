<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Чаты</title>
</head>
<body>
<h1>Полученные сообщения:<h1><br/>
<c:choose>
  <c:when test="${empty messages}">
    <p>You have no messages yet)</p>
  </c:when>
  <c:otherwise>
   <c:forEach items="${messages}" var="message">
       <p>
       <fmt:parseDate value="${message.sendDateTime}" pattern="dd.LLL HH:mm:ss" var="parsedDate" type="date" />
       <fmt:formatDate value="${parsedDate}" var="newParsedDate" type="date" pattern="dd.LLL HH:mm:ss" />
       ${newParsedDate}
       </p>
       <p>Message from: ${message.fromWhom}</p>
       <p> - ${message.text}</p>
   </c:forEach>
  </c:otherwise>
</c:choose>
</body>
</html>
