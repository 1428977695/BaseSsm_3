<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
<head>
	<script src="${pageContext.request.contextPath}/js/jquery-3.1.0.min.js"></script>
</head>
<body>
<h2>Hello World!</h2>
<span id="user"></span>
<span id="password"></span>
<button id="button" onclick="test()">点击</button>
</body>
<script type="text/javascript">
	 function test(){
		 $.ajax({
			 "url":"${pageContext.request.contextPath}/user/queryUser.do",
			 "type":"POST",
			 "success":function(data){	
				 if(data.code=="000000"){
					  console.info(data.data.queryList);
						$('#user').text(data.data.queryList.id);
						$('#password').text(data.data.queryList.password);
					}else{
						HY.alert(data.codeDesc);
					}		
			 }});
	 }
</script>
</html>
