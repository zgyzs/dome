<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<!-- 基本页面-元信息 -->
<%@ include file="common-base.jsp"%>
<link href="css/product.css" rel="stylesheet" type="text/css" />
<script src="js/cookie-util.js" type="text/javascript"></script>
<script src="js/cart.js" type="text/javascript"></script>

</head>
<body>
	<!-- 头部页面 -->
	<%@ include file="common-header.jsp"%>

	<div class="container productContent">
		<div class="span6">
			<div class="hotProductCategory">
				<c:forEach var="cat" items="${catList}">
					<dl>
						<dt>
							<a href="####">${cat.cname }</a>
						</dt>
						<c:forEach items="${cat.listCs}" var="catSe">
							<dd>
								<a href="####">${catSe.csname }</a>
							</dd>
						</c:forEach>
					</dl>
				</c:forEach>
			</div>
		</div>
		<div class="span18 last">
			<div class="productImage">
				<a title="" style="outline-style: none; text-decoration: none;"
					id="zoom"
					href="image/r___________renleipic_01/bigPic1ea8f1c9-8b8e-4262-8ca9-690912434692.jpg"
					rel="gallery">
					<div class="zoomPad">
						<img id="img"style="opacity: 1;" class="medium"
							src="products/${curProduct.image}" />
						<div
							style="display: block; top: 0px; left: 162px; width: 0px; height: 0px; position: absolute; border-width: 1px;"
							class="zoomPup"></div>
						<div
							style="position: absolute; z-index: 5001; left: 312px; top: 0px; display: block;"
							class="zoomWindow">
							<div style="width: 368px;" class="zoomWrapper">
								<div style="width: 100%; position: absolute; display: none;"
									class="zoomWrapperTitle"></div>
								<div style="width: 0%; height: 0px;" class="zoomWrapperImage">
									<img src=""
										style="position: absolute; border: 0px none; display: block; left: -432px; top: 0px;" />
								</div>
							</div>
						</div>
						<div
							style="visibility: hidden; top: 129.5px; left: 106px; position: absolute;"
							class="zoomPreload">Loading zoom</div>
					</div>
				</a>

			</div>
			<div class="name" id="pname">${curProduct.pname}</div>
			<div class="sn">
				<div id="pid" weqw="${curProduct.pid}">编号： ${curProduct.pid}</div>
			</div>
			<div class="info">
				<dl>
					<dt>商城价:</dt>
					<dd>
						<strong id="money" money="${curProduct.shopPrice}">￥：${curProduct.shopPrice}元 </strong> 参 考 价：
						<del> ￥ ${curProduct.marketPrice} 元 </del>
					</dd>
				</dl>
				<dl>
					<dt>促销:</dt>
					<dd>
						<a target="_blank" title="限时抢购 (2014-07-30 ~ 2015-01-01)">限时抢购</a>
					</dd>
				</dl>
			</div>
			<form id="cartForm" method="post">
				<input type="hidden" name="pid" value="${curProduct.pid}" />
				<div class="action">
					<dl class="quantity">
						<dt>购买数量:</dt>
						<dd>
							<input id="pcount" value="1" maxlength="4"
								onpaste="return false;" type="text" />
						</dd>
						<dd>件</dd>
					</dl>
					<div class="buy">
						<input id="addCart" class="addCart" value="加入购物车" type="button"
						 /> <br> <input class="addCart"
							value="购物车结算" type="button" id="selectCart" />
						<!-- <input id="buyProduct" class="addCart" value="立即购买" type="button"
						onclick="buyProduct();" /> -->
					</div>
				</div>
			</form>
			<div id="bar" class="bar">
				<ul>
					<li id="introductionTab"><a href="#introduction">商品介绍</a></li>

				</ul>
			</div>

			<div id="introduction" class="introduction">
				<div class="title">
					<strong>${curProduct.pdesc}</strong>
				</div>
				<c:forEach items="${curProduct.listImage}" var="img">
					<div style="text-align: center">
						<img src="products/${img}" />
					</div>
					<br />
				</c:forEach>
			</div>
		</div>
	</div>
	<!-- 底部页面 -->
	<%@ include file="common-footer.jsp"%>

</body>
</html>
<script type="text/javascript" src="/js/cookie-util.js"></script>

<script>
    $(function(){
        $("#addCart").on("click",function(){
        	//拿到当前页面的信息
          	var pid = $("#pid").attr("weqw");	
			var image = $("#img").attr("src");
			var pname=$("#pname").text();	
			var pcount=$("#pcount").val();	
			var pprice=$("#money").attr("money");
			var shopping={
        		"pid":pid,
        		"image":image,
        		"pname":pname,
        		"pcount":pcount,
        		"pprice":pprice
        	};
			//拿到登陆后返回的Cookie信息
			var disembarkCookie=Cookie.getCookie("disembark")
			//用登陆后返回的Cookie信息来判断是否登陆
			if(disembarkCookie==null){
			//未登陆时处理的方式
        	var CookieValue=Cookie.getCookie("name")
        	
		 	
		    if(CookieValue==null){
		    	var order =[];
		    	order.push(shopping);
				var orderString=JSON.stringify(order);
				Cookie.setCookie("name",encodeURIComponent(orderString))			
			}else { 
				var arrorder=JSON.parse(decodeURIComponent(CookieValue))
				var j=0;
				for(var i=0;i<arrorder.length;i++){
					if(arrorder[i].pid==pid){
						arrorder[i].pcount=parseInt(arrorder[i].pcount)+parseInt(pcount)
						j++
					}
					
				}
				if(!j){
					arrorder.push(shopping)
				}
				var orderString=JSON.stringify(arrorder);
				Cookie.setCookie("name",encodeURIComponent(orderString))	
			}
			//登陆后处理的方式
        	}else{
        		var order =[];
        		order.push(shopping);
        		 $.ajax({ 
              	     type : "POST", //提交方式 
              	     url : "${pageContext.request.contextPath}/redis/updateRedis.do",//路径
              	   	contentType: 'application/json',
                   	dateType:'json',
              	     data :JSON.stringify(order)
           			,//数据，这里使用的是Json格式进行传输 
              	     success : function(result) {//返回数据根据结果进行相应的处理 
              	    	 alert(result)
              	 
              	     } 
            	 
            })
        		
        	}
        })
	/**
		结算购物车
		b）跳转到购物车界面
	 */
	 $("#selectCart").on("click",function(){
		//跳转到购物车页面
		window.location.href = "${pageContext.request.contextPath}/cart/query.do";
	});
        
  })
	

</script>

