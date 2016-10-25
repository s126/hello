<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>员工增加</title>
</head>
<body>
<s:debug></s:debug>
<s:form action="addSubmit">
	<s:textfield label="姓名" name="emp.name"></s:textfield>
	<s:textfield label="工资" name="emp.sal"></s:textfield>
	<s:select label="职位" list="#session.jobs" name="emp.job"></s:select>
	<s:submit value="添加"></s:submit>
</s:form>


	
</body>
</html>