<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><s:text name="action.login.title" /></title>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/common.css"></link>
</head>
<body>

<header><s:text name="action.login.headtip" /></header>

<div class="centerblock">
	
	<s:form action="loginSubmit">
		<s:textfield name="name" key="action.login.name"></s:textfield>
		<s:textfield name="pwd" key="action.login.pwd"></s:textfield>
		<s:submit key="action.login.sbm"></s:submit>
	</s:form>
	
</div>

<div><s:text name="action.login.gotoregister" /><a href="register.html">&nbsp;<s:text name="action.register" /></a></div>



<s:debug></s:debug>

</body>
</html>