<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.chinasei.hibernate.mode.*,com.chinasei.hibernate.dao.*,java.util.List " %>
<%
	SchoolDAO dao = new SchoolDAO();
	List list = dao.findByExample(new School());
  	request.setAttribute("schoolList", list);
%>
<c:forEach var="school" items="${schoolList}">
	学校：<c:out value="${school.schoolName}" /><br />
	==============<br />
	<c:forEach var="student" items="${school.student}">
		学号：<c:out value="${student.studentNumber}" /><br />
		姓名：<c:out value="${student.studentName}" /><br />
		---------------------<br />
	</c:forEach>
</c:forEach>
