<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>LoginHome</title>
<%@ include file="header.jsp"  %>
</head>
<body>
<!-- Login Section -->
    <div class="container">
        <div class="row ">
            <div class="main-center ">
            	                
				<form action="${pageContext.request.contextPath}/FA/home" 
						  method="POST" class="form-horizontal">

                    <h2 class="form-signin-heading">Please sign in</h2>
            		
            		<!-- Place for messages: error, alert etc ... -->
					    <div class="form-group">
					        <div class="col-xs-15">
					            <div>
								
									<!-- Check for login error -->
								
									<c:if test="${param.error != null}">
										
										<div class="alert alert-danger col-xs-offset-1 col-xs-10">
											Invalid username and password. Retry with valid username/password
										</div>
		
									</c:if>
										
									<!-- Check for logout -->

									<c:if test="${param.logout != null}">
										            
										<div class="alert alert-success col-xs-offset-1 col-xs-10">
											You have been logged out. Please login Again
										</div>
								    
									</c:if>
									
					            </div>
					        </div>
					    </div>
					    
            		    
                    <div class="form-group">
                        <label for="username" class="sr-only">Username</label>
                		<input type="text" name="username" placeholder="username" class="form-control">
                    </div>
                    <div class="form-group">
                        <label for="password" class="sr-only">Password</label>
                        <input type="password" name="password" placeholder="password" class="form-control" >
                                                   
                    </div>
                    <div class="form-group">
                        <input type="checkbox" name="remember-me" id="remember-me"/> &nbsp; Remember me
                    </div>
                    <button class="btn btn-lg btn-primary btn-block" type="submit">Login</button>
                </form>
                
                <hr />
                
                <div class="form-group ">
                    <a type="submit" class="btn btn-info btn-lg btn-block login-button" href="${pageContext.request.contextPath}/FA/signup">Sign up!</a>
                </div>
            </div>
        </div>
    </div>

</body>
</html>