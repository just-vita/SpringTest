<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="${pageContext.request.contextPath}/js/jquery-3.3.1.js"></script>
    <script>
        var userList = new Array();
        userList.push({username:"lisi" , age:12})
        userList.push({username:"zhangsan" , age:2})
        $.ajax({
            type: "POST",
            url: "/user/test12",
            data: JSON.stringify(userList),
            contentType : 'application/json;charset=utf-8'
        });
    </script>
</head>
<body>
<h1>Success ${username}</h1>
</body>
</html>
