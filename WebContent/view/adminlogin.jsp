<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
    	String path = request.getContextPath();
	    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<c:set var="path" value="<%=basePath %>"></c:set>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${path }/css/login.css" />
<title>Admin login</title>
</head>
<body>
	<div class="main">
		<div class="login">
			<h1>Sports Jobs</h1>
			<div class="inset">
				<!--start-main-->
				<form action=" <%=basePath %>/adminlogin.action" method="post">
			         <div>
			         	<h2>Admin Login</h2>
						<span><label>Username</label></span>
						<span><input type="text" name="adminAccount" class="textbox"/></span>
					 </div>
					 <div>
						<span><label>Password</label></span>
					    <span><input type="password" name="adminPwd" class="password"/></span>
					 </div>
					<div class="sign">
                        <input type="submit" value="Login" class="submit" />
					</div>
					</form>
				</div>
			</div>
		<!--//end-main-->
		</div>


</body>
</html>

<!-- applicants & enterprises .jsp -->