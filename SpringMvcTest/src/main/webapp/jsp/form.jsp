<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/user/test15" method="post"
          enctype="multipart/form-data">
        名称：<input type="text" name="name"><br>
        文件：<input type="file" name="file"><br>
        <input type="submit" value=" 提交"><br>
    </form>
</body>
</html>
