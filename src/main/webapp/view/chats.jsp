<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Чаты</title>
</head>
<body>
<h1>
Messages: <br/><br/>
<form method="post" action="${pageContext.request.contextPath}">
<input type="submit" value="Back to main page" /><br/>
</form>
<h1>
<c:choose>
  <c:when test="${empty messages}">
    <p>You have no messages yet</p>
  </c:when>
  <c:otherwise>
   <c:forEach items="${messages}" var="message">
       <p>
       <fmt:parseDate value="${message.sendDateTime}" pattern="yyyy-MM-dd'T'HH:mm:ss" var="parsedDate" type="date" />
       <fmt:formatDate type="both" pattern="dd.LLL HH:mm:ss" value="${parsedDate}" />
       </p>
       <p>Message from: ${message.fromWhom}</p>
       <p> - ${message.text}</p>
   </c:forEach>
  </c:otherwise>
</c:choose>
</body>
</html>
