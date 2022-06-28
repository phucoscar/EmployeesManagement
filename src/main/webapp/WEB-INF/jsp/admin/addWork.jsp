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
                <h1>Create new work</h1>
                <form action="/addWork" method="post">
                    <div class="row">
                        <div class="col-6">
                            <div class="mb-3">
                                <label for="exampleInputUsername1" class="form-label">Name</label>
                                <input type="text" name="name" class="form-control" id="exampleInputUsername1"
                                       placeholder="Enter name of work" required>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-6">
                            <div class="mb-3">
                                <label for="exampleInputUsername2" class="form-label">Description</label>
                                <input type="text" name="description" class="form-control" id="exampleInputUsername2"
                                       placeholder="Enter description" required>
                            </div>
                        </div>
                    </div>
                    <div class="mb-3">
                        <label>Employee:</label><br>
                        <select name="user" class="form-select form-select-sm" aria-label=".form-select-lg example">
                            <c:forEach items="${users}" var="u">
                                <option value="${u.id}">${u.fullName}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <button type="submit" class="btn btn-primary">Submit</button>
                    <a href="/"><button type="button" class="btn btn-primary">Back</button></a>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>