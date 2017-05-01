<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: zhuxinquan
  Date: 17-4-22
  Time: 下午4:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Spittr</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/style.css"/>">
  </head>
  <body>
  <h1>
    Welcome to Spittr
    <a href="<c:url value="/spittles"/> ">Spittles</a> |
    <a href="<c:url value="/spittles/register"/> ">Register</a>
  </h1>
  </body>
</html>
