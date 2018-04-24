<%--
  Created by IntelliJ IDEA.
  User: Екатерина
  Date: 23.04.2018
  Time: 1:06
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
                <h2>Taking money</h2>
            </div>

            <form method="post">
                <label>AccountName:
                    <input type="text" name="account_name"><br />

                </label>
                <label>Sum for taking:
                    <input type="float" name="sum"><br />
                </label>
                <button type="submit" name="submit">Submit</button>
            </form>
        </div>

    </div> <%
    String tag = "name=\"info\"";
    if (request.getAttribute("Account") != null) {
        String acc_name = (String) request.getAttribute("Account");
        if (request.getAttribute("Error") != null) {
            Integer err_num = (Integer) request.getAttribute("Error");
            if (err_num == 1){
                out.println("<p " + tag + ">There is no " + acc_name + " account yet!</p>");
            }else {
                out.println("<p " + tag + ">Please, input sum in format: 123.3</p>");
            }
        }
        else {
            Double acc_balance = (Double) request.getAttribute("Balance");

                if (acc_balance >= 0) {
                    out.println("<p " + tag + ">Account: " + acc_name);
                    out.println("Balance:" + acc_balance + "</p>");}
                else out.println("<p " + tag + ">There is not enough money on " + acc_name + " account!</p>");}}
%>

</div>

<div>
    <button onclick="location.href='/'">Back to main</button>
</div>
</body>
</html>
