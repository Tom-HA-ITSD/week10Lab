<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Forgot Password</title>
    </head>
    <body>
        <h1>Forgot Password</h1>
        Please enter you email address to retrieve your password.<br>
        <form action="forgot" method="post">
            Email address: <input type="text" name="email">
            <input type="submit" value="Submit">
        </form>
    </body>
</html>
