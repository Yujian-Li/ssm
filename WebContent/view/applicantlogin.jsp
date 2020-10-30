<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Applicant Login</title>
	<%
    	String path = request.getContextPath();
	    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
    %>
<c:set var="path" value="<%=basePath %>"></c:set>
<link rel="stylesheet" type="text/css" href="${path }/css/login.css" />	
</head>
<body>
<div class="main">
		<div class="login">
			<h1>Sports Jobs</h1>
			<div class="inset">
				<!--start-main-->
				<form action=" <%=basePath %>/applicantlogin.action" method="post">
			         <div>
			         	<h2>Applicant Login</h2>
						<span><label>username</label></span>
						<span><input type="text" name="applicantAccount" class="textbox"/></span>
					 </div>
					 <div>
						<span><label>password</label></span>
					    <span><input type="password" name="applicantPwd" class="password"/></span>
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

<!-- 登录成功跳转applicantaccount-->