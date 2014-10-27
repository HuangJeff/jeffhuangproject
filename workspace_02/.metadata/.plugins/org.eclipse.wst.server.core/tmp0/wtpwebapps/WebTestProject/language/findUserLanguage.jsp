<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../back.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<script src="../js/findUserLanguage.js"></script>

<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<h2>用Js找出來的語系</h2>
 <span id="js_language"></span>
 <br>
 <span id="js_language2"></span>
 <script type="text/javascript">
 	$(document).ready(function() {
 		/* IE11 居然有問題無法alert */
 		$(function() {
 			var s = getTransLang();
 	 		//alert(s);
 	 		$("#js_language2").text(s);
 		});
 		$(function() {
 			//function:getLang() Come From ==> ../js/findUserLanguage.js
 	 		var lang = getLang();
 	 		alert(lang);
 		});
 	});
 	
   $(function () {
       	var lang = window.navigator.userLanguage || window.navigator.language;
       	//var relang=lang.toLowerCase();
       	//alert("lang : " + lang);
       	$("#js_language").text(lang);
   });
</script>
  
</body>
</html>