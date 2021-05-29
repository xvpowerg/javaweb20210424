<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<% 
//可使用<%內寫java code
//<%= 做輸出
for (int i =1;i<=5;i++){
%>
	<h1><%=i%></h1>
<%
}
%>	
</body>
</html>