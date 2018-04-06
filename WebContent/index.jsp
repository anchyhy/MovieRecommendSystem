<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Movie Recommend System</title>
	<style type="text/css">
.searchinput{
	border-right-width: 0px;
	padding-left: 3px;
	width: 168px;
	font-family: arial;
	float: left;
	border-top-width: 0px;
	border-bottom-width: 0px;
	color: #636365;
	margin-left: 4px;
	font-size: 8pt;
	vertical-align: middle;
	border-left-width: 0px;
	margin-right: 3px;
}
.tab_search{
	border-bottom: #cccccc 1px solid;
	border-left: #cccccc 1px solid;
	height: 25px;
	border-top: #cccccc 1px solid;
	border-right: #cccccc 1px solid;

}
.searchaction{
	width: 21px;
	float: left;
	height: 17px;
}
</style>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="Free HTML5 Template by FREEHTML5" />
	<meta name="keywords" content="free html5, free template, free bootstrap, html5, css3, mobile first, responsive" />
  	<!-- Facebook and Twitter integration -->
	<meta property="og:title" content=""/>
	<meta property="og:image" content=""/>
	<meta property="og:url" content=""/>
	<meta property="og:site_name" content=""/>
	<meta property="og:description" content=""/>
	<meta name="twitter:title" content="" />
	<meta name="twitter:image" content="" />
	<meta name="twitter:url" content="" />
	<meta name="twitter:card" content="" />
	<!-- Place favicon.ico and apple-touch-icon.png in the root directory -->
	<link rel="shortcut icon" href="favicon.ico">
	<!-- Animate.css -->
	<link rel="stylesheet" href="css/animate.css">
	<!-- Icomoon Icon Fonts-->
	<link rel="stylesheet" href="css/icomoon.css">
	<!-- Bootstrap  -->
	<link rel="stylesheet" href="css/bootstrap.css">
	<!-- Superfish -->
	<link rel="stylesheet" href="css/superfish.css">
	<link rel="stylesheet" href="css/style.css">
	<!-- Modernizr JS -->
	<script src="js/modernizr-2.6.2.min.js"></script>
	<!-- FOR IE9 below -->
	<!--[if lt IE 9]>
	<script src="js/respond.min.js"></script>
	<![endif]-->
${showMessage } 
</head>
<body>
<div id="fh5co-wrapper">
		<div id="fh5co-page">
		<div id="fh5co-header">
			<header id="fh5co-header-section">
				<div class="container">
					<div class="nav-header">
						<a href="#" class="js-fh5co-nav-toggle fh5co-nav-toggle"><i></i></a>
						<!-- START #fh5co-menu-wrap -->
						<nav id="fh5co-menu-wrap" role="navigation">
							<ul class="sf-menu" id="fh5co-primary-menu">
							<c:if test="${user==null }">
								<li>
									<a href="#" class="fh5co-sub-ddown">User Management</a>
									<ul class="fh5co-sub-menu">
										<li><a href="login.jsp" >Login</a></li>
										<li><a href="register.jsp">Register</a></li>
									</ul>
								</li>
								</c:if>
								<c:if test="${user != null }">
									<li><a>Hi, ${user.username }</a></li>
								</c:if>
								<li>
									<a href="#" class="fh5co-sub-ddown">Classification</a>
									<ul class="fh5co-sub-menu">
										<li><a href="classification?pageNum=1&pageSize=12&classification=action&flag=0" >Action</a></li>
										<li><a href="classification?pageNum=1&pageSize=12&classification=adventure&flag=0" >Adventure</a></li>
										<li><a href="classification?pageNum=1&pageSize=12&classification=animation&flag=0" >Animation</a></li>
										<li><a href="classification?pageNum=1&pageSize=12&classification=children&flag=0">Children</a></li>
										<li><a href="classification?pageNum=1&pageSize=12&classification=comedy&flag=0" >Comedy</a></li>
										<li><a href="classification?pageNum=1&pageSize=12&classification=crime&flag=0" >Crime</a></li>
										<li><a href="classification?pageNum=1&pageSize=12&classification=documentary&flag=0" >Documentary</a></li>
										<li><a href="classification?pageNum=1&pageSize=12&classification=drama&flag=0" >Drama</a></li>
										<li><a href="classification?pageNum=1&pageSize=12&classification=fantasy&flag=0" >Fantasy</a></li>
										<li><a href="classification?pageNum=1&pageSize=12&classification=filmnoir&flag=0" >Filmnoir</a></li>
										<li><a href="classification?pageNum=1&pageSize=12&classification=horror&flag=0" >Horror</a></li>
										<li><a href="classification?pageNum=1&pageSize=12&classification=musical&flag=0" >Musical</a></li>
										<li><a href="classification?pageNum=1&pageSize=12&classification=mystery&flag=0" >Mystery</a></li>
										<li><a href="classification?pageNum=1&pageSize=12&classification=romance&flag=0" >Romance</a></li>
										<li><a href="classification?pageNum=1&pageSize=12&classification=scifi&flag=0" >Sci-Fi</a></li>
										<li><a href="classification?pageNum=1&pageSize=12&classification=thriller&flag=0" >Thriller</a></li>
										<li><a href="classification?pageNum=1&pageSize=12&classification=war&flag=0" >War</a></li>
										<li><a href="classification?pageNum=1&pageSize=12&classification=western&flag=0">Western</a></li>
										<li></li>
									</ul>
								</li>
								<li><a href="#" class="fh5co-sub-ddown">Recommend For Me</a>
								<ul class="fh5co-sub-menu">
								<li><a href="cbRating?mf=0&uid=${user.id }&flag=1&way=1">content-based </a></li>
								<li><a href="collaborateRating?uid=${user.id}&flag=1&mf=1&way=0">collaborate  </a></li>
								</ul>
								</li>
								<c:if test="${user != null }"><li><a href="logout">Logout</a></li></c:if>
							</ul>
						</nav>
					</div>
				</div>
			</header>
			
		</div>
		
		
		<div class="fh5co-hero">
			<div class="fh5co-overlay"></div>
			<div class="fh5co-cover text-center" data-stellar-background-ratio="0.5" style="background-image: url(images/cover_bg_1.jpg);">
				<div class="desc animate-box">
					<h2>Watch This World.</h2>
					<form action="#" name="search">
						<table border="0" align="center" cellpadding="0" cellspacing="0" class="tab_search">
							<tr>
									<td>
										<input type="text" name="search" title="Search" class="searchinput" id="searchinput"  value="- Search Movies -" size="30"/>
									</td>
									<td>
										<input type="image" width="21" height="17" class="searchaction" src="./images/magglass.gif" border="0" hspace="2"/>
									</td>
							</tr>
						</table>
					</form>
				</div>
			</div>

		</div>
      
		<footer>
			<div id="footer">
				<div class="container">
					<div class="row">
						<div class="col-md-6 col-md-offset-3 text-center">
							<p class="fh5co-social-icons">
								<a href="#"><i class="icon-twitter2"></i></a>
								<a href="#"><i class="icon-facebook2"></i></a>
								<a href="#"><i class="icon-instagram"></i></a>
								<a href="#"><i class="icon-dribbble2"></i></a>
								<a href="#"><i class="icon-youtube"></i></a>
							</p>
							<p>Copyright 2016. All Rights Reserved.</p>
						</div>
					</div>
				</div>
			</div>
		</footer>
	

	</div>
	<!-- END fh5co-page -->

	</div>
	<!-- END fh5co-wrapper -->

	<!-- jQuery -->


	<script src="js/jquery.min.js"></script>
	<!-- jQuery Easing -->
	<script src="js/jquery.easing.1.3.js"></script>
	<!-- Bootstrap -->
	<script src="js/bootstrap.min.js"></script>
	<!-- Waypoints -->
	<script src="js/jquery.waypoints.min.js"></script>
	<!-- Stellar -->
	<script src="js/jquery.stellar.min.js"></script>
	<!-- Superfish -->
	<script src="js/hoverIntent.js"></script>
	<script src="js/superfish.js"></script>

	<!-- Main JS -->
	<script src="js/main.js"></script>
</body>
</html>