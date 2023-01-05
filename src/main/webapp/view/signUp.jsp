<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SignUp</title>
</head>

<body>
<form method="post" action="${pageContext.request.contextPath}/api/user">
    <h1>Please, Sign Up: </h1>

    <label for="userLogin">Login:</label>
    <input id="userLogin" type="text" name="login" >

    <label for="userPassword">Password:</label>
    <input id="userPassword" type="password" name="password">

    <label for="userFullName">FullName:</label>
    <input id="userFullName" type="text" name="fullName">

    <label for="userBirthday">Birthday:</label>
    <input id="userBirthday" placeholder="dd/mm/yyyy" type="text" name="birthday">

    <button style="margin-top: 20px" type="submit">SignUp</button>
</form>
</body>
</html>
