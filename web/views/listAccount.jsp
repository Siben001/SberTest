<%@ page import="java.util.List" %>
<%@ page import="entities.Account" %><%--
  Created by IntelliJ IDEA.
  User: Екатерина
  Date: 22.04.2018
  Time: 22:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Account</title>
</head>

<body>
<div>
    <h1>Bank</h1>
</div>

<div>
    <div>
        <div>
            <h2>Accounts</h2>
        </div> <%
        List<Account> acc = (List<Account>) request.getAttribute("Accounts");
        String tag = "name=\"info\"";
        if (acc != null && !acc.isEmpty()) {
            out.println("<ui name=\"acc_list\">");
            for (Account a : acc) {
                out.println("<li>" + a.getName() + "</li>");
            }
            out.println("</ui>");
        } else out.println("<p " + tag + ">There is no accounts yet!</p>");
    %>
    </div>
</div>

<div>
    <button onclick="location.href='/'">Back to main</button>
</div>
</body>
</html>

