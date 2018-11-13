<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	/**
	如果当前页面没有数据-那么转发到控制器查看数据
	 */
	 if (request.getAttribute("hotProList") == null) {
			//转发
			request.getRequestDispatcher("/index/query.do").forward(
					request, response);
	}
%>
<html>
<head>
<!-- 基本页面-元信息 -->
<%@ include file="common-base.jsp"%>


</head>
<body>
	
	<!-- 头部页面 -->
	<%@ include file="common-header.jsp"%>
	
	<!-- 中间页面 -->
	<div class="container index">
		
	
		<div class="span24">
		<!-- qq聊天 -->
		<a target="_blank" href="http://wpa.qq.com/msgrd?v=3&uin=2048765920&site=qq&menu=yes"><img border="0" src="http://wpa.qq.com/pa?p=2:2048765920:53" alt="买东西，请咨询我" title="买东西，请咨询我"/></a>
		
			<div id="hotProduct" class="hotProduct clearfix">
				<div class="title">
					<strong>热门商品</strong>
					<!-- <a  target="_blank"></a> -->
				</div>
				<ul class="tab">
					<li class="current"><a href="./蔬菜分类.htm?tagIds=1"
						target="_blank"></a></li>
					<li><a target="_blank"></a></li>
					<li><a target="_blank"></a></li>
				</ul>
				<ul class="tabContent" style="display: block;">
					<c:forEach var="hotPro" items="${hotProList}">
							
							<li>
								<a href="product/selectById.do?pid=${hotPro.pid}" >
								<img src="products/${hotPro.image}" style="display: block;" />
								<strong  style="color: #ef0101;">￥：${hotPro.shopPrice}元 </strong><br/>
								<strong>${hotPro.pname} </strong><br/>
								</a>
							</li>
					</c:forEach>
				</ul>
				<ul class="tabContent" style="display: none;">

				</ul>
			</div>
		</div>
		<div class="span24">
			<div id="newProduct" class="newProduct clearfix">
				<div class="title">
					<strong>最新商品</strong> <a target="_blank"></a>
				</div>
				<ul class="tab">
					<li class="current"><a href="./蔬菜分类.htm?tagIds=2"
						target="_blank"></a></li>
					<li><a target="_blank"></a></li>
					<li><a target="_blank"></a></li>
				</ul>
				<ul class="tabContent" style="display: block;">
					<c:forEach var="newPro" items="${newProList}">
							<li>
								<a href="product/selectById.do?pid=${newPro.pid}" >
								<img src="products/${newPro.image}" style="display: block;" />
								<strong style="color: #ef0101;">￥：${newPro.shopPrice}元 </strong><br/>
								<strong>${newPro.pname} </strong><br/>
								</a>
							</li>
					</c:forEach>
				</ul>
				<ul class="tabContent" style="display: none;">

				</ul>
			</div>
		</div>
		
	</div>
	<!-- 底部页面  -->
	<%@ include file="common-footer.jsp"%>
</body>
</html>