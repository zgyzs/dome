<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- saved from url=(0043)http://localhost:8080/mango/cart/list.jhtml -->
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<%@ include file="common-base.jsp"%>
	<link href="css/cart.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" >
	
	</script>
</head>
<body>
<%@ include file="common-header.jsp"%>

<div class="container cart">
		<div class="span24">
				<div class="step step1" style="color: green;font-size: 20pt;font-weight: bold;">
				请确认【收货信息】和【支付方式】
				</div>
				<table>
					<tbody>
					<tr>
						<th>图片</th>
						<th>商品</th>
						<th>价格</th>
						<th>数量</th>
						<th>小计</th>
					</tr>
					<c:forEach items="${strToList}" var="cp">
							<tr>
								<td width="60"><img src="products/${cp.image}" /></td>
								<td><a target="_blank">${cp.pname}</a></td>
								<td>￥ ${cp.pprice}元</td>
								<td>${cp.pcount}</td>
								<td width="140"><span class="subtotal">￥${cp.pprice*cp.pcount}元</span></td>
							</tr>
					</c:forEach> 
				</tbody>
			</table>
				<dl id="giftItems" class="hidden" style="display: none;">
				</dl>
				<div class="total">
					<em id="promotion"></em>
					商品类别数量: <strong id="countProCate">${statisInfo.countCate}类</strong>;
					商品数量: <strong id="countPro" >${statisInfo.countPcount}个</strong>;
					商品总价: <strong id="sumPrice">${statisInfo.countPrice}元</strong>
				</div>
			<form id="orderForm" action="${pageContext.request.contextPath }/order/commitOrder.do" method="post">
				<!-- 隐藏域=提交购买的商品列表 -->
				
				<div class="span24">
						<p  style="border-color:red;">
						请选择收货人信息：
						<select id="consignee" name="receiveUserInfoId" style="font-size: 14pt;font-weight: bold;">
							<c:forEach items="${listReceiveUser}" var="rui">
									<option value="${rui.id}">
										地址：${rui.addr}&nbsp;联系人：${rui.name}&nbsp;手机：${rui.phone}
									</option>
								</c:forEach> 
						</select>
						</p>
						<hr />
						<p>
							选择支付方式：<br/>
							<p  style="border-color:red;">
							<input type="radio" name="payType" value="zhifubao" checked="checked" />支付宝
							<img src="http://s.banggo.com/pub7/images/mbshop/veoimg/pay_alipay.gif"/>
							<input type="radio" name="payType" value="weixin" />微信
							<img src="http://s.banggo.com/pub7/images/mbshop/veoimg/pay_wxpay.png"/>
							</p>
						</p>
						<hr />
						<p style="text-align:right">
							<a  href="javascript:void(0)" id="submitOrder">
								<img src="${pageContext.request.contextPath}/images/finalbutton.gif" width="204" height="51" border="0" />
							</a>
						</p>
				</div>
			</form>
		</div>
	</div>
	<%@ include file="common-footer.jsp"%>
</body>
</html>
<script src="https://cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
<script>
	$(function(){
		$("#submitOrder").on("click",function(){
		//获取选中的项
		var options=$("#consignee option:selected"); 
		//拿到选中项的值
		var id=options.val(); 
		 	window.location.href ="${pageContext.request.contextPath}/order/createOrderandProduct.do?id="+id; 	
			
		})
	})


</script>




	