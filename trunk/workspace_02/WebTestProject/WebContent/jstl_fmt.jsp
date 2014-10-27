<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSTL fmt:dateNumber Tag</title>
</head>
<body>
<h3>Core JSTL Tags</h3>

<!-- Core JSTL Tags -->
<c:set var="now" value="<%=new java.util.Date()%>" />
<c:set var="tmpAA" value="ABC"></c:set>
<c:set var="salary" scope="session" value="${ 2000 * 2 }"></c:set>

<c:out value="${ 'for test' }"></c:out><p>
<c:out value="${ now }"></c:out><p>
<c:out value="${ tmpAA }"></c:out><p>
<c:out value="Before salary = ${ salary }"></c:out><p>
<c:remove var="salary"/>
<c:out value="after salary = ${ salary }"></c:out><p>

<c:url var="myUrl" value="./index.jsp">
<c:param name="t1" value="1234"></c:param>
<c:param name="t2" value="summary"></c:param>
</c:url>
<c:import var="data" url="${ myUrl }"></c:import><p>
<c:out value="${ data }"></c:out>

<h3>Formatting JSTL Tags</h3>

<!-- Formatting JSTL Tags -->
<p>Formatted Date (1): <fmt:formatDate type="time" value="${now}" /></p>
<p>Formatted Date (2): <fmt:formatDate type="date" value="${now}" /></p>
<p>Formatted Date (3): <fmt:formatDate type="both" value="${now}" /></p>
<p>Formatted Date (4): <fmt:formatDate type="both" dateStyle="short" timeStyle="short" 
            value="${now}" /></p>
<p>Formatted Date (5): <fmt:formatDate type="both" dateStyle="medium" timeStyle="medium" 
            value="${now}" /></p>
<p>Formatted Date (6): <fmt:formatDate type="both" dateStyle="long" timeStyle="long" 
            value="${now}" /></p>
<p>Formatted Date (7): <fmt:formatDate pattern="yyyy-MM-dd" value="${now}" /></p>
</body>
</html>