<%@page import="com.jfsfebspringmvc.dto.EmployeeBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <% EmployeeBean bean=(EmployeeBean) request.getAttribute("empInfo");
    String errMsg=(String) request.getAttribute("errMsg");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="./searchEmp" method="get">
Employee Id: <input type="number" name="empId"><br>
<input type="submit">

</form>
<%if(bean !=null ){ %>
<h3 style="color: green;">Employee REcord Found for<%=bean.getId() %></h3>
Employee Name:<%=bean.getLastName()%>
employee Salary :<%=bean.getSalary() %>
Employee Designation: <%=bean.getDepartment() %>
<% }%>
<%if(errMsg!=null && !errMsg.isEmpty()){ %>
<h2 style="color: red;"><%=errMsg %></h2>
<%} %>
</body>
</html>