<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
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
	<c:if test="${flag==1 }">You May Like</c:if>
	<c:if test="${flag==0 }"><title>Movies of ${classification }</title></c:if>
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
	<link rel="stylesheet" type="text/css" href="css/default.css">
	<link rel="stylesheet" type="text/css" href="css/demo.css" />
	<link rel="stylesheet" type="text/css" href="css/component.css" />
	<!-- Modernizr is used for flexbox fallback -->
	<script src="js/modernizr.custom.js"></script>
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

	</div>
	<!-- END fh5co-page -->

	</div>

<!-- Main view -->
	<div class="view">
		<!-- Blueprint header -->
		<header class="bp-header cf">
		<c:if test="${flag==1 }"><h1>You May Like</h1></c:if>
			<c:if test="${flag==0 }"><h1>Movies of ${classification }</h1></c:if>
		</header>
		<!-- Product grid -->
		<section class="grid">
			<!-- Products -->
			<c:forEach items="${movieList }" var="movie">
			<div class="product" onclick="location.href='rate?mid=${movie.id}&uid=${user.id }'">
				<div class="product__info">
					<img class="product__image" src="images/img-1.jpg" alt="Product 1" />
					<h3 class="product__title">${movie.title }</h3>
				</div>
			</div>
			</c:forEach>
		</section>
		<c:if test="${flag==1 }">
		<div align="center">
		<c:if test="${way==1 }"><a href="cbRating?mf=${mf+5 }&uid=${user.id }&flag=1&way=1">continue to recommend</a></c:if> 
		<c:if test="${way==0 }"><a href="collaborateRating?uid=${user.id}&flag=1&mf=${mf+5 }&way=0 ">continue to recommend</a></c:if>
		</div></c:if>
		<c:if test="${flag==0 }"><div align="center"><a href="classification?pageNum=${pageNum-1 }&pageSize=12&classification=${classification }&flag=0">last page</a> <a href="classification?pageNum=${pageNum+1 }&pageSize=12&classification=${classification }&flag=0">next page</a></div></c:if>
	</div>
	
	<script src="js/classie.js"></script>
	<script src="js/movie.js"></script>
</body>
</html>