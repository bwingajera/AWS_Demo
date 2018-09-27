<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="${pageContext.request,contextPath }/employee/save" method="post">
First Name <input type="text" name="fname"/>
Last ame <input type="text" name="lname"/>
Address<input type="text" name="address">
Country<input type="text" name="country">
State<input type="text" name="state">
City<input type="text" name="city">
<input type="button" value="Submit">
</form>
</body>
</html>