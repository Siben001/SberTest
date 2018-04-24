<%@ page import="entities.Account" %><%--
  Created by IntelliJ IDEA.
  User: Екатерина
  Date: 23.04.2018
  Time: 2:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="style.css" rel="stylesheet">
    <title>Account</title>
    <link rel="import" href="../myMenu.html">
</head>

<body>
<div>
    <h1>Bank</h1>
    <hr>
</div>
<script>
    var link = document.querySelector('link[rel=import]');
    var content = link.import.querySelector('#_menu');
    document.body.appendChild(content.cloneNode(true));
</script>
<div>
    <div>
        <div>
            <div>
                <h2>Money Transfer</h2>
            </div>

            <form method="post">
                <label>From:
                    <input type="text" name="account_name_from"><br />
                </label>
                <label>To:
                    <input type="text" name="account_name_to"><br />
                </label>
                <label>Sum for taking:
                    <input type="float" name="sum"><br />
                </label>
                <button type="submit" name="submit">Submit</button>
            </form>
        </div>

    </div> <%
    String tag = "name=\"info\"";
        if (request.getAttribute("Error") != null) {
            Integer err_num = (Integer) request.getAttribute("Error");
            if (err_num == 1){
                String acc_name = (String) request.getAttribute("Account");
                out.println("<p " + tag + ">There is no " + acc_name + " account yet!</p>");
            }else if (err_num == 3){
                out.println("<p " + tag + ">Sum can't be less than 0!</p>");}
            else {
                out.println("<p " + tag + ">Please, input sum in format: 123.3</p>");
            }
        }
        else {
            if (request.getAttribute("Account_from") != null) {
                Account acc_from = (Account) request.getAttribute("Account_from");
                Account acc_to = (Account) request.getAttribute("Account_to");
                if (acc_from.getBalance() >= 0){
                    out.println("<p " + tag + ">Account: " + acc_from.getName());
                    out.println("New Balance:" + acc_from.getBalance());
                    out.println("Account: " + acc_to.getName());
                    out.println("New Balance:" + acc_to.getBalance() + "</p>");}
                    else {out.println("<p " + tag + ">There is not enough money on " + acc_from.getName() + " account!</p>");
            }}}
%>

</div>

<div>
    <button onclick="location.href='/'">Back to main</button>
</div>
</body>
</html>