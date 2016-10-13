<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>注册页面</title>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/common.css"></link>
<script src="${pageContext.request.contextPath }/js/jquery-3.0.0.js"></script>
</head>
<body>

<div class="centerblock">
	<form action="registerSubmit" method="post">
		账   号    <input type="text" name="acc.username"><br>
		密   码    <input type="password" name="acc.password"><br>
		确认密码<input type="password" name="pwd">
		
		<input type="submit" value="注册">
	</form>
</div>
</body>
</html>