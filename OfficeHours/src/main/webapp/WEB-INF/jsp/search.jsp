<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">
<head>
	<link rel="icon" href="<c:url value="/resources/main/img/site.png"/>" type="image/png">
	<title>OfficeHours Search page</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">

	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/login/vendor/bootstrap/css/bootstrap.min.css"/>">
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/login/fonts/font-awesome-4.7.0/css/font-awesome.min.css"/>">
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/login/fonts/iconic/css/material-design-iconic-font.min.css"/>">
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/login/vendor/animate/animate.css"/>">
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/login/vendor/css-hamburgers/hamburgers.min.css"/>">
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/login/vendor/animsition/css/animsition.min.css"/>">
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/login/vendor/select2/select2.min.css"/>">
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/login/vendor/daterangepicker/daterangepicker.css"/>">
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/login/css/util.css"/>">
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/login/css/main.css"/>">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	
</head>

<body>
	
	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100 p-t-10 p-b-15">
				<form method = "POST" action = "/OfficeHours/search" class="login100-form validate-form">
					<p style="color:red;"><c:out value = "${message}"/><p>
					<input type="text" class="form-control" placeholder="Professor Name">
					<div class="container-login100-form-btn">
						<input class="login100-form-btn" type = "submit" value = "Search"/>
					</div>
					
				</form>
			</div>
		</div>
	</div>
	

	<div id="dropDownSelect1"></div>
	<script src="<c:url value="/resources/login/vendor/jquery/jquery-3.2.1.min.js"/>"></script>
	<script src="<c:url value="/resources/login/vendor/animsition/js/animsition.min.js"/>"></script>
	<script src="<c:url value="/resources/login/vendor/bootstrap/js/popper.js"/>"></script>
	<script src="<c:url value="/resources/login/vendor/bootstrap/js/bootstrap.min.js"/>"></script>
	<script src="<c:url value="/resources/login/vendor/select2/select2.min.js"/>"></script>
	<script src="<c:url value="/resources/login/vendor/daterangepicker/moment.min.js"/>"></script>
	<script src="<c:url value="/resources/login/vendor/daterangepicker/daterangepicker.js"/>"></script>
	<script src="<c:url value="/resources/login/vendor/countdowntime/countdowntime.js"/>"></script>
	<script src="<c:url value="/resources/login/js/main.js"/>"></script>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
	

</body>
</html>
