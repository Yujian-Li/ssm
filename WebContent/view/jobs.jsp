<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sportsjobs" uri="hhhh"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()+ path;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<c:set var="path" value="<%=basePath %>"></c:set>

<title>Jobs</title>

<link rel="stylesheet" type="text/css" href="${path }/js/zeroModal/zeroModal.css" />

<!-- Bootstrap Core CSS -->
<link href="${path }/css/bootstrap/bootstrap.min.css" rel="stylesheet" />

<!-- MetisMenu CSS -->
<link href="${path }/css/metisMenu.min.css" rel="stylesheet" />

<!-- DataTables CSS -->
<link href="${path }/css/dataTables.bootstrap.css" rel="stylesheet" />

<!-- Custom CSS -->
<link href="${path }/css/admin.css" rel="stylesheet" />

<!-- Custom Fonts -->
<link href="${path }/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
<link href="${path }/css/boot-crm.css" rel="stylesheet"	type="text/css" />

</head>

<body>

	<div id="wrapper">

		<div id="page-wrapper">
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">Jobs</h1>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- /.row -->
			<div class="panel panel-default">
				<div class="panel-body">
					<form class="form-inline" action="${pageContext.request.contextPath }/jobs/list.action" method="get">
						<div class="form-group">
							<label for="jobSpec">Job Spec</label> 
							<input type="text" class="form-control" id="jobSpec" value="${jobSpec }" name="jobSpec"/>
						</div>
						<div class="form-group">
							<label for="jobType" style="float:left;padding:7px 15px 0 27px;">Category</label> 
							<select	class="form-control" id="jobType" placeholder="类别" name="jobType">
								<option value="">--Select--</option>
								<c:forEach items="${jobTypee}" var="item">
									<option value="${item.dict_id}"<c:if test="${item.dict_id == jobType}"> selected</c:if>>${item.dict_item_name }</option>
								</c:forEach>
							</select>
						</div>
						<div class="form-group">
							<label for="location" style="float:left;padding:7px 15px 0 27px;">Location</label> 
							<select	class="form-control" id="location" placeholder="地点" name="location">
								<option value="">--Select--</option>
								<c:forEach items="${locationTypee}" var="item">
									<option value="${item.dict_id}"<c:if test="${item.dict_id == location}"> selected</c:if>>${item.dict_item_name }</option>
								</c:forEach>
							</select>
						</div>
						<div class="form-group">
							<label for="monthlySalary" style="float:left;padding:7px 15px 0 27px;">Salary</label>
							<select	class="form-control" id="monthlySalary" name="monthlySalary">
								<option value="">--Select--</option>
								<c:forEach items="${salaryTypee}" var="item">
									<option value="${item.dict_id}"<c:if test="${item.dict_id == monthlySalary}"> selected</c:if>>${item.dict_item_name }</option>
								</c:forEach>
							</select>	
						</div>						
						
						<button type="submit" class="btn btn-primary">Search</button>
					</form>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-default">
						<div class="panel-heading">Jobs</div>
						<!-- /.panel-heading -->
						<table class="table table-bordered table-striped">
							<thead>
								<tr>
									<th>ID</th>
									<th>Job Spec</th>
									<th>Category</th>
									<th>Location</th>
									<th>Salary</th>
									<th>Contact</th>
									<th>Company Info</th>
									<th>Options</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${page.rows}" var="row">
									<tr>
										<td>${row.jobId}</td>
										<td>${row.jobSpec}</td>
										<td>${row.jobType}</td>
										<td>${row.location}</td>
										<td>${row.monthlySalary}</td>
										<td>${row.contact}</td>
										<%-- <td>${row.enterpriseSpec}</td> --%>
										
										<td>
											<a href="#" class="btn btn-primary btn-xs">Show</a>
							
										</td>
										<td>
											<div class="btn-group">
											<button type="button" onclick="_iframe(0, 'job/${row.jobId }', 'job')" class="btn btn-primary btn-xs">Apply</button>
											</div>
										</td>
									</tr>
								</c:forEach>
							</tbody>
							
						</table>
						<div class="col-md-12 text-right">
							<sportsjobs:page url="${pageContext.request.contextPath }/jobs/list.action" />
						</div>

						<!-- /.panel-body -->
					</div>
					<!-- /.panel -->
				</div>
				<!-- /.col-lg-12 -->
			</div>
		</div>
		<!-- /#page-wrapper -->

	</div>
	<!-- /#wrapper -->

	<!-- jQuery -->
	<script src="${path }/js/jquery.min.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="${path }/js/bootstrap/bootstrap.min.js"></script>

	<!-- Metis Menu Plugin JavaScript -->
	<script src="${path }/js/metisMenu.min.js"></script>

	<!-- DataTables JavaScript -->
	<script src="${path }/js/jquery.dataTables.min.js"></script>
	<script src="${path }/js/dataTables.bootstrap.min.js"></script>

	<!-- Custom Theme JavaScript -->
	<script src="${path }/js/sb-admin-2.js"></script>
	
	<script src="${path }/js/handle.js"></script>
	
	
	<!-- js引入 -->
    <script src="${path }/js/jquery.js"></script>
    <script src="${path }/js/handle.js"></script>
    <script src="${path }/js/zeroModal/zeroModal.min.js"></script>
    <script src="${path }/js/add-update.js"></script>

</body>

</html>
