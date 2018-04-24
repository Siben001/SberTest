<%--
  Created by IntelliJ IDEA.
  User: Екатерина
  Date: 22.04.2018
  Time: 22:21
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
            <h2>Add account</h2>
        </div>

        <form method="post">
            <label>AccountName:
                <input type="text" name="account_name"><br />
            </label>
            <button type="submit" name="submit">Submit</button>
        </form>
    </div>
    <%
        String tag = "name=\"info\"";
        if (request.getAttribute("Error") != null){

            Integer err_num = (Integer) request.getAttribute("Error");
            if (err_num == 1){
                out.println("<p " + tag + ">Account '" + request.getAttribute("Account") + "' is already exist!</p>"); }
                else{
                    out.println("<p " + tag + ">Please, enter account name</p>");
                }
        } else if (request.getAttribute("Account") != null) {
                out.println("<p " + tag + ">Account '" + request.getAttribute("Account") + "' added!</p>");
            }
    %>
</div>

<div>
    <button name="back" onclick="location.href='/'">Back to main</button>
</div>
</body>
</html>
