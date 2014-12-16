<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.my.ajax.MyTestAjax" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String p_name = request.getParameter("name");
	String p_age = request.getParameter("age");
	System.out.println("--req name---" + p_name);
	System.out.println("--req age---" + p_age);
	
	int int_age = 0;
	if(p_age != null && p_age.trim().length() > 0) {
		int_age = Integer.parseInt(p_age);
	}
	
	MyTestAjax myAjax = new MyTestAjax();
	String b_type_data = myAjax.getBTypeData(p_name, int_age);
	
	String a_type_data = MyTestAjax.getATypeData(p_name, int_age);
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>測試AJAX</title>
</head>
<body>
	A Type String : <%= a_type_data %>
	<br>
	<br>
	B Type String : <%= b_type_data %>
</body>
</html>