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
	
	<s:iterator var="l" value="emps">
		<tr>
			<td><s:property value="#l.name"/></td>
			<td><s:property value="#l.job"/></td>
			<td><s:property value="#l.sal"/></td>
			<td><a href="delete.html?ename=${name}">删除</a></td> 
		</tr>
	</s:iterator>
</table>

</body>
</html>