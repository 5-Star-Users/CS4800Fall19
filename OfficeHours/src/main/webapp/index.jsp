<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!doctype html>
<html lang="en">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<link rel="icon" href="<c:url value="/resources/main/img/site.png"/>" type="image/png">
        <title>CPP Officer Hours</title>
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="<c:url value="/resources/main/css/bootstrap.css"/>">
        <link rel="stylesheet" href="<c:url value="/resources/main/vendors/linericon/style.css"/>">
        <link rel="stylesheet" href="<c:url value="/resources/main/css/font-awesome.min.css"/>">
        <link rel="stylesheet" href="<c:url value="/resources/main/vendors/owl-carousel/owl.carousel.min.css"/>">
        <link rel="stylesheet" href="<c:url value="/resources/main/vendors/lightbox/simpleLightbox.css"/>">
        <link rel="stylesheet" href="<c:url value="/resources/main/vendors/nice-select/css/nice-select.css"/>">
        <link rel="stylesheet" href="<c:url value="/resources/main/vendors/animate-css/animate.css"/>">
        <link rel="stylesheet" href="<c:url value="/resources/main/vendors/popup/magnific-popup.css"/>">
        <!-- main css -->
        <link rel="stylesheet" href="<c:url value="/resources/main/css/style.css"/>">
        <link rel="stylesheet" href="<c:url value="/resources/main/css/responsive.css"/>">
    </head>
    <body>
        
        <!--================Header Menu Area =================-->
        <header class="header_area">
           	<div class="top_menu row m0">
           		<div class="container">
					<div class="float-left">
						<jsp:useBean id="now" class="java.util.Date" />
						<fmt:formatDate var="date" value="${now}" pattern="yyyyMMdd HH:mm:ss" />
						<p>${date}</p>
					</div>
					<div class="float-right">
						
						<a class="dn_btn" href="https://github.com/5-Star-Users/CS4800Fall19">5-Star-Users Repository</a>
					</div>
           		</div>	
           	</div>	
            <div class="main_menu">
            	<nav class="navbar navbar-expand-lg navbar-light">
					<div class="container">
						<!-- Brand and toggle get grouped for better mobile display -->
					<c:forEach begin="0" end="4">
						<a class="navbar-brand logo_h" href="#"><img src="<c:url value="/resources/main/img/logo.png"/>" alt="" style="width:50px;height:50px;"></a>
					</c:forEach>


						<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
						</button>
						<!-- Collect the nav links, forms, and other content for toggling -->
						<div class="collapse navbar-collapse offset" id="navbarSupportedContent">
							<ul class="nav navbar-nav menu_nav ml-auto">
								<li class="nav-item active"><a class="nav-link" href="https://github.com/5-Star-Users/">Home</a></li> 
								<li class="nav-item"><a class="nav-link" href="https://www.cpp.edu/">About</a></li> 
								<li class="nav-item submenu dropdown">
									<a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Contact</a>
								     <ul class="dropdown-menu">
									<li class="nav-item"><a class="nav-link" href="https://github.com/EdwardGuaman">Edward Guaman</a></li>					<li class="nav-item"><a class="nav-link" href="https://github.com/poudyalsaroz">Saroj Poudel</a></li>					<li class="nav-item"><a class="nav-link" href="https://github.com/tnleang">Titichot N.</a></li>					<li class="nav-item"><a class="nav-link" href="https://github.com/SergioSimental">SergioSimental</a></li>					<li class="nav-item"><a class="nav-link" href="https://github.com/haohuynh">Hao Huynh</a></li>
					
								     </ul>
								</li> 
								
							</ul>
						</div> 
					</div>
            	</nav>
            </div>
        </header>
        <!--================Header Menu Area =================-->
             
         
        <!--================Main Area =================-->
        <section class="impress_area p_120">
        	<div class="container">
        		<div class="impress_inner text-center">
					<h2>CPP Office Hours</h2>
					<a class="main_btn" href="/OfficeHours/search">Bronco Search</a>
					<span style="padding-left:9em">
						<a class="main_btn2" href="/OfficeHours/login">Faculty Login</a>
					</span>
					
        		</div>
        	</div>
        </section>
        <!--================End Main Area =================-->
               
     
    </body>
</html>
