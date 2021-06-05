<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table{
 border-collapse: collapse;
 width : 50%;
}
table, th, td {
  border: 0.5px solid black;
}
</style>
</head>
<body>
		<table border="0">
			<form action="">
			<%
			int count = (Integer)request.getAttribute("count");
			
			for(int i =1;i<=count;i++){%>			
			  <tr>
			  	<td><input type="checkbox" value="<%=i%>"/><%=i%></td>
			  </tr>			
			<%}%>			  			
			</form>
		</table>
		<!-- 如果count數量是0就顯示無資料  -->
		<%if(count>0){ %>
	    <button>確定</button>
	    <%}else{ %>
	    <H1>無資料!!</H1>
	    <%}%>	
</body>
</html>