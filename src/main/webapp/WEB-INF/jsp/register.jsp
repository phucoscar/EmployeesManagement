<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <div class="row" style="border: 1px darkgrey solid; border-radius: 10px;width: 50%; margin: 0 auto; padding: 20px;">
        <div class="col-sm-12">
            <h3>Register</h3>
            <form action="/register" method="post">
                <div class="form-group">
                    <label>UserName</label>
                    <input type="text" class="form-control" name="userName" placeholder="Enter username"
                           value="${user.username}" required>
                    <p style="color: red"><i>${userNameMessage}</i></p>
                </div>
                <div class="form-group">
                    <label>Password:</label>
                    <input type="password" class="form-control" name="password" placeholder="Enter password"
                           value="${user.password}" required>
                    <p style="color: red"><i>${passwordMessage}</i></p>
                </div>
                <div class="form-group">
                    <label>FullName</label>
                    <input type="text" class="form-control" name="fullName" placeholder="Enter fullname"
                           value="${user.fullName}" required>
                </div>
                <div class="form-group">
                    <label>Gender:</label><br>
                    <div class="form-check form-check-inline">
                        <input
                                <c:if test="${user.gender == 'Male'}">checked</c:if> class="form-check-input"
                                type="radio" name="gender" id="inlineRadio1" value="Male" required>
                        <label class="form-check-label" for="inlineRadio1">Male</label>
                    </div>
                    <div class="form-check form-check-inline">
                        <input
                                <c:if test="${user.gender == 'Female'}">checked</c:if> class="form-check-input"
                                type="radio" name="gender" id="inlineRadio2"
                                value="Female" required>
                        <label class="form-check-label" for="inlineRadio2">Female</label>
                    </div>
                </div>
                <div class="form-group">
                    <label>Address</label>
                    <input type="text" class="form-control" name="address" placeholder="Enter address"
                           value="${user.address}">
                </div>
                <div class="form-group">
                    <label>Email</label>
                    <input type="text" class="form-control" name="email" placeholder="Enter email" value="${user.email}"
                           required>
                    <p style="color: red"><i>${emailMessage}</i></p>
                </div>
                <input type="hidden" value="USER" name="role">
                <button type="submit" class="btn btn-primary">Submit</button>
                <a href="/login">
                    <button type="button">Sign in</button>
                </a>
            </form>
        </div>
    </div>
</div>
</body>
</html>
