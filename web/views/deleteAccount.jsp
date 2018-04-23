<%--
  Created by IntelliJ IDEA.
  User: Екатерина
  Date: 22.04.2018
  Time: 23:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add new user</title>
</head>

<body>
<div>
    <h1>Bank</h1>
</div>

<div>
    <div>
        <div>
            <h2>Delete account</h2>
        </div>

        <form method="post">
            <label>AccountName:
                <input type="text" name="account_name"><br />
            </label>
            <button type="submit">Submit</button>
        </form>
    </div>
    <%
        if (request.getAttribute("Error") != null){
            out.println("<p>Account '" + request.getAttribute("Account") + "' is not exist!</p>");
        } else if (request.getAttribute("Account") != null) {
            out.println("<p>Account '" + request.getAttribute("Account") + "' deleted!</p>");
        }
    %>
</div>

<div>
    <button onclick="location.href='/'">Back to main</button>
</div>
</body>
</html>
