
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Отправка сообщений</title>
</head>
<body>
<form method="post" action="api/message">
Введите логин адресата а также ваше сообщение: <br/>

Логин: <input type="text" name="To" value="" /><br/>

Сообщение: <input type="text" name="Text" value="" /><br/>

<input type="submit" value="Отправить" /><br/>
</form>
</body>
</html>
