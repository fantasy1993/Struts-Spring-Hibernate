<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.chinasei.hibernate.mode.*,com.chinasei.hibernate.dao.*,java.util.List" %>
<%
	StudentDAO dao = new StudentDAO();
	List list = dao.findByExample(new Student());
	for(int i=0; i<list.size(); i++){
		Student student = (Student)list.get(i);
		System.out.println(student);
		out.print("姓名：" + student.getStudentName() + "<br>");
		out.print("学号：" + student.getStudentNumber() + "<br>");
		out.print("学校：" + student.getSchool().getSchoolName() + "<br>");
		out.print("学校地址：" + student.getSchool().getSchoolAddress() + "<br>");
		out.print("--------------------------------------<br>");
	}
%>
