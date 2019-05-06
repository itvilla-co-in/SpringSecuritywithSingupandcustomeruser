   	<meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <meta name="description" content=""/>
    <meta name="author" content=""/>
    <title>Test App</title>

	<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
	
	<link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" >    <!-- Google Fonts -->
	
    <link href='https://fonts.googleapis.com/css?family=Passion+One' rel='stylesheet' type='text/css' />
    <link href='https://fonts.googleapis.com/css?family=Oxygen' rel='stylesheet' type='text/css' />

    <!--bootstrap date-time picker-->
   	<link href="<c:url value="/resources/DataTable/css/bootstrap-datetimepicker.min.css" />" type='text/html'>    
    
    <!--data table
    <link href="<c:url value="/resources/DataTable/css/datatables.min.css" />">
    -->
    <link href="<c:url value="/resources/DataTable/css/jquery.dataTables.min.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/DataTable/css/dataTables.bootstrap.min.css" />" rel="stylesheet">
    <!-- 
	<link href="<c:url value="/resources/DataTable/css/dataTables.bootstrap4.min.css" />" rel="stylesheet">
	<link href="<c:url value="/resources/DataTable/css/dataTables.semanticui.min.css" />" rel="stylesheet">
	<link href="<c:url value="/resources/DataTable/css/dataTables.foundation.min.css" />" rel="stylesheet">
	<link href="<c:url value="/resources/DataTable/css/dataTables.jqueryui.min.css" />" rel="stylesheet">
	 -->
	
    <!-- Custom CSS -->
    <!--<link href="css/scrolling-nav.css" rel="stylesheet" />-->
    <link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
    
    <!-- Navigation -->
<div>
    
    <img src="<c:url value="/resources/images/banner.png" />" class="mx-auto d-block img-fluid" alt="banner">

</div>
    
  
     <nav class="navbar navbar-default " role="navigation">
    <div class="container">
        <div class="navbar-header page-scroll">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand page-scroll" href="${pageContext.request.contextPath}/FA/mainpage">Home</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse  navbar-collapse navbar-ex1-collapse">
          <ul class="nav navbar-nav navbar-right">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Me <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="${pageContext.request.contextPath}/user/profile">Profile</a></li>
                        <li role="separator" class="divider"></li>
                        <li><a href="${pageContext.request.contextPath}/logout">Logout</a></li>
                    </ul>
                </li>
            </ul>
        </div>
        <!-- /.navbar-collapse -->
    </div>
    <!-- /.container -->
</nav>

 
    
    
        