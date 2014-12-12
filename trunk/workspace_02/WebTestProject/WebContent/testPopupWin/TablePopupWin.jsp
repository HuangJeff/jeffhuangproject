<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../back.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>測試Table中的彈跳視窗</title>
	<script src="//code.jquery.com/jquery-1.10.2.js"></script>

	<script type="text/javascript">
		function showTooltip(x, y, color, contents) {
	        $('<div id="tooltip">' + contents + '</div>').css({
	            position: 'absolute',
	            display: 'none',
	            top: y - 40,
	            left: x - 120,
	            border: '2px solid ' + color,
	            padding: '3px',
	            'font-size': '9px',
	            'border-radius': '5px',
	            'background-color': '#fff',
	            //'font-family': 'Verdana, Arial, Helvetica, Tahoma, sans-serif',
	            'font-family': 'Microsoft JhengHei',
	            opacity: 0.9
	        }).appendTo("body").fadeIn(200);
	    }
		
		$("#forTest1").click(function() {
			alert("123");
			sx = e.pageX + document.documentElement.scrollTop;
			alert(sx);
		});
		
		function forTest() {
			var runFlag = true;
			var color = "#C71585";
			
			var label = "item.series.label";
			var month = 12;
			var day = 3;
			var y = 100;
			$("#tooltip").remove();
			var sx;
			var sy;
			if(runFlag) {
			$(document).click(function (e) {
				sx = e.pageX + document.documentElement.scrollTop;
				sy = e.pageY + document.documentElement.scrollLeft;
				//alert(sx + ":" + sy);
				runFlag = false;
			});
			}
			alert(sx + ":" + sy);
			showTooltip(150, 150, color,
				"<div style='font-size: 14px'>" + label + "<br>" + month +"/"+ day + " : " + y + "</div>");
		}
		
		$("#mybutton").click(function(e) {
		    alert("X:" + e.pageX + " Y:" + e.pageY);
		});
		
		mouseXYPoint = $(document).click(function (e) {
			sx = e.pageX + document.documentElement.scrollTop;
			sy = e.pageY + document.documentElement.scrollLeft;
			//alert(sx + ":" + sy);
			return sx;
		});
	</script>

</head>
<body>
	<table border=1>
		<tr>
			<td>
				<div onmouseout="alert('你的滑鼠移開此區囉!')" style="padding:5px;background-color:#FFE5B5;">
					滑鼠游標移經此處測試
				</div>
			</td>
			<td>
		 		<div id="TestBox" onmouseout="alert('滑鼠移出')" onmouseover="alert('滑鼠經過')" style="padding:5px;background-color:#FFE5B5;">
					滑鼠游標移經此處測試
				</div>
			</td>
			<td>
		 		<div onclick="forTest();" style="padding:5px;background-color:#FFE5B5;">
					滑鼠游標Click此處測試
				</div>
			</td>
			<td>
		 		DDD
			</td>
		</tr>
	</table>
	<button id="mybutton">按鈕</button>
</body>
</html>