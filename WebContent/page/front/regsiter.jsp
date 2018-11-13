<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<!-- 基本页面-元信息 -->
<%@ include file="common-base.jsp"%>
<link href="css/login.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<!-- 头部页面 -->
	<%@ include file="common-header.jsp"%>
	<br>
	<div class="container login">
		<div class="span12">
			<div class="ad">
				<img src="${pageContext.request.contextPath}/image/login.jpg"
					width="500" height="330" alt="会员注册" title="会员注册">
			</div>
		</div>
		<div class="span12 last">
			<div class="wrap">
				<div class="main">
					<div class="title">
						<strong>会员注册</strong>USER LOGIN
					</div>
					<div></div>
					<form id="regsiterForm"
						action="user/regsiter.do"
						method="post" novalidate="novalidate">
						<table>
							<tbody>
								<tr>
									<th>用户账号:</th>
									<td><input type="text" id="username" name="username"
										class="text" maxlength="20" /></td>
								</tr>
								<tr>
									<th>密&nbsp;&nbsp;码:</th>
									<td><input type="password" id="password" name="password"
										class="text" maxlength="20" autocomplete="off" /></td>
								</tr>
								<tr>
									<th>昵称:</th>
									<td><input type="text" id="name" name="name"
										class="text" maxlength="20" /></td>
								</tr>
								<tr>
									<th>手机号:</th>
									<td><input type="text" id="security_phone" name="security_phone"
										class="text" maxlength="20" /></td>
								</tr>
								<tr>
									<th>邮箱:</th>
									<td><input type="text" id="security_email 	" name="security_email"
										class="text" maxlength="20" /></td>
								</tr>
								
								<tr>
									<th>&nbsp;</th>
									<td><input type="submit" class="submit" value="注 册" />
									<input type="reset" class="submit" value="重置" /></td>
								</tr>
								
							</tbody>
						</table>
					</form>
				</div>
			</div>
		</div>
	</div>
	<!-- 底部页面  -->
	<%@ include file="common-footer.jsp"%>
</body>
</html>