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
          	
      </c:forEach>
	  </table>   
	  
	   <table>
	  	<TH>Faculties</TH>
	  		<c:forEach items="${faculties}"  var="faculty">
	  		<tr>
				<td><c:out value = "${faculty.getLastName()}"/></td>
				<td><c:out value = "${faculty.getEmailAddress()}"/></td>
          	</tr>
          	
      </c:forEach>
	  </table>   
	  
	   <table>
	  	<TH>OfficeHours</TH>
	  		<c:forEach items="${officeHours}"  var="officeHour">
	  		<tr>
				<td><c:out value = "${officeHour.getDayTime()}"/></td>
          	</tr>
          	
      </c:forEach>
	  </table>   
	  
	   <table>
	  	<TH>Courses</TH>
	  		<c:forEach items="${courses}"  var="course">
	  		<tr>
				<td><c:out value = "${course.getCourseTitle()}"/></td>
          	</tr>
          	
      </c:forEach>
	  </table>   
	  
	   <table>
	  	<TH>Sections</TH>
	  		<c:forEach items="${sections}"  var="section">
	  		<tr>
				<td><c:out value = "${section.getCourseNumber()}"/></td>
				<td><c:out value = "${section.getSection()}"/></td>
				<td><c:out value = "${section.getDayTime()}"/></td>
				<td><c:out value = "${section.getRoomLocation()}"/></td>
         	</tr>
          	
      </c:forEach>
	  </table>   
	  
	</center>
</body>
</html>