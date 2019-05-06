<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SignUP</title>
<%@ include file="header.jsp"  %>
</head>
<body>
<div class="container">
    <div class="row main">
        <div class="panel-heading">
            <div class="panel-title text-center">
                <h1 class="title">Sign Up</h1>
                <hr />
            </div>
        </div>
        <div class="main-login main-center">
            <form:form action="signup" class="form-horizontal" modelAttribute="user" method="POST">

                <div class="form-group">
                    <label for="firstName" class="cols-sm-2 control-label">First Name</label>
                    <div class="cols-sm-10">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
                            <form:input path="firstName" placeholder="enter your first name" class="form-control" id="firstName" name="firstName" roleId="firstname" />
                            <form:errors path="firstName" cssClass="bg-danger pull-right"/>
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <label for="lastName" class="cols-sm-2 control-label">Last Name</label>
                    <div class="cols-sm-10">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
                            <form:input path="lastName" placeholder="enter your last name" class="form-control" id="lastName" name="lastName" roleId="lastName" />
                            <form:errors path="lastName" cssClass="bg-danger pull-right"/>
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <label for="phone" class="cols-sm-2 control-label">Phone</label>
                    <div class="cols-sm-10">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="fa fa-phone fa" aria-hidden="true"></i></span>
                            <form:input path="phone" placeholder="xxx-xxx-xxxx" class="form-control" id="phone" name="phone" roleId="phone" />
                            <form:errors path="phone" cssClass="bg-danger pull-right"/>
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <label for="email" class="cols-sm-2 control-label">Your Email</label>
                    
                    
                    
                    <c:if test="${emailExists}">  
						  <span class="bg-danger pull-right">Email already exists</span>  
					</c:if>  

                    
                    <div class="cols-sm-10">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="fa fa-envelope fa" aria-hidden="true"></i></span>
                            <form:input path="email" placeholder="xxxxx" class="form-control" id="email" name="email" roleId="email" />
                            <form:errors path="email" cssClass="bg-danger pull-right"/>
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <label for="username" class="cols-sm-2 control-label">Username</label>
                    
                    
                    <c:if test="${usernameExists}">  
						  <span class="bg-danger pull-right">Username already exists</span>  
					</c:if>  
                    
                    
                    <div class="cols-sm-10">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="fa fa-users fa" aria-hidden="true"></i></span>
                            <form:input path="username" placeholder="username" class="form-control" id="username" name="username" roleId="username" />
                            <form:errors path="username" cssClass="bg-danger pull-right"/>	
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <label for="password" class="cols-sm-2 control-label">Password</label>
                    <div class="cols-sm-10">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
                            <form:input path="password" type="password" placeholder="password" class="form-control" id="password" name="password" roleId="password" />
                            <form:errors path="password" cssClass="bg-danger pull-right"/>
                        </div>
                        <div class="checkbox">
                            <label>
                                <input id="showPassword" type="checkbox" />Show Password
                            </label>
                        </div>
                    </div>
                </div>

                <!--<div class="form-group">-->
                    <!--<label for="confirm" class="cols-sm-2 control-label">Confirm Secret</label>-->
                    <!--<div class="cols-sm-10">-->
                        <!--<div class="input-group">-->
                            <!--<span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span>-->
                            <!--<input type="secret" class="form-control" name="confirm" roleId="confirm"  placeholder="Confirm your Secret" required="required"/>-->
                        <!--</div>-->
                    <!--</div>-->
                <!--</div>-->

                <div class="form-group ">
                    <button type="submit" class="btn btn-primary btn-lg btn-block login-button">Sign up!</button>
                </div>
                
                <hr />
                 
				<div class="form-group ">
                    <a  class="btn btn-info btn-lg btn-block login-button" href="${pageContext.request.contextPath}/FA/home">Cancel</a>
                </div>
                
           </form:form>
        </div>
    </div>
</div>

	<script type="text/javascript" src="<c:url value="/resources/js/jquery.js" />"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/jquery.min.js" />"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/popper.min.js" />"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/jquery.easing.min.js" />"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/bootstrap-datetimepicker.min.js" />"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/bootbox.min.js" />"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/datatables.min.js" />"></script>
    <script type="text/javascript" src="<c:url value="/resources/DataTable/js/dataTables.bootstrap.min.js" />"></script>
    <script type="text/javascript" src="<c:url value="/resources/DataTable/js/dataTables.bootstrap4.min.js" />"></script>
    <script type="text/javascript" src="<c:url value="/resources/DataTable/js/dataTables.foundation.min.js" />"></script>
    <script type="text/javascript" src="<c:url value="/resources/DataTable/js/dataTables.jqueryui.min.js" />"></script>
    <script type="text/javascript" src="<c:url value="/resources/DataTable/js/dataTables.semanticui.min.js" />"></script>
    <script type="text/javascript" src="<c:url value="/resources/DataTable/js/jquery.dataTables.min.js" />"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/main.js" />"></script>
    
    <script type="text/javascript">
    $(document).ready(function() {
        $('#example').DataTable();
    } );
   </script>



</body>
</html>