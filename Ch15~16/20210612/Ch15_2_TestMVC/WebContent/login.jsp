<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登入</title>
</head>
<body>
			<H1>登入</H1>
			<form action="login" method="post">			
		<input name="account" placeholder="帳號"/><br>
		<input type="password" name="password" placeholder="密碼"/>	
		<button>確定</button>
			</form>
<h2><%=session.getAttribute("msg") == null?"":session.getAttribute("msg")%></h2>	
		
</body>
</html>