<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript"  src="js/cookie-util.js"></script>
<script type="text/javascript" >
function loginOut(){
	//清除cookie购物车
	Cookie.delCookie('cart');
	//请求到后台注销
	window.location.href="${pageContext.request.contextPath}/user/loginOut.do";
}
</script>
<div class="container header">
	<div class="span5">
		<div class="logo">
			<a href="page/front/index.jsp"> <img
				src="image/r___________renleipic_01/logo.png" alt="尚学堂" />
			</a>
		</div>
	</div>
	<div class="span9">
		<div class="headerAd">
			<img src="image/header.jpg" width="320" height="50" alt="正品保障"
				title="正品保障" />
		</div>
	</div>
	<div class="span10 last">
		<div class="topNav clearfix">
			<ul>
				<c:if test="${curUser==null}">
					<li id="headerLogin" class="headerLogin"
						style="display: list-item;"><a href="page/front/login.jsp">登录</a>|</li>
					<li id="headerLogin" class="headerLogin"
						style="display: list-item;"><a href="page/back/login.jsp">客服登录</a>|</li>
					<li id="headerRegister" class="headerRegister"
						style="display: list-item;"><a href="####">注册</a>|
					</li>
				</c:if>
				<c:if test="${curUser!=null}">
					<li id="headerLogin" class="headerLogin"
						style="display: list-item;"> ${curUser.userName}|</li>
					<li id="headerLogin" class="headerLogin"
						style="display: list-item;"><a
						href="order/query.do">我的订单</a> |</li>
					<li id="headerRegister" class="headerRegister"
						style="display: list-item;">
						<a href="javascript:void(0)" onclick="loginOut();" >退出</a>
					</li>

				</c:if>

				<li><a>会员中心</a> |</li>
				<li><a>购物指南</a> |</li>
				<li><a>关于我们</a> |</li>
				<!-- <li>[欢迎你：]</li> -->
			</ul>
		</div>
		<div class="cart">
			<a href="cart/query.do">购物车</a>
		</div>
		<div class="phone">
			尚学堂客服热线: <strong>028-65176856</strong>
		</div>
	</div>
	
	<form action="" style="font-size: 18px;">
		商品名<input  style="border:0;"/>
		价格最大值<input  style="border:0;" />
		<button  style="border:0;font-size: 18px;">商品搜索</button>
	</form>
	<div class="span24">
		<ul class="mainNav">
			<li><a href="index/query.do">首页</a> |</li>
			<c:forEach var="cat" items="${catList}">
					<li><a href="####">${cat.cname }</a>
					|</li>
			</c:forEach>
		</ul>
	</div>
</div>
<hr width="60%">