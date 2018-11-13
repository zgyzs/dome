var Cart = {};

Cart.sendCookieCart = function(basePath) {
	
	
	var msg = $.ajax({
		type : "GET",
		url : basePath+"/cart/cookieToDb.do",
		async : false
	}).responseText;
	
	if (msg.indexOf('失败') != -1) {
		// alert(msg);
		console.log(msg);
	}
}
