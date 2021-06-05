<%@page import="java.util.List,java.util.ArrayList,tw.com.bean.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<ol>
	<%
	List<String> nameList = (List)session.getAttribute("myList");
	for(String name : nameList){ %>		
		<li><%=name%></li>
		<%} %>
	</ol>
	
	<h2>
	<%Student st = (Student)application.getAttribute("student"); 
	out.print(st.getName()+":"+st.getId());
	%>
		
	</h2>
		
</body>
</html>