<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<s:debug></s:debug>


<table>
	<tr>
		<td>姓名</td>
		<td>工作</td>
		<td>工资</td>
	</tr>
	
	<s:iterator var="j" value="emps">
		<tr>
			<td>${name}</td>
			<td><s:property value="job"/></td>
			<td><s:property value="#j.sal"/></td>
			<td><a href="delete.html?ename=${name}">删除</a></td>
		</tr>
	</s:iterator>
	
	
</table>

</body>
</html>