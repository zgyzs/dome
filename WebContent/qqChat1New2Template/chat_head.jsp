<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" type="text/css" href="./css/chat.css" />
<!-- jquery-->
<script type="text/javascript" src="../js/jquery-1.8.3.js"></script>
<!--聊天界面的基础js：控制界面效果 -->
<script type="text/javascript" src="./js/chat.js"></script>
<!--聊天界面：聊天的逻辑代码编写websocket的一些操作=需自己定义 --><!-- 
<script type="text/javascript" src="./js/chat_my_controller.js"></script> -->
<style>
.white_content {
	display: none;
	position: fixed;
	top: 50%;
	margin-left: -300px;
	left: 50%;
	margin-top: -160px;
	padding: 0px;
	border: 2px solid orange;
	background-color: #FFF;
	 z-index: 10001;
	overflow: auto;
	/*边框虚化*/
	-webkit-box-shadow: #666 0px 0px 20px;  
    -moz-box-shadow: #666 0px 0px 20px;  
    box-shadow: #666 0px 0px 20px;  
}
.showChatBtn{
	position: fixed ;
	right: 150px;
	top: 100px;
	font-weight: bold;
	width: 50px;
}
</style>
