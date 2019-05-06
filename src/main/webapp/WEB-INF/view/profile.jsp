<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Profile</title>
<%@ include file="header.jsp"  %>
</head>
<body>

<div class="container">
    <div class="row main">
        <div class="col-md-6">
            <h2 class="title">My Profile</h2>
            <hr/>
            <form:form action="profile" class="form-horizontal" modelAttribute="user" method="POST">
                <form:input type="hidden" path="userId" id="userId" name="userId"/>
                <div class="form-group">
                    <label for="firstName">First Name</label>
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
                </div>

				
				
                <div class="form-group ">
                    <button type="submit" class="btn btn-primary btn-block ">Update
                    </button>
                </div>

            </form:form>
        </div>
        <div class="col-md-6">
            <div class="panel-heading">

            </div>
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