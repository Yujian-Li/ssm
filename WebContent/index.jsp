<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Sports Jobs</title>
	<%
    	String path = request.getContextPath();
	    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
    %>
	<c:set var="path" value="<%=basePath %>"></c:set>
	<link href="${path }/css/set_4.css" rel="stylesheet" />
</head>
<body>
<h1>Sports Jobs</h1>

<div id="wrapper">

	<a href="view/applicantlogin.jsp" target="_blank">
		<div class="set_4_button1 raised hoverable">
		  <div class="anim"></div>
		  <span>Applicant</span>
		</div>
	</a>
		<!--End of Button 1 -->
		
	<a href="view/enterpriselogin.jsp" target="_blank">
		<div class="set_4_button2 raised hoverable">
		  <div class="anim"></div>
		  <span>Company</span>
		</div>
	</a>
		<!--End of Button 2 -->
		
	<a href="view/adminlogin.jsp" target="_blank">
		<div class="set_4_button3 raised hoverable">
		  <div class="anim"></div>
		  <span>Administrator</span> 
		</div>
	</a>
		<!--End of Button 3 -->
</div>
</body>
</html>