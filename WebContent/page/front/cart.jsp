<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<%@ include file="common-base.jsp"%>
	<link href="css/cart.css" rel="stylesheet" type="text/css" />
	
</head>
<body>

	<%@ include file="common-header.jsp"%>
	<div class="container cart">
			<div class="span24">
				<div class="step step1" style="color: green;font-size: 20pt;font-weight: bold;">
				购物车信息
				</div>
				<div class="step step1" style="color: red;font-size: 20pt;font-weight: bold;">
				(提交订单：请加入商品多选功能，把选择的商品提交订单)
				</div>
				<table>
					<tbody>
						<tr>
							<th>图片</th>
							<th>商品</th>
							<th>价格</th>
							<th>数量</th>
							<th>小计</th>
							<th>操作</th>
							<th>结算</th>
						</tr>
						<c:forEach items="${strToList}" var="cp">
							<tr>
								<td width="60"><img src="${cp.image}" /></td>
								<td><a target="_blank">${cp.pname}</a></td>
								<td name='pprice' value='${cp.pprice}'>￥ ${cp.pprice}元</td>
								<td class="quantity" width="60">
								<input  value="${cp.pcount}" name='pcount' id="${cp.pid}" />
								</td>
								<td width="140"><span class="subtotal" >￥${cp.pprice*cp.pcount}元</span></td>
								<td><a href="javascript:void(0)" name="deleteCart" id="${cp.pid}" class="delete">删除</a></td>
								<td>
									<input type="checkbox" checked="checked" 
									value="${cp.pid}"  name="buyPids" 
									>
								</td>
							</tr>
							</c:forEach>
					</tbody>
				</table>
				<dl id="giftItems" class="hidden" style="display: none;">
				</dl>
				<div class="total" >
					<em style="font-size: 16pt;font-weight: bold;"> 【已经选中商品的下单统计】 </em> 
						商品类别数量: <strong id="countProCate">${statisInfo.countCate}类</strong>;
					商品数量: <strong id="countPro" >${statisInfo.countPcount}个</strong>;
					商品总价: <strong id="sumPrice">${statisInfo.countPrice}元</strong>
				<div class="bottom">
						<a href="####"  class="clear">清空购物车</a> 
					
						<a href="javascript:void(0)" class="submit" id="accountShopping">结算购物车</a>
				</div>

			</div>
			<div class="span24">
				<div class="step step1">
					<span> <h2>亲!您还没有购物!请先去购物!</h2></span>
				</div>
			</div>
	</div>
	
	<%@ include file="common-footer.jsp"%>
</body>
</html>
<script type="text/javascript" src="/js/cookie-util.js"></script>
<script>


$(function(){
	
	var CookieValue=Cookie.getCookie("name")
	var disembark=Cookie.getCookie("disembark")
	computerPrice()
	//登陆时候页面更新商品数量，类型，总价的方法
	function updateData(){
   	 //总价
	    	var amount=0;
			//类别
			var arrorderLength=0;
			//数量
			var quantity=0;
			var buyPids=$("input[name='buyPids']")
			for(var i=0;i<buyPids.length;i++){
			if(buyPids[i].checked){
				var tds =$(buyPids[i]).parent().parent().children("td")
				//当前的数量
				var pcount=parseInt($(tds[3]).children("input").val())
				//当前的单价
				var pprice=parseInt($(tds[2]).attr("value"))
				$(tds[4]).text("￥"+pcount*pprice+"元")
				arrorderLength++
				amount=amount+pcount*pprice
				quantity=quantity+pcount
			}
		}
		//数量
		 $("#countPro").text(quantity)
		//类别
		$("#countProCate").text(arrorderLength)
		//总价
		$("#sumPrice").text(amount) 
		
	}
	//未登陆时候页面更新商品数量，类型，总价的方法
	function computerPrice(){
		//拿到Cookie
		if(disembark==null&&CookieValue!=null){
		//把cookie解码并转为数组
		var arrorder=JSON.parse(decodeURIComponent(CookieValue))
		//拿数组里面有多少个元素判断有几个类型
		var arrorderLength=0;
		//遍历cookie拿他的数量全部加入quantity中就是商品的总数量
		//再通过每个数量乘以他价格拿到商品总价
		var quantity =0;
		//总价
		var amount=0;
		for(var i=0;i<arrorder.length;i++){
			//拿出每个的数量
			var pcountNum =parseInt(arrorder[i].pcount)
			//每个的单价
			var ppriceNum =parseInt(arrorder[i].pprice)
			amount=amount+ppriceNum*pcountNum
			quantity=quantity+parseInt(pcountNum)	
			arrorderLength++
		}
		
		$("#countPro").text(quantity)
		$("#sumPrice").text(amount)
		$("#countProCate").text(arrorderLength)
		}
	}
	//拿出所有选中的复选框拿出他的值
 	$("input[name='buyPids']").on("click",function(){
 		//总价
		var amount=0;
		//类别
		var arrorderLength=0;
		//数量
		var quantity=0;
		var pids=[]
		var buyPids=$("input[name='buyPids']")
		for(var i=0;i<buyPids.length;i++){
			if(buyPids[i].checked){
				arrorderLength++;
				var pid=$(buyPids[i]).val()
				pids.push(pid)
			}
		}
			//如果登陆disembark有值说明登陆那么name就没值了
			if(disembark==null&&CookieValue!=null){
			//把cookie解码并转为数组
			var arrorder=JSON.parse(decodeURIComponent(CookieValue))
			//再通过每个数量乘以他价格拿到商品总价
			for(var i=0;i<arrorder.length;i++){ 
				if(pids.indexOf(arrorder[i].pid)!=-1){
				var pcountNum =parseInt(arrorder[i].pcount)
				var ppriceNum =parseInt(arrorder[i].pprice)
				amount=amount+ppriceNum*pcountNum
				quantity=quantity+parseInt(pcountNum)	
			
				}
			}
			$("#countPro").text(quantity)
			$("#sumPrice").text(amount)
			$("#countProCate").text(arrorderLength)
			}else{
				/* var tds =$(this).parent().parent().children("td") */
				updateData();
			}
		
	}) 
	
	
	//
    $("a[name='deleteCart']").on("click",function(){
    	var CookieValue=Cookie.getCookie("name")
    	var disembark=Cookie.getCookie("disembark")
        var pid=$(this).prop("id")
        var tr = $(this).parent().parent("tr")
        //未登陆时候的删除
     	if(disembark==null&&CookieValue!=null){
       	 	var arrorder=JSON.parse(decodeURIComponent(CookieValue))
       	 /*   		debugger; */
       	 		for(var i=0;i<arrorder.length;i++){
       	 			if(arrorder[i].pid==pid){
       	 				arrorder.splice(i,1);
       	 				
       	 			}
       	 			
       	 		}
       			//转换为字符串
       	         var orderString=JSON.stringify(arrorder);
       	 		Cookie.setCookie("name",encodeURIComponent(orderString))
       	 		 	var CookieValue=Cookie.getCookie("name")
       	     		tr.remove()
       	     		computerPrice();
       	     //登陆时候的删除
       	}else{
     	   var order={
   				 "pid":pid,
   		   }
        		 $.ajax({
            	     type : "GET", //提交方式 
            	     url : "${pageContext.request.contextPath}/redis/deleteRedispcs.do",//路径
            	     data :order
         			,//数据，这里使用的是Json格式进行传输 
            	     success : function(result) {//返回数据根据结果进行相应的处理 
            	    	updateData()
            	    	tr.remove()
            	     } 
          	 
          }) 
       	/* 	window.location.href ="${pageContext.request.contextPath}/redis/deleteRedispcs.do"; */
       	}
   
    })
    //修改文本框的数量
     $("input[name='pcount']").blur(function(){
    	var  pprice;
 	  	var pcountValue	= $(this).val()
 	  	var pid = $(this).attr("id")
 	  	if(disembark==null&&CookieValue!=null){
 	  	var  total=$(this).parent().next().children(".subtotal");
 	 		var arrorder=JSON.parse(decodeURIComponent(CookieValue))
 	 		/*  		debugger; */
 	 		 		for(var i=0;i<arrorder.length;i++){
 	 		 			if(arrorder[i].pid==pid){
 	 		 				arrorder[i].pcount=pcountValue;
 	 		 				pprice= arrorder[i].pprice 			
 	 		 			}	
 	 		 		}
 	 		 	 	total.text("￥"+pcountValue*pprice+"元")
 	 		 	  	var orderString=JSON.stringify(arrorder);
 	 		 		Cookie.setCookie("name",encodeURIComponent(orderString))
 	 		 		computerPrice() 		 
 	   }else{
 		   var order={
 				 "pid":pid,
 				"pcountValue":pcountValue
 		   }
      		 $.ajax({
          	     type : "GET", //提交方式 
          	     url : "${pageContext.request.contextPath}/redis/updateRedisquantity.do",//路径
          	     data :order
       			,//数据，这里使用的是Json格式进行传输 
          	     success : function(result) {//返回数据根据结果进行相应的处理 
          	    	updateData()
          	     } 
        	 
        }) 
 		   
 	   }
     })  
     $("#accountShopping").on("click",function(){
    	var buyPids=$("input[name='buyPids']")
    	var orderLists = [] //向后台传送的购物车数据  
 		for(var i=0;i<buyPids.length;i++){
 			var tds =$(buyPids[i]).parent().parent().children("td")
			if(buyPids[i].checked){
				var id=$(buyPids[i]).val()
				var num=parseInt($(tds[3]).children("input").val())
				orderLists.push({
					id:$(buyPids[i]).val(), //商品ID
					num:parseInt($(tds[3]).children("input").val()) //商品数量
				})
			}
		}
    	 $.ajax({
      	     type : "post", //提交方式 
      	     url : "${pageContext.request.contextPath}/redis/accountShopping.do",//路径
      	 	contentType: 'application/json',
      	 	dateType:'json',
      	 	data :JSON.stringify(orderLists)
   			,//数据，这里使用的是Json格式进行传输 
      	     success : function(result) {//返回数据根据结果进行相应的处理 
      	    	 
      	   	 window.location.href=result;
      	     }  
    	 
    }) 
 		
     })
   
})





</script>