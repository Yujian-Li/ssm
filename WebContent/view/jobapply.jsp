<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>Apply Jobs</title>
	<%
    	String path = request.getContextPath();
	    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
    %>
	<c:set var="path" value="<%=basePath %>"></c:set>
 	<link href="${path }/css/bootstrap/bootstrap.min.css" rel="stylesheet" />
 	<link rel="stylesheet" type="text/css" href="${path }/js/zeroModal/zeroModal.css" />
 	<link href="${path }/js/bootstrap-select/bootstrap-select.min.css" rel="stylesheet" />

 	<style type="text/css">
 		.dropdown-toggle {
 			height: 30px;
 		}
 	</style>
</head>
<body>
	<div>
		<div class="container">
			<div class="row clearfix">
				<div class="col-md-12 column">
					<form class="form-horizontal" role="form" id="applicationAction" action="job" method="post">
						<c:if test="${jobId != null }">
							<div class="form-group">
								 <label for="jobId" class="col-sm-2 control-label">Job ID</label>
								 <div class="col-sm-3">
								 	<input class="form-control" id="jobId" name="jobId" type="text" value="${jobId}" readonly="readonly" unselectable='on' onfocus='this.blur()' />
								 </div>
								 	<input type="hidden" value="1" name="isupdate" id="isupdate" class="form-control" />
							</div>
						</c:if>
						
						<div class="form-group">
							 <label for="applicantId" class="col-sm-2 control-label">Enter Applicant ID</label>
							<div class="col-sm-5">
								<input class="form-control" id="applicantId" name="applicantId" type="text" value="" placeholder="申请人ID" />
							</div>
						</div>
						
						<br />
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-4">
			  				     <button id="sub" uUrl="job" aUrl="job/job" type="button" class="btn btn-default btn-lg btn-block">
							 		Submit <!-- #########uUrl和aUrl-->
								 </button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<!-- js引入 -->
    <script src="${path }/js/jquery.js"></script>
    <script src="${path }/js/bootstrap/bootstrap.min.js"></script>
    <script src="${path }/js/zeroModal/zeroModal.min.js"></script>
    <script src="${path }/js/add-update.js"></script>
    <script src="${path }/js/bootstrap-select/bootstrap-select.min.js"></script>

</body>
</html>