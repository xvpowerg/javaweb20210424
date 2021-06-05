<%@page import="java.util.List"%>
<%@page import="tw.com.bean.ImageObj"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<H1>ShowImage</H1>
		<%
		List<ImageObj> list =(List)request.getAttribute("imageList");
		for(ImageObj imgObj : list){
		%>
		<img alt="<%=imgObj.getAlt() %>" src="images\<%=imgObj.getName()%>" width="30%" height="30%">
		<%} %>
</body>
</html>