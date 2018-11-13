<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
</head>
<body>
 <table class="table table-bordered" align="center">
		      <thead>
		       <th class="text-center">地区名称</th>
		        <tr>
		          <c:forEach items="${findAll}" var="queryregion">
		     				<th class="text-center">${queryregion.areaId }</th>
		     				<th class="text-center">${queryregion.areaName}</th>
		     				<th class="text-center">${queryregion.areaDescribe}</th>
		          </c:forEach>
		        </tr>
		      </thead>
		      
		      
		      
		      <button  type="button" id="submitUpdateRoles">添加区域</button>
		      
		      
</body>
</html>
<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
<script>
$("#submitUpdateRoles").on("click",function(){
	var bannerarea = {
       		"areaName" : "欧洲" ,
       		"areaDescribe" : "还行"
	};
	$.ajax({
		url : "${pageContext.request.contextPath }/region/addregion.do",
		type : "post",
		data : bannerarea,
		success : function(result){
			alert(result)
		}
	})
});



</script>