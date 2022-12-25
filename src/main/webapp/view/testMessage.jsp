<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Test Message</title>
</head>
<body>
<c:forEach items="${messages}" var="message">
    <p>${message.fromWhom} : ${message.text}</p>
</c:forEach>
</body>
</html>
