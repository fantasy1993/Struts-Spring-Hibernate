<%@ page contentType="text/html;charset=UTF-8"%> 
<%@ page import="java.sql.*"%>
<html>
<body>
<%
	Class.forName("oracle.jdbc.driver.OracleDriver").newInstance(); 
	String url="jdbc:oracle:thin:@localhost:1521:chinasei";	
	String user="scott"; 
	String password="tiger"; 
	Connection conn= DriverManager.getConnection(url,user,password);	
	Statement stmt=conn.createStatement();
	String sql="select * from USERS"; 
	ResultSet rs=stmt.executeQuery(sql); 
	while(rs.next()) {
		out.println(rs.getString("ID")+"<br>"); 
		out.println(rs.getString("USER_NAME")+"<br>"); 
		out.println(rs.getString("U_PASSWORD")+"<br>");  
	}
	rs.close(); 
	stmt.close(); 
	conn.close(); 
%>
</body> 
</html> 