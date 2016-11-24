<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.chinasei.hibernate.dao.*,java.util.List" %>
<%@ page import="com.chinasei.hibernate.mode.School" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String id = request.getParameter("id");
	String flag = request.getParameter("flag");
	System.out.println("id" + id);
	if(flag != null){
		SchoolDAO dao = new SchoolDAO();
		if(id.equals("")){
			List list = dao.findByExample(new School());
			System.out.println(list.size());
			for(int i=0; i<list.size(); i++){
				School school = (School)list.get(i);
				dao.delete(school); 
			}
		}
		else{
			School school = dao.findById(Integer.parseInt(id));
			if(school == null){
				request.getRequestDispatcher("schoolStudents.jsp").forward(request, response);
			}
			dao.delete(school);
		}
		request.getRequestDispatcher("schoolStudents.jsp").forward(request,response);
	}
	else{
%>
	<form action="deleteSchool.jsp" method="post">
	    ID：<input type="text" name="id"><br/>
		<input type="submit" value="删除">
		<input type="hidden" name="flag" value="1"><br/>
	</form>
<%
	}
%>
</body>
</html>