<!DOCTYPE html>
<html lang="en">
<head>


    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Ride Share App</title>

    <!-- Bootstrap Core CSS -->
    <link href="/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="/css/sb-admin.css" rel="stylesheet">

    <!-- Morris Charts CSS -->
    <link href="/css/plugins/morris.css" rel="stylesheet">



    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    
</head>
<body>

  <div id="wrapper">

        <!-- Navigation -->
        <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="/">RideShare App</a>
            </div>
            <!-- Top Menu Items -->
            <ul class="nav navbar-right top-nav">
              <#if !currentUser??>
               <li class="dropdown">
                    
                    <a href="/login"><i class="fa fa-user"></i> Login </a>
                    
			  </li>
			  <li class="dropdown">
			  <a href="/register"><i class="fa fa-user"></i> Register </a>
			  </li>
			  </#if>	
              <#if currentUser??>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i> ${currentUser.username} <b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li>
                            <a href="/user/${currentUser.id}"><i class="fa fa-fw fa-user"></i> My Profile</a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#" onclick="$('#logoutFrm').submit()"><i class="fa fa-fw fa-power-off"></i> Log Out</a>
                        </li>
                    </ul>
                </li>
                </#if>
            </ul>
            <!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
            <div class="collapse navbar-collapse navbar-ex1-collapse">               
                <nav role="navigation">
					 <ul class="nav navbar-nav side-nav">
					<li><a href="/">Home</a></li>
				
 					
					<#if currentUser?? && currentUser.role == "ADMIN">					  			        
					<li>			

						    <li><a href="/users">Manage Users</a></li>
					
					</li>
					</#if>
					<#if currentUser?? && (currentUser.role == "CUSTOMER")>
							<li><a href="/cars/add">Driver? Add a Car</a></li>
					</#if>
					<#if currentUser?? && (currentUser.role == "ADMIN" || currentUser.role == "DRIVER")>
					<li>	
						<a href="javascript:;" data-toggle="collapse" data-target="#cars">Cars Management</a>
						<ul id="users">
						    <li><a href="/cars">Manage Cars</a></li>
							<li><a href="/cars/add">Add Car</a></li>
						</ul>
					</li>
					<li>	
						<a href="javascript:;" data-toggle="collapse" data-target="#cars">Rides Management</a>
						<ul id="users">
						    <li><a href="/rideinfos">My Rides</a></li>
							<li><a href="/rideinfos/rideadd">Add a Ride</a></li>
						</ul>
					</li>     
					</#if>
					<#if currentUser??>
			        <li>
			            <form action="/logout" method="post" id="logoutFrm">
			                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>			                
			            </form>
			        </li>
			        </#if>
			        <#if !currentUser??>
 						<li><a href="/register">Register Customer</a></li>
 					</#if>
					</ul>
					
					</nav>    
                                     
            </div>
            <!-- /.navbar-collapse -->
        </nav>

<div id="page-wrapper">

            <div class="container-fluid">






