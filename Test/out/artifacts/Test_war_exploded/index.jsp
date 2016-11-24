<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.LinkedList" %>
<%--
  Created by IntelliJ IDEA.
  User: zhuxinquan
  Date: 16-11-9
  Time: 下午3:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  List<String> list = new LinkedList<>();
  list.add("123");
  list.add("456");
  request.setAttribute("list", list);
%>
<html>
<head>
  <title>Title</title>
</head>
<body>
<c:forEach var="l" items="${list}">
  ${l}<br/>
</c:forEach>

</body>
</html>
