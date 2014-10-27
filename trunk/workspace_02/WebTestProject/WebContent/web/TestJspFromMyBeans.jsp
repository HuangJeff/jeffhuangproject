<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.my.test.MyBeansControl,com.my.test.bean.MyBeans,java.util.*" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../back.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%! List<MyBeans> myBeanList = null; %>
<html>
<script src="//code.jquery.com/jquery-2.1.1.js"></script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
$(document).ready(function() {
	//alert("document is ready...");
});

$(function() {
	$( "#campaignId" ).change(function() {
		//alert("For Test...");
		
	});
});
</script>
</head>
<%
	MyBeansControl myBeanctr = new MyBeansControl();
	myBeanList = myBeanctr.getBeansList();
%>
<body>
<%= myBeanList %>
<p>
<% for(int i=0;i<myBeanList.size();i++) {
	out.println("a::" + myBeanList.get(i).getId());
%>
	<%= myBeanList.get(i).getId() %>
	<p>
<% } %>
<p>

<table class="fm">
	<tr>
		<td>活動名稱</td>
		<td>
			<select id="campaignId" name="campaignId">
				<% for(int i=0;i<myBeanList.size();i++) {
					//out.println("a::" + myBeanList.get(i).getId());
					int _id = myBeanList.get(i).getId();
					String _name = myBeanList.get(i).getName();
					Date _date1 = myBeanList.get(i).getDate1();
					Date _date2 = myBeanList.get(i).getDate2();
				%>
					<option value="<%= _id %>"><%= _name %></option>
				<% } %>
			</select>
		</td>
	</tr>
	<tr>
		<td>
			<input id="input1" value="AA"/>
		</td>
		<td>
			<input id="input2" value="BB"/>
		</td>
	</tr>
</table>


<!-- 底下的Code都不行耶  ooxx -->
<c:out value="${ myBeanList }"></c:out>
<c:set var="testType" scope="page" value="${ myBeanList }"></c:set>

<c:forEach items="${ testType }">
	<c:out value="${ testType.getId() }"></c:out>
</c:forEach>
</body>
</html>