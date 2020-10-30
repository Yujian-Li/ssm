<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>User Management</title>
	<%
    	String path = request.getContextPath();
	    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
    %>
	<c:set var="path" value="<%=basePath %>"></c:set>
	<link href="${path }/css/set_9.css" rel="stylesheet" />
	<link href="${path }/css/admin.css" rel="stylesheet" />
	<link href="${path }/css/bootstrap/bootstrap.min.css" rel="stylesheet" />
</head>
<body>
<div id="wrapper">
<div id="page-wrapper">

<h3></h3>

<div class="set_9_btn4-corner"> 
	<span class="line1"></span> 
	<span class="line2"></span> 
	<span class="line3"></span> 
	<span class="line4"></span> 
	<a href="applicants">Applicant Management</a>
</div>

<div class="set_9_btn4-corner"> 
	<span class="line1"></span> 
	<span class="line2"></span> 
	<span class="line3"></span> 
	<span class="line4"></span> 
	<a href="enterprises">Company Management</a>
</div>

</div>
</div>
</body>
</html>