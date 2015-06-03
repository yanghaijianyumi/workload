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
<title>录入课程信息</title>
<link rel="shortcut icon" href="/images/icon.jpg" type="image/x-icon" />
<link rel="stylesheet" href="/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/common.css">
</head>
<body>
	<jsp:include page="../../common/navbar.jsp"></jsp:include>
	<jsp:include page="../common/header.jsp"></jsp:include>
	<div class="container-fluid">
		<div class="row-fluid">
			<div class="col-md-2">
				<!-- sidebar start -->
				<jsp:include page="../common/sidebar.jsp"></jsp:include>
			</div>
			<!-- main-content start  -->
			<div class="col-md-10">
				<jsp:include page="ccontent.jsp"></jsp:include>
			</div>
			<!-- main-content end -->
		</div>
		<!--rw1  -->
	</div>
	<!--<div class="container-fluid">  -->
	<jsp:include page="../common/footer.jsp"></jsp:include>

	<script src="/js/jquery.js"></script>
	<script src="/js/bootstrap.min.js"></script>
	<script src="/js/jquery.form.js"></script>
	<script src="/js/ajaxAction.js"></script>
	<script src="/js/tcommon.js"></script>
	<script src="/js/tccourseDesign.js"></script>
</body>
</html>