<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
 
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>OfficeHours</title>
</head>
<body>
	<center>
		 <table>
	  	<TH>Departments</TH>
	  		<c:forEach items="${departments}"  var="department">
	  		<tr>
				<td><c:out value = "${department.getDepartmentName()}"/></td>
          	</tr>
          	<tr><td><c:out value = "${oldDepartment.getDepartmentName()}"/></td></tr>
      </c:forEach>
	  </table>   
	</center>
</body>
</html>