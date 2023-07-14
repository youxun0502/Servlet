<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>Using Beans with JSP</h3>
	<jsp:useBean id="stringBean" class="com.lcpan.bean.StringBean" />
	<ol>
		<li><jsp:setProperty name="stringBean" property="message" value="This is a test" />
		Set and get property with jsp:setProperty:<br>
		<i><jsp:getProperty name="stringBean" property="message" /></i></li>
		<li><%stringBean.setMessage("Learning JSP is wonderful"); %>
		Set and get property with ScriptLet:<br>
		<i><%= stringBean.getMessage() %></i></li>
	</ol>
</body>
</html>