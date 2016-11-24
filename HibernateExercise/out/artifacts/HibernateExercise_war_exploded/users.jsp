<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ page import="com.chinasei.hibernate.*,java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
</head>
<body>
<%
	//获取DAO的实现
	UsersDAO dao = new UsersDAO();
	//通过dao获取用户列表
	List list = dao.findByUserName("zhuxinquan");
	for(int i=0; i<list.size(); i++){
		Users users = (Users)list.get(i);
//		out.print("ID：" + users.getId() + "<br>");
//		out.print("用户名：" + users.getUserName() + "<br>");
//		out.print("密码：" + users.getPassword() + "<br>");
//		out.print("电子邮件：" + users.getEmail() + "<br>");
%>
ID：<%=users.getId()%><br>
用户名：<%=users.getUserName()%><br>
密码：<%=users.getPassword()%><br>
电子邮件：<%=users.getEmail()%><br>
<%

	}
%>
</body>
</html>