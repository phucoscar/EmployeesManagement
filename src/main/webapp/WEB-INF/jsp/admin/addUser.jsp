<%@page pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Employee Management</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
    <div>
        <div class="bg-light p-5 rounded">
            <div class="col-sm-8 mx-auto">
                <h1>Tạo mới tài khoản</h1>
                <form action="/addEmployee" method="post">
                    <div class="row">
                        <div class="col-6">
                            <div class="mb-3">
                                <label for="exampleInputUsername1" class="form-label">Username</label>
                                <input type="text" name="userName" class="form-control" id="exampleInputUsername1"
                                       placeholder="Enter username" value="${user.username}" required>
                                <p style="color: red"><i>${userNameMessage}</i></p>
                            </div>
                        </div>
                        <div class="col-6">
                            <div class="mb-3">
                                <label for="exampleInputPassword1" class="form-label">Password</label>
                                <input type="password" name="password" class="form-control" id="exampleInputPassword1"
                                       placeholder="Enter password"  value="${user.password}" required>
                                <p style="color: red"><i>${passwordMessage}</i></p>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-6">
                            <div class="mb-3">
                                <label for="exampleInputFullName1" class="form-label">Fullname</label>
                                <input type="text" name="fullName" class="form-control" id="exampleInputFullName1"
                                       placeholder="Enter your fullname" value="${user.fullName}" required>
                            </div>
                        </div>
                        <div class="col-6">
                            <div class="mb-3">
                                <label for="exampleInputAddress1" class="form-label">Address</label>
                                <input type="text" name="address" class="form-control" id="exampleInputAddress1" value="${user.address}" placeholder="Enter your address">
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-6">
                            <div class="mb-3">
                                <label for="exampleInputEmail1" class="form-label">Email</label>
                                <input type="email" name="email" class="form-control" id="exampleInputEmail1" value="${user.email}" placeholder="Enter your email" required>
                                <p style="color:red;;"><i>${emailMessage}</i></p>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-6">
                            <div class="mb-3">
                                <label>Gender:</label><br>
                                <div class="form-check form-check-inline">
                                    <input <c:if test="${user.gender == 'Male'}">checked</c:if> class="form-check-input" type="radio" name="gender" id="inlineRadio1"
                                           value="Male" required>
                                    <label class="form-check-label" for="inlineRadio1">Male</label>
                                </div>
                                <div class="form-check form-check-inline">
                                    <input <c:if test="${user.gender == 'Female'}">checked</c:if> class="form-check-input" type="radio" name="gender" id="inlineRadio2"
                                           value="Female" required>
                                    <label class="form-check-label" for="inlineRadio2">Female</label>
                                </div>
                            </div>
                        </div>
                    </div>
                    <input type="hidden" value="USER" name="role">
                    <button type="submit" class="btn btn-primary">Submit</button>
                    <a href="/"><button type="button" class="btn btn-primary">Back</button></a>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>