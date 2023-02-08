<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<title>个人中心</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<link type="text/css" rel="stylesheet" href="css/bootstrap.css">
	<link type="text/css" rel="stylesheet" href="css/style.css">
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
</head>
<body>

	<!--header-->
	<jsp:include page="/common/header.jsp">
		<jsp:param name="flag" value="4"/>
	</jsp:include>
	<!--//header-->

	<!--account-->
	<div class="account">
		<div class="container">
			<div class="register">
				<c:if test="${!empty message}">
					<div class="alert alert-success">${message}</div>
				</c:if>
				<c:if test="${!empty fMessage}">
					<div class="alert alert-danger">${fMessage}</div>
				</c:if>

					<div class="register-top-grid">
						<h3>个人中心</h3>
						<form action="${pageContext.request.contextPath}/user_changeaddress" method="post">
						<!--收货信息 begin-->
						<h4>收货信息</h4>
						<div class="input">
							<span>收货人<label></label></span>
							<input type="text" name="name" value="${user.name}" placeholder="请输入收货">
						</div>
						<div class="input">
							<span>收货电话</span>
							<input type="text" name="phone" value="${user.phone}" placeholder="请输入收货电话">
						</div>
						<div class="input">
							<span>收货地址</span>
							<input type="text" name="address" value="${user.address}" placeholder="请输入收货地址">
						</div>
						<div class="register-but text-center">
						   <input type="submit" value="提交">
						</div>
						</form>
						<!--收货信息end-->

						<hr>

						<form action="${pageContext.request.contextPath}/user_changepwd" method="post">
						<h4>安全信息</h4>
						<div class="input">
							<span>原密码</span>
							<input type="text" name="password" placeholder="请输入原密码">
						</div>
						<div class="input">
							<span>新密码</span>
							<input type="text" name="newPassword" placeholder="请输入新密码">
						</div>
						<div class="clearfix"> </div>
						<div class="register-but text-center">
						   <input type="submit" value="提交">
						</div>
						</form>
					</div>
				<div class="clearfix"> </div>
			</div>
	    </div>
	</div>
	<!--//account-->

	<!--footer-->
	<jsp:include page="/common/footer.jsp"></jsp:include>
	<!--//footer-->

</body>
</html>