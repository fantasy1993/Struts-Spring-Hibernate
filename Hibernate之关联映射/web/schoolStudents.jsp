<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List,java.util.Iterator" %>
<%@ page import="com.chinasei.hibernate.mode.School" %>
<%@ page import="com.chinasei.hibernate.dao.SchoolDAO" %>
<%@ page import="java.util.List" %>
<%@ page import="com.chinasei.hibernate.mode.Student" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	SchoolDAO dao = new SchoolDAO();
	List list = dao.findByExample(new School());
	for(int i=0; i<list.size(); i++){
		School school = (School)list.get(i);
		out.print("学校：" + school.getSchoolName() + "<br>");
		out.print("==============<br>");
		Iterator it = school.getStudent().iterator();
		while(it.hasNext()){
			Student student = (Student)it.next();
			out.print("学号：" + student.getStudentNumber() + "<br>");
			out.print("姓名：" + student.getStudentName() + "<br>");
		out.print("---------------------<br>");
		}
	}
%>
</body>
</html>