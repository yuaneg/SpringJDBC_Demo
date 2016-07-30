<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello spring mvc!  
</h1>

<P>  The time on the server is ${serverTime}. </P>

<c:url value="/name" var="name"> </c:url>
<c:url value="/redirect?rename=美娇&&name2=恩光" var="rename"></c:url>
<c:url value="/pathvariable/美娇/恩光" var="rename2"></c:url>
<c:url value="/blind" var="blind"></c:url>
<a href="${name }">普通请求+取值</a>
<br/><br/>
<a href="${rename }">重定向的方式传值</a>
<br/><br/>
<a href="${rename2 }">通过url传参数后台 @PathVariable取值</a>
<br/><br/>
<form action="${blind }" method="post" accept-charset="utf-8" >
<input value="袁恩光喜欢美娇" type="text" readonly="readonly" name="name">
<input value="999999" type="text" readonly="readonly" name="age">
<input type="submit" value="请求" >
</form>
</body>
</html>
