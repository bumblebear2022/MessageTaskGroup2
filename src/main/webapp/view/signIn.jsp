<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SignIn</title>
</head>

<body>
<form method="post" action="/login">

    <label for="userLogin">Login:</label>
    <input id="userLogin" type="text" name="login" >

    <label for="userPassword">Password:</label>
    <input id="userPassword" type="password" name="password">

    <button style="margin-top: 20px" type="submit">LogIn</button>
</form>
</body>
</html>