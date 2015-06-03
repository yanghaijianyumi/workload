<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path;
%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>学院管理员主页</title>
<link rel="shortcut icon" href="/images/icon.jpg" type="image/x-icon" />
<link rel="stylesheet" href="/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/common.css">
</head>
<body>
	<jsp:include page="../common/navbar.jsp"></jsp:include>
	<jsp:include page="common/header.jsp"></jsp:include>
	<div class="container-fluid">
		<div class="row-fluid">
			<!-- sidebar start -->
			<div class="col-md-2">
				<jsp:include page="common/sidebar.jsp"></jsp:include>
			</div>
			<!-- sidebar end -->
			<!-- main-content start  -->
			<div class="col-md-10">
				<div class="container-fluid" id="main-content"></div>
			</div>
			<!-- main-content end -->
		</div>
		<!--rw1  -->
	</div>
	<!--<div class="container-fluid">  -->
	<jsp:include page="common/footer.jsp"></jsp:include>

	<script src="/js/jquery.js"></script>
	<script src="/js/bootstrap.min.js"></script>
	<script src="/js/ajaxAction.js"></script>
</body>
</html>