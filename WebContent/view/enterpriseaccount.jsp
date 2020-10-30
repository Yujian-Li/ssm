<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>Company</title>
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
<h3>Company Info</h3>
		<table class="table table-striped table-hover table-condensed">
			<thead>
				<tr>
					<th>Company ID</th>
					<th>Name</th>
					<th>Introduction</th>
					<th>Account</th>
					<th>Password</th>
					
				</tr>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="${not empty enterprise }">
						
							<tr>
								<td>${enterprise.enterpriseId }</td>
								<td>${enterprise.enterpriseName }</td>
								<td>${enterprise.enterpriseSpec }</td>
								<td>${enterprise.enterpriseAccount }</td>
								<td>
									<span id="hidePwd">******</span>
									<span id="showPwd" style="display: none">${enterprise.enterprisePwd }</span>
									<button type="button" class="btn btn-info btn-xs viewPwd">Show</button>
								</td>
								
								<td>
									<div class="btn-group">
										<button type="button" class="btn btn-info btn-sm" onclick="_iframe(1, 'enterprise/${enterprise.enterpriseId }', 'enterprise')">Edit</button>
									</div>
								</td>
							</tr>
					
					</c:when>
				</c:choose>
			</tbody>
		</table>

	<h3>Jobs Posted</h3>
	<table class="table table-striped table-hover table-condensed">
	<thead>
	<tr>
		<th>Job Detail</th>
		<th>Contact</th>
		<th>Salary</th>
		<th>Category</th>
		<th>Location</th>
		<th></th>
	</tr>
	</thead>
	<tbody>
	<c:choose>
	<c:when test="${not empty jobs }">
	
	<c:forEach items="${jobs }" var="job">
	<tr>
		<td>${job.jobSpec }</td>
		<td>${job.contact }</td>
		<td>${job.monthlySalary }</td>
		<td>${job.jobType }</td>
		<td>${job.location }</td>
<%-- 		<td>
			<div class="btn-group">
				<button type="button" class="btn btn-info btn-sm" onclick="_iframe(1, 'job/${enterprise.enterpriseId }', 'enterpriseJob')">修改</button>
			</div>
		</td> --%>		
	</tr>	
	</c:forEach>	
		<%-- <td>
	        <div class="btn-group">
			<button type="button" class="btn btn-danger btn-sm" onclick="del('enterpriseJob/${job.jobId }')">删除</button>						
		    </div>
		</td> --%>
	</c:when>
	</c:choose>
	</tbody>			
	</table>
	<%-- <form action="enterprise" method="post">
		<input type="hidden" value="DELETE" name="_method" />
	</form>	
	<button type="button" class="btn btn-info btn-sm" onclick="_iframe(1,'enterpriseJobs/${enterprise.enterpriseId}','enterpriseJobs')">添加</button> --%>
	<h3>Applications Received</h3>
	<table class="table table-striped table-hover table-condensed">
	<thead>
	<tr>
		<th>Applicant ID</th>
		<th>Name</th>
		<th>Gender</th>
		<th>Email</th>
		<th>Job Applied</th>
		<!-- <th>Applicant Info</th> -->
	</tr>
	</thead>
	<tbody>
	<c:choose>
	<c:when test="${not empty apps }">
	
	<c:forEach items="${apps }" var="app">
	<tr>
		<td>${app.applicantId }</td>
		<td>${app.applicantName }</td>
		<td>${app.applicantGender }</td>
		<td>${app.applicantAccount }</td>
		<td>${app.jobSpec }</td>
		<!-- <td>
			<a href="#" class="btn btn-info btn-sm">Show</a>
		</td> -->
	</tr>	
	</c:forEach>	
	
	</c:when>
	</c:choose>
	</tbody>			
	</table>	

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