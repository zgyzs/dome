<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- saved from url=(0043)http://localhost:8080/mango/cart/list.jhtml -->
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@ include file="common-base.jsp"%>
<link href="css/cart.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<%@ include file="common-header.jsp"%>
	<div class="container cart">
		<div class="span24">
			<div class="step step1 "
				style="color: green; font-size: 20pt; font-weight: bold;">
				【我的订单列表】</div>
			<table style="font-size:13px">
				<tbody>
					<tr >
						<th>订单号</th>
						<th>总价</th>
						<th>下单时间</th>
						<th>收货人地址</th>
						<th>收货人名字</th>
						<th>收货人手机</th>
						<th>物流公司</th>
						<th>物流单号</th>
						<th>订单状态</th>
					</tr>
					<c:forEach items="${orderList}" var="order">
						<tr >
							<td>${order.oid}</td>
							<td>${order.sumPrice}</td>
							<td>${order.orderTime}</td>
							<td>${order.addr}</td>
							<td>${order.name}</td>
<%-- 							<td>${order.logistics_comp}</td>
							<td>${order.logistics_num}</td> --%>
							<td class='green' >${order.state}</td>
							<td>
								<c:if test="${order.state=='未付款'}">
								<!-- 这里直接传付款金额给后台不安全，应该后台根据订单号取出！！！ -->
								<a  class="red button" href="order/pay.do?orderId=${order.oid}&sumPrice=${order.sumPrice}">付款</a>
								</c:if>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			
		</div>
	</div>
	<%@ include file="common-footer.jsp"%>
</body>
</html>