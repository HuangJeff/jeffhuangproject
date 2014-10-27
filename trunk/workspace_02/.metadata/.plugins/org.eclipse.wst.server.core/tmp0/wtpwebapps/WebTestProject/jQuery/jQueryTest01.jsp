<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <title>selected demo</title>
  <style>
  div {
    color: red;
  }
  </style>
  <script src="//code.jquery.com/jquery-1.10.2.js"></script>
</head>
<body>
 
<select name="garden" multiple="multiple">
  <option>Flowers</option>
  <option selected="selected">Shrubs</option>
  <option>Trees</option>
  <option selected="selected">Bushes</option>
  <option>Grass</option>
  <option>Dirt</option>
</select>
<div></div>
 
<script>
$( "select" )
  .change(function() {
    var str = "";
    $( "select option:selected" ).each(function() {
      str += $( this ).text() + " ";
    });
    $( "div" ).text( str );
  })
  .trigger( "change" ); //最後要觸發select的change事件
</script>
 
</body>
</html>