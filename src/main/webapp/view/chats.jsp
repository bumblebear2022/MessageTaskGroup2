<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
       <p>${message.sendDateTime}</p>
       <p>Message from: ${message.fromWhom}</p>
       <p> - ${message.text}</p>
   </c:forEach>
  </c:otherwise>
</c:choose>
</body>
</html>
