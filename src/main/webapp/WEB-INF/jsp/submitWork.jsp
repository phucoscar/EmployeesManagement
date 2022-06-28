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
                <h1>Submit Work</h1>
                <form action="/submitWork/${workID}" method="post">
                  <h1>Enter content of work here</h1>
                    <div class="row">
                        <div class="col-6">
                            <div class="mb-3">
                                <textarea name="content" rows="8" cols="80"></textarea>
                            </div>
                        </div>
                    </div>
                    <input type="hidden" value="${user.id}" name="user">
                    <input type="hidden" value="${workID}" name="work">
                    <button type="submit" class="btn btn-primary">Submit</button>
                    <a href="/myWork"><button type="button" class="btn btn-primary">Back</button></a>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>