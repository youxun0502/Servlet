<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Using JavaBeans with JSP</title>
</head>
<body>
	<div align="center">
	<h3>Using JavaBeans with JSP</h3>
	<jsp:useBean id="order" class="com.lcpan.bean.OrderBean" scope="request" />
	<jsp:setProperty name="order" property="bookno" />
	<jsp:setProperty property="price" name="order"/>
	<jsp:setProperty property="quantity" name="order"/>
	<table border="1">
		<tr><th>book no.</th><th>unit price</th><th>quantity</th><th>subTotal</th></tr>
		<tr align="right">
			<td><jsp:getProperty property="bookno" name="order"/></td>
			<td>$<jsp:getProperty property="price" name="order"/></td>
			<td><jsp:getProperty property="quantity" name="order"/></td>
			<td>$<jsp:getProperty property="subTotal" name="order"/></td>
		</tr>
	</table>	
	</div>
</body>
</html>