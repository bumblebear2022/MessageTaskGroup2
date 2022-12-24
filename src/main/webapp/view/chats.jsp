<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Чаты</title>
</head>
<body>
<h1>Полученные сообщения:<h1><br/>
<%
    PrintWriter writer = resp.getWriter();
    List<Message> list = MessageServiceSingleton.getInstance().get((UserDto)req.getSession().getAttribute("user").getLogin());
    if (list != null) {
        int counter = 1;
        for (Message p : list) {
            writer.write("<br><span style='color: MidnightBlue;'>"
                + counter + ".  "
                + p.getSendDateTime().getMinute()
                + ":"
                + p.getSendDateTime().getSecond()
                + "</span><br>"
            );
            writer.write("<br><span style='color: MidnightBlue;'>Сообщение от "
                + p.getFromWhom()
                + "</span><br>"
            );
            writer.write("<br><span style='color: MidnightBlue;'>Сообщение от "
                + p.getText()
                + "</span><br>"
            );
            ++counter;
        }
    } else {
        writer.write("<br><span style='color: MidnightBlue;'> У вас пока нет входящих сообщений </span><br>");
    }
 %>
</body>
</html>
