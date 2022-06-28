<%@page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    <title>Employee Management</title>
</head>
<body>

<div class="container" style="margin-top: 50px;">
    <div class="row" style="border: 1px darkgrey solid; border-radius: 10px;width: 50%; margin: 0 auto; padding: 20px;" >
        <div class="col-sm-12">
            <p style="color: red">${message}</p>
            <h3>Login</h3>
            <form action="/doLogin" method="post">
                <div class="form-group">
                    <label>Username</label>
                    <input type="text" class="form-control" name="username" placeholder="Enter username">
                </div>
                <div class="form-group">
                    <label>Password:</label>
                    <input type="password" class="form-control" name="password" placeholder="Enter password">
                </div>
                <button type="submit" class="btn btn-primary">Login</button>
                <p style="margin: 10px; font-size: 16px; display: inline-block"><a href="/register">Register</a></p>
            </form>
        </div>
    </div>
</div>
</body>
</html>
