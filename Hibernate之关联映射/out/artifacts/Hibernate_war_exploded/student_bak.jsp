<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.chinasei.hibernate.model.*,com.chinasei.hibernate.dao.*,java.util.List" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	StudentDAO dao = new StudentDAO();
	List list = dao.findByExample(new Student());
    request.setAttribute("studentList", list);
%>
	<c:forEach var="student" items="${studentList}">
		姓名：<c:out value="${student.stuName}" /><br />
		学号：<c:out value="${student.stuNumber}" /><br />
		学校：<c:out value="${student.school.schoolName}" /><br />
		学校地址：<c:out value="${ student.school.schoolAddress}" /><br />
	</c:forEach>

</body>
</html>