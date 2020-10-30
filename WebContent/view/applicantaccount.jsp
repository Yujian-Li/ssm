<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>Applicant</title>
	<%
    	String path = request.getContextPath();
	    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
    %>
	<c:set var="path" value="<%=basePath %>"></c:set>
 	<link href="${path }/css/bootstrap/bootstrap.min.css" rel="stylesheet" />
 	<link href="${path }/css/admin.css" rel="stylesheet" />
 	<link rel="stylesheet" type="text/css" href="${path }/js/zeroModal/zeroModal.css" />
</head>
<body>
<div id="wrapper">
<div id="page-wrapper">

	<h3>User Info</h3>

		<table class="table table-striped table-hover table-condensed">
			<thead>
				<tr>
					<th>Application ID</th>
					<th>Name</th>
					<th>Gender</th>
					<th>Account</th>
					<th>Password</th>
					
				</tr>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="${not empty applicant }">
						
							<tr>
								<td>${applicant.applicantId }</td>
								<td>${applicant.applicantName }</td>
								<td>${applicant.applicantGender }</td>
								<td>${applicant.applicantAccount }</td>
								<td>
									<span id="hidePwd">******</span>
									<span id="showPwd" style="display: none">${applicant.applicantPwd }</span>
									<button type="button" class="btn btn-info btn-xs viewPwd">Show</button>
								</td>
								
								<td>
									<div class="btn-group">
										<button type="button" class="btn btn-info btn-sm" onclick="_iframe(1, 'applicant/${applicant.applicantId }', 'applicant')">Edit</button>
									</div>
								</td>
							</tr>
					
					</c:when>
				</c:choose>
			</tbody>
		</table>

	<h3>Professional Skills</h3>
	<table class="table table-striped table-hover table-condensed">
	<c:forEach items="${skills }" var="skill">
	<tr>
		<td>${skill.skillSpec }</td>
	</tr>
	</c:forEach>	
		<td>
	        <div class="btn-group">
			<button type="button" class="btn btn-info btn-sm" onclick="_iframe(1,'applicantSkills/${applicant.applicantId}','applicantSkills')">Edit</button>
									
		    </div>
		</td>		
	</table>
	<h3>Applications</h3>
	<table class="table table-striped table-hover table-condensed">
			<thead>
				<tr>
					<th>Job ID</th>
					<th>Detail</th>					
				</tr>
			<c:forEach items="${apps }" var="app">
			<tr>
				<td>${app.jobId }</td>
				<td>${app.jobSpec }</td>
			</tr>
			</c:forEach>	
			</thead>
	</table>
		
	<br />
	<h3><a href="jobs/list.action" target="_blank">>>Find Jobs</a></h3>

	<!-- js引入 -->
    <script src="${path }/js/jquery.js"></script>
    <script src="${path }/js/bootstrap/bootstrap.min.js"></script>
    <script src="${path }/js/handle.js"></script>
    <script src="${path }/js/zeroModal/zeroModal.min.js"></script>
    <script src="${path }/js/add-update.js"></script>
   	<script src="${path }/js/handle.js"></script>
   	<script type="text/javascript">
   		$(function() {
   			$(".viewPwd").click(function() {
   				var pwd0 = $(this).siblings("#hidePwd").text();
   				if (pwd0.indexOf("*") != -1) {
   					var pwd = $(this).siblings("#showPwd").text();
   					$(this).siblings("#hidePwd").text(pwd);
   					return;
   				} else {
   					$(this).siblings("#hidePwd").text("******");
   				}
   			});
   		});
   	</script>
 </div> 
</div>  	
</body>
</html>