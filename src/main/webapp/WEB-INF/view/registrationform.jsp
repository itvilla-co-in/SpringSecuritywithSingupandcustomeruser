<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  

<!doctype html>
<html lang="en">

<head>
	
	<title>Register New User Form</title>
	
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	
	<!-- Reference Bootstrap files -->
<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" />

     <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
     
     <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
  
	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/bootstrap.min.js" />
		  
   	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
</head>

<body>

	<div>
		
		<div>
			
			<div>
				
				<div id="header">
					<h4 class="display-5">Register New User. Fill All Details below.</h2>
				</div>
				
				<div style="padding-top: 30px" id="container">

					<!-- Registration Form -->
					<form:form action="${pageContext.request.contextPath}/register/postRegistrationForm" 
						  	   modelAttribute="myuser">

					    <!-- Place for messages: error, alert etc ... -->
					    <div class="form-group">
					        <div class="col-xs-10">
					            <div>
								
									<!-- Check for registration error -->
									<c:if test="${registrationError != null}">
								
										<div class="alert alert-danger col-xs-offset-1 col-xs-10">
											${registrationError}
										</div>
		
									</c:if>
																			
					            </div>
					        </div>
					    </div>

						<!-- User name -->
						<div style="margin-bottom: 25px" class="form-group">
							<span><i class="fas fa-child"></i></span> 
							
							<form:input path="userName" placeholder="username" class="form-control" />
						</div>

						<!-- Password -->
						<div style="margin-bottom: 25px" class="form-group">
							<span class="input-group-addon"><i class="fas fa-key"></i></span> 
							
							<form:password path="password" placeholder="password" class="form-control" />
						</div>
						
						<!-- first name -->
						<div style="margin-bottom: 25px" class="form-group">
							<span class="input-group-addon"><i class="far fa-address-book"></i></span> 
							
							<form:input path="first_name" placeholder="firstname" class="form-control" />
						</div>
						
						
						<!-- last_name -->
						<div style="margin-bottom: 25px" class="form-group">
							<span class="input-group-addon"><i class="far fa-address-book"></i></span> 
							
							<form:input path="last_name" placeholder="lastname" class="form-control" />
						</div>
						
						<!-- email -->
						<div style="margin-bottom: 25px" class="form-group">
							<span class="input-group-addon"><i class="far fa-address-book"></i></span> 
							
							<form:input path="email" placeholder="email" class="form-control" />
						</div>
						

						<!-- Register Button -->
						<div style="margin-top: 10px" class="form-group">						
							<div class="col-sm-6 controls">
								<button type="submit" class="btn btn-primary">Register</button>
							</div>
						</div>
						
					</form:form>

				</div>

			</div>

		</div>

	</div>

</body>
</html>