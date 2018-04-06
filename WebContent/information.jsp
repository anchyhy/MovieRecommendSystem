<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style>
html {
	height: 100%;
}
body {
	height: 100%;
	margin: 0;
}
.container {
	height: 96%;
	width: 96%;
	margin: 0 auto;
	padding: 10px 0;
}
.poster {
	width: 50%;
	height: 100%;
	float: left;
}
.poster>img {
	width: 100%;
	height: 100%;
	box-shadow: 4px 4px 10px #000000;
}

.introduction {
	width: 50%;
	height: 20%;
	float: left;
}

.introduction>p {
	margin: 0 20px;
}

.rating {
	width: 50%;
	height: 20%;
	float: left;
}

.rating>p {
	margin: 0 20px;
}

.prompt {
	display: none;
}
</style>
<title>Movie Information</title>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
	<script type="text/javascript">
	$(function(){
		$(".rating>span").hover(function(){
			$(".rating").children("span").css("color", "black");
			$(".rating").children("span").text("☆");
			var index = $(this).index() + 1;
			$(".rating>span:lt("+ index +")").css("color", "#CCCC00");
			$(".rating>span:lt("+ index +")").text("★");
		}, function(){
			var index = $(".rating>p>span").text();
			$(".rating").children("span").css("color", "black");
			$(".rating").children("span").text("☆");
			$(".rating>span:lt("+ index +")").css("color", "#CCCC00");
			$(".rating>span:lt("+ index +")").text("★");
		})

		$(".rating>span").click(function(){
			$(".rating>p>span").text($(this).index() + 1);
			$(".prompt>p>span").text($(this).index() + 1);
			$.ajax({
				type:'POST',
				url:'ratemovie',
				data:$("#form").serializeArray(),
				data: {
					"r": $(this).index() + 1,
					"uid": $('#uid').prop("value"),
					"mid": $('#mid').prop("value")
						},
				success:function() {
					$(".rating").fadeOut(200);
					$(".prompt").fadeIn(200);
				}
			});
		});
	});
	</script>
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
</head>
<body>
	<div class="container">
		<div class="poster">
			<img src="images/img-1.jpg">
		</div>
		<div class="introduction">
			<p>Title: ${movie.title }</p>
			<p>rating: ${rating }</p>
			<input type="hidden" id="uid"  value="${user.id}"/>
			<input type="hidden" id="mid"  value="${movie.id}"/>
		</div>
		
		<div class="rating">
		<c:if test="${userrate == null }">
		<span>☆</span><span>☆</span><span>☆</span><span>☆</span><span>☆</span>
		<p>Current Rating is <span>0</span></p>
		</c:if>
		<c:if test="${userrate !=null }">
		<p>${userrate.rate }</p>
		</c:if>
		</div>
		<div class="prompt">
		<p>Your rating: <span></span></p>
		</div>
	</div>
</body>
</html>