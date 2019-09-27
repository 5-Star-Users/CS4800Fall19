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
		 <h1>	Sign In 	</h1> 
	</center>
	<section>
		<form action="" method="post">
			<div>
				<label for="username"><b>Username</b></label>
				<input type="text" placeholder="Enter Username" name="username" required>
				<label for="password"><b>Password</b></label>
				<input type="text" placeholder="Enter Passworde" name="password" required>
			<button type="submit">Login</button>
			<label>
				<input type="checkbox" checked="checked" name="remember"> Remember me
    		</label>
    	</div>
		</form>
	</section>
</body>
</html>