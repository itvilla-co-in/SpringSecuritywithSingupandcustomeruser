<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
<%@ include file="header.jsp"  %>
</head>
<body>
<!-- Login Section -->
    
    <div class="container">
       	</br></br>
				<p class="bg-primary text-white">Welcome : <security:authentication property="principal.username" />, You are Logged in as : <security:authentication property="principal.authorities" />
				</p>
		<br></br>
		
    <div class="row">



       
 Hello Welcome to Main page... 
        
        
        

    
    
    
    
    </div>
    <!-- /.row -->


       
    </div>

		
<script type="text/javascript" src="<c:url value="/resources/js/jquery.js" />"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/jquery.min.js" />"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/moment.js" />"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/popper.min.js" />"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/jquery.easing.min.js" />"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/bootstrap-datetimepicker.min.js" />"></script>
		
	<script type="text/javascript" src="<c:url value="/resources/js/bootbox.min.js" />"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/datatables.min.js" />"></script>
	        

</body>
</html>