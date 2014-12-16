<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	/*
	參考資料來源URL
	W3C ： http://www.w3school.com.cn/jquery/ajax_ajax.asp
	*/
	//http://localhost:8080/WebTestProject/ajax/myPage.jsp
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>測試AJAX-的各種屬性差異及用途</title>

<script src="//code.jquery.com/jquery-1.10.2.js"></script>

<script type="text/javascript">
	$(document).ready(function(){
		var url = "http://localhost:8080/WebTestProject/ajax/myPage.jsp";
		
		$("#b01").click(function() {
			htmlobj = $.ajax({
					url : url + "?name=jeff&age=22",
					cache : false,	//默认值: true,设置为 false 将不缓存此页面。(jQuery 1.2 新功能。)
					beforeSend : function(xhr) {
						alert(xhr);
					},
					error : function(xhr) {
						alert("error xhr = " + xhr);
					},
					success : function(obj) {
						alert("obj = " + obj);
					},
					async:false	//默认值: true。默认设置下，所有请求均为异步请求。
			});
			//alert(htmlobj + '\n' + htmlobj.responseText);
			$("#myDiv").html(htmlobj.responseText);
		});
	});
</script>

</head>

<body>
	<div id="myDiv">
    <h2>內容置換區</h2>
  </div>
  <br>
  <button id="b01" type="button">
    AJAX Demo Button
  </button>
</body>
</html>