<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户登录</title>
<!-- <link rel="stylesheet" type="text/css" href="extjs/resources/css/ext-all.css"> -->
<!-- <script type="text/javascript" src="extjs/ext-all.js"></script>
<script type="text/javascript" src="js/login.js"></script> -->
<style type="text/css">
	#userlogin{
		width:600px;
		height:400px;
		margin: 0 auto;
	}

</style>

</head>
<body>
<div id="main">
	<div id="login" class="login">
		<form id="userlogin" action="user/userLogin.do" method="post">
			用户名:<input type="text"  id ="userName" name="userName" value=""/><br/>
			密     码:<input type="password" id ="password" name="password" value=""/><br/>
			<input type="submit" value="登陆"/>
			<a href="<%=basePath%>register.jsp">注册</a>
		</form>
	</div>
</div>

</body>
</html>