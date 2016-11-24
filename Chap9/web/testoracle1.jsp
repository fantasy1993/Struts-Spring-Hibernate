<%@ page contentType="text/html;charset=UTF-8"%> 
<%@ page import="java.sql.*,javax.sql.DataSource,javax.naming.*"%>
<html>
<body>
<%
	try
	{ 
		Context initCtx=new InitialContext(); 
		DataSource ds = (DataSource)initCtx.lookup("java:comp/env/jdbc/chinaseiDB"); 
		Connection conn=ds.getConnection();
		Statement stmt=conn.createStatement(); 
		ResultSet rs =stmt.executeQuery("select * from USERS"); 
		while(rs.next()) 
		{ 
			out.println(rs.getString("ID")+"<br>"); 
			out.println(rs.getString("USER_NAME")+"<br>"); 
			out.println(rs.getString("U_PASSWORD")+"<br>"); 
		} 
		rs.close(); 
		stmt.close(); 
		conn.close();
	} 
	catch(Exception e) 
	{ 
	 e.printStackTrace();
	} 
	%> 
</body> 
</html> 