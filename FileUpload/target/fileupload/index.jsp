<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
<body>
<h2>File Upload</h2>

<form action="upload.action" method="post" enctype="multipart/form-data">
    上传文件1：<input type="file" name="upload"><br>
    上传文件2：<input type="file" name="upload"><br>
    上传文件3：<input type="file" name="upload"><br>
    <input type="submit" value="提交">${result}
</form>

</body>
</html>
