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
				<p style="color:red;"><c:out value = "${message}"/><p>
				<%-- Personal information section --%>
				<div class="row d-flex justify-content-center modalWrapper">
    				<div class="modal fade addNewInputs" id="modalAdd1" tabindex="-1" role="dialog" aria-labelledby="modalAdd" aria-hidden="true">
      					<div class="modal-dialog" role="document">
        					<div class="modal-content">
          						<div class="modal-header text-center">

            						<h4 class="modal-title w-100 font-weight-bold text-primary ml-5">Update Information</h4>
            							<button type="button" class="close text-primary" data-dismiss="modal" aria-label="Close">
              								<span aria-hidden="true">&times;</span>
            							</button>
          						</div>
          						<div class="modal-body mx-3">
            						<div class="md-form mb-5">
              							<input type="text" id="inputName1" 
              							class="form-control validate" placeholder="${faculty.getFirstName()} ${faculty.getLastName()}">
              								<label data-error="wrong" data-success="right" for="inputName">Name</label>
            						</div>

						            <div class="md-form mb-5">
						              <input type="text" id="inputPosition1" 
						              class="form-control validate" placeholder="${faculty.getPhoneNumber()}">
						              <label data-error="wrong" data-success="right" for="inputPhoneNumber">Phone Number</label>
						            </div>
	
							        <div class="md-form mb-5">
							          <input type="text" id="inputOfficeInput1" 
							          class="form-control validate" placeholder="${faculty.getEmailAddress()}">
							          <label data-error="wrong" data-success="right" for="inputEmail">Email</label>
							         </div>
	
						            <div class="md-form mb-5">
						              <input type="text" id="inputAge1" 
						              class="form-control validate" placeholder="${faculty.getOfficeLocation()}">
						              <label data-error="wrong" data-success="right" for="inputOfficeRoom">Office Room</label>
						            </div>
	
						            <div class="md-form mb-5">
						              <input type="text" id="inputSalary1" 
						              class="form-control validate" placeholder="${faculty.getDepartmentName()}">
						              <label data-error="wrong" data-success="right" for="inputDepartment">Department</label>
						            </div>
						          </div>
						          <form method = "POST" action = "/OfficeHours/edit" class="login100-form validate-form">
									<div class="container-login100-form-btn">
										<input class="login100-form-btn" type = "submit" value = "Submit"/>
									</div>
								</form>

					        </div>
					      </div>
					    </div>
				<table class="table table-striped table-bordered">
				<thead class="thead-dark">
				<th scope="col">Name</th>
      				<th scope="col">Phone Number</th>
      				<th scope="col">Email</th>
      				<th scope="col">Office Room</th>
      				<th scope="col">Department</th>
					<!--
      				<th scope="col">Office Hours</th>
      				<th scope="col">Sections</th>
					-->
				</thead>
				<tbody>
					<tr>
						<td><c:out value = "${faculty.getFirstName()}"/> <c:out value = " ${faculty.getLastName()}"/></td>
						<td><c:out value = "${faculty.getPhoneNumber()}"/></td>
						<td><c:out value = "${faculty.getEmailAddress()}"/></td>
						<td><c:out value = "${faculty.getOfficeLocation()}"/></td>
						<td><c:out value = "${faculty.getDepartmentName()}"/></td>

					</tr>
				</tbody>
				
				
				<%-- Office hour section --%>
			<div class="wrapper-editor">
			
				<div class="text-center">
      				<a href="" class="btn btn-info btn-rounded btn-sm" data-toggle="modal" data-target="#modalAdd15">Edit Information
          			</a>
			  <!--
			    <div class="d-flex justify-content-center">
			      <p class="h5 text-primary createShowP">0 row selected</p>
			    </div>
				-->
			  </div>
			  <div class="row d-flex justify-content-center modalWrapper">
			    <div class="modal fade addNewInputs" id="modalAdd15" tabindex="-1" role="dialog" aria-labelledby="modalAdd15"
			      aria-hidden="true">
			      <div class="modal-dialog" role="document">
			        <div class="modal-content">
			          <div class="modal-header text-center">
			            <h4 class="modal-title w-100 font-weight-bold text-primary ml-5">Add new Office Hour</h4>
			            <button type="button" class="close text-primary" data-dismiss="modal" aria-label="Close">
			              <span aria-hidden="true">&times;</span>
			            </button>
			          </div>
			          <div class="modal-body mx-3 modal-add-inputs">
			            <div class="md-form mb-5">
              				<input type="text" id="inputName1" class="form-control validate" >
              				<label data-error="wrong" data-success="right" for="inputName">Office Hour time</label>
            			</div>

						<div class="md-form mb-5">
						     <input type="text" id="inputPosition1" class="form-control validate">
						     <label data-error="wrong" data-success="right" for="inputPhoneNumber">Section</label>
						</div>
			          </div>
			          <div class="modal-footer d-flex justify-content-center buttonAddFormWrapper">
			            <button class="btn btn-outline-primary btn-block buttonAdd" data-dismiss="modal">Add
			              <i class="far fa-paper-plane ml-1"></i>
			            </button>
			          </div>
			        </div>
			      </div>
			    </div>
			    <div class="text-center">
			      <a href="" class="btn btn-info btn-rounded btn-sm" data-toggle="modal" data-target="#modalAdd15">Add<i
			          class="fas fa-plus-square ml-1"></i></a>
			    </div>
				<!--
			    <div class="modal fade modalEditClass" id="modalEdit15" tabindex="-1" role="dialog" aria-hidden="true">
			      <div class="modal-dialog" role="document">
			        <div class="modal-content">
			          <div class="modal-header text-center">
			            <h4 class="modal-title w-100 font-weight-bold text-secondary ml-5">Edit</h4>
			            <button type="button" class="close text-secondary" data-dismiss="modal" aria-label="Close">
			              <span aria-hidden="true">&times;</span>
			            </button>
			          </div>
			          <div class="modal-body mx-3 modal-inputs">
			            <div class="md-form mb-5">
              				<input type="text" id="inputName1" class="form-control validate" >
              				<label data-error="wrong" data-success="right" for="inputName">Office Hour time</label>
            			</div>

						<div class="md-form mb-5">
						     <input type="text" id="inputPosition1" class="form-control validate">
						     <label data-error="wrong" data-success="right" for="inputPhoneNumber">Section</label>
						</div>
			          </div>
			          <div class="modal-footer d-flex justify-content-center editInsideWrapper">
			            <button class="btn btn-outline-secondary btn-block editInside" data-dismiss="modal">Edit
			              form
			              <i class="far fa-paper-plane ml-1"></i>
			            </button>
			          </div>
			        </div>
			      </div>
			    </div>
				-->
				
				<!--
			    <div class="text-center buttonEditWrapper">
			      <button class="btn btn-info btn-rounded btn-sm buttonEdit" data-toggle="modal" data-target="#modalEdit15"
			        disabled>Edit<i class="fas fa-pen-square ml-1"></i></a>
			    </div>
				-->
				
				<!--
			    <div class="modal fade" id="modalDelete15" tabindex="-1" role="dialog" aria-labelledby="modalDelete15"
			      aria-hidden="true">
			      <div class="modal-dialog" role="document">
			        <div class="modal-content">
			          <div class="modal-header text-center">
			            <h4 class="modal-title w-100 font-weight-bold ml-5 text-danger">Delete</h4>
			            <button type="button" class="close text-danger" data-dismiss="modal" aria-label="Close">
			              <span aria-hidden="true">&times;</span>
			            </button>
			          </div>
			          <div class="modal-body mx-3">
			            <p class="text-center h4">Are you sure to delete selected row?</p>
			          </div>
			          <div class="modal-footer d-flex justify-content-center deleteButtonsWrapper">
			            <button type="button" class="btn btn-outline-danger btnYesClass" id="btnYes15" data-dismiss="modal">Yes
			              <i class="far fa-paper-plane ml-1"></i>
			            </button>
			            <button type="button" class="btn btn-outline-primary btnNoClass" id="btnNo15" data-dismiss="modal">No
			              <i class="far fa-paper-plane ml-1"></i>
			            </button>
			          </div>
			        </div>
			      </div>
			    </div>
				-->
				
				<!--
			    <div class="text-center">
			      <button class="btn btn-danger btn-sm btn-rounded buttonDelete" data-toggle="modal" disabled data-target="#modalDelete15"
			        disabled>Delete<i class="fas fa-times ml-1"></i></a>
			    </div>
				-->
			  </div>
			  <table id="dt-less-columns" class="table table-striped table-bordered" cellspacing="0" width="100%">		
				<thead class="thead-dark">
      				<th scope="col">Office Hours</th>
      				<th scope="col">Sections</th>
				</thead>
				<tbody>
					<tr>

						<c:if test = "${not empty faculty.getOfficeHours()}">
							<c:forEach items="${faculty.getOfficeHours()}"  var="officeHour">
			  						<td><c:out value = "${officeHour.getDayTime()}"/></td>
								</c:forEach>
						</c:if>

						<c:if test = "${not empty faculty.getSections()}">
         						<c:forEach items="${faculty.getSections()}"  var="section">
			  						<td><c:out value = "${section.getCourseTitle()} ${section.getSection()}"/></td>
								</c:forEach>
      					</c:if>		
					</tr>
				</tbody>
				</table>
				</div>
				
				
						
						
						<c:if test = "${not empty faculty.getOfficeHours()}">
								<tr><td><h1>Office Hours</h1></tr></td>
         						<c:forEach items="${faculty.getOfficeHours()}"  var="officeHour">
			  						<tr><td><c:out value = "${officeHour.getDayTime()}"/></td></tr>
									<tr><td><c:out value = "${officeHour.getComment()}"/></td></tr>
								</c:forEach>
      					</c:if>
						
						<c:if test = "${not empty faculty.getSections()}">
								<tr><td><h1>Sections</h1></tr></td>
         						<c:forEach items="${faculty.getSections()}"  var="section">
			  						<tr><td><c:out value = "${section.getSemester()}"/></td></tr>
			  						<tr><td><c:out value = "${section.getCourseTitle()}"/></td></tr>
			  						<tr><td><c:out value = "${section.getSection()}"/></td></tr>
									<tr><td><c:out value = "${section.getDayTime()}"/></td></tr>
									<tr><td><c:out value = "${section.getRoomLocation()}"/></td></tr>
								</c:forEach>
      					</c:if>

						
						
							
				</table>
				<form method = "POST" action = "/OfficeHours/edit" class="login100-form validate-form">
						<div class="container-login100-form-btn">
						<input class="login100-form-btn" type = "submit" value = "Submit"/>
					</div>
					
				</form>
			</div>
		</div>
	</div>
	

	<div id="dropDownSelect1"></div>
	<script>
	$('#dt-less-columns').mdbEditor({
		modalEditor: true,
		headerLength: 2,
		});
		$('.dataTables_length').addClass('bs-select');
	</script>
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
