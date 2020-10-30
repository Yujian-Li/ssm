<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>Edit Company Info</title>
	<%
    	String path = request.getContextPath();
	    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
    %>
	<c:set var="path" value="<%=basePath %>"></c:set>
 	<link href="${path }/css/bootstrap/bootstrap.min.css" rel="stylesheet" />
 	<link rel="stylesheet" type="text/css" href="${path }/js/zeroModal/zeroModal.css" />
 	<link href="${path }/js/bootstrap-select/bootstrap-select.min.css" rel="stylesheet" />
 	<link rel="stylesheet" type="text/css" href="${path }/js/zeroModal/zeroModal.css" />
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
				<div class="col-md-12 column"> <!-- ###########action不确定填什么 -->
					<form class="form-horizontal" role="form" id="enterpriseAction" action="enterprise" method="post">
						<c:if test="${enterprise.enterpriseId != null }">
							<div class="form-group">
								 <label for="enterpriseId" class="col-sm-2 control-label">Company ID</label>
								 <div class="col-sm-3">
								 	<input class="form-control" id="enterpriseId" name="enterpriseId" type="text" value="${enterprise.enterpriseId }" readonly="readonly" unselectable='on' onfocus='this.blur()' />
								 </div>
								 	<input type="hidden" value="1" name="isupdate" id="isupdate" class="form-control" />
							</div>
						</c:if>
						
						<div class="form-group">
							 <label for="enterpriseName" class="col-sm-2 control-label">Name</label>
							<div class="col-sm-5">
								<input class="form-control" id="enterpriseName" name="enterpriseName" type="text" value="${enterprise.enterpriseName }" placeholder="名称" />
							</div>
						</div>
						<div class="form-group">
							 <label for="enterpriseSpec" class="col-sm-2 control-label">Introduction</label>
							<div class="col-sm-5">
								<input class="form-control" id="enterpriseSpec" name="enterpriseSpec" type="text" value="${enterprise.enterpriseSpec }" placeholder="简介" />
							</div>
						</div>
						<div class="form-group">
							 <label for="enterpriseAccount" class="col-sm-2 control-label">Account</label>
							<div class="col-sm-5">
								<input class="form-control" id="enterpriseAccount" name="enterpriseAccount" type="text" value="${enterprise.enterpriseAccount }" readonly="readonly" unselectable="on" onfocus="this.blur()" placeholder="登录账户" />
							</div>
						</div>
						<div class="form-group">
							 <label for="enterprisePwd" class="col-sm-2 control-label">Password</label>
							<div class="col-sm-5">
								<input class="form-control" id="enterprisePwd" name="enterprisePwd" type="password" value="${enterprise.enterprisePwd }" placeholder="登录密码" />
							</div>
						</div>
						<br />
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-4">
			  				     <button id="sub" uUrl="enterprise" aUrl="enterprise/enterprise" type="button" class="btn btn-default btn-lg btn-block">
							 		submit <!-- #########uUrl和aUrl不确定填什么 -->
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