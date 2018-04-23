<%--
  Created by IntelliJ IDEA.
  User: Екатерина
  Date: 23.04.2018
  Time: 0:28
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
            <div>
                <h2>Get account balance</h2>
            </div>

            <form method="post">
                <label>AccountName:
                    <input type="text" name="account_name"><br />
                </label>
                <button type="submit">Submit</button>
            </form>
        </div>

        </div> <%
        if (request.getAttribute("Account") != null) {
            String acc_name = (String) request.getAttribute("Account");
            Double acc_balance = (Double) request.getAttribute("Balance");

            if (acc_balance != null) {
                out.println("Account: " + acc_name);
                out.println("Balance:" + acc_balance);
            } else out.println("<p>There is no " + acc_name + " account yet!</p>");}
    %>

</div>

<div>
    <button onclick="location.href='/'">Back to main</button>
</div>
</body>
</html>
