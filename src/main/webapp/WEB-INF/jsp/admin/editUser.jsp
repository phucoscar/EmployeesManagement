<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page pageEncoding="UTF-8" %>
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
                <h1>Chỉnh sửa</h1>
                <form action="/editEmployee" method="post">
                    <input name="id" type="hidden" value="${user.id}">
                    <div class="row">
                        <div class="col-6">
                            <div class="mb-3">
                                <label for="exampleInputUsername1" class="form-label">Username</label>
                                <input type="text" name="userName" class="form-control" id="exampleInputUsername1"
                                       value="${user.username}" required>
                            </div>
                        </div>
                        <div class="col-6">
                            <div class="mb-3">
                                <input type="hidden" name="password" class="form-control" id="exampleInputPassword1"
                                       value="${user.password}" required>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-6">
                            <div class="mb-3">
                                <label for="exampleInputFullName1" class="form-label">Fullname</label>
                                <input type="text" name="fullName" class="form-control" id="exampleInputFullName1"
                                       value="${user.fullName}" required>
                            </div>
                        </div>
                        <div class="col-6">
                            <div class="mb-3">
                                <label for="exampleInputAddress1" class="form-label">Address</label>
                                <input type="text" name="address" class="form-control" id="exampleInputAddress1" value="${user.address}">
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-6">
                            <div class="mb-3">
                                <label for="exampleInputEmail1" class="form-label">Email</label>
                                <input type="email" name="email" class="form-control" id="exampleInputEmail1" value="${user.email}" required>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-6">
                            <div class="mb-3">
                                <label>Gender:</label><br>
                                <div class="form-check form-check-inline">
                                    <input class="form-check-input" type="radio" name="gender" <c:if test="${user.gender == 'Male'}">checked</c:if> id="inlineRadio1" value="Male">
                                    <label class="form-check-label" for="inlineRadio1">Male</label>
                                </div>
                                <div class="form-check form-check-inline">
                                    <input class="form-check-input" type="radio" name="gender" <c:if test="${user.gender == 'Female'}">checked</c:if> id="inlineRadio2"
                                           value="Female">
                                    <label class="form-check-label" for="inlineRadio2">Female</label>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="mb-3">
                        <label>Role:</label><br>
                        <select name="role" class="form-select form-select-sm" aria-label=".form-select-lg example">
                            <option value="USER" <c:if test = "${role == 'USER'}">selected</c:if>>User</option>
                            <option value="ADMIN" <c:if test = "${role == 'ADMIN'}">selected</c:if>>>Admin</option>
                        </select>
                    </div>
                    <button type="submit" class="btn btn-primary">Update</button>
                    <a href="/listUser"><button type="button" class="btn btn-primary">Back</button></a>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>