<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>login</title>
<link rel="stylesheet" href="css/login.css" media="screen"
	type="text/css" />
</head>
<body>
	<link href="http://fonts.googleapis.com/css?family=Open+Sans:400,700"
		rel="stylesheet" type="text/css">
	<script
		src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
	<div id="logmsk" style="display: block;">
		<div id="userbox">
			<h1 id="signup"
				style="background-color: rgb(118, 171, 219); background-position: initial initial; background-repeat: initial initial;">Sign
				up</h1>
			<form action="login" method="post">
				<input name="username" id="name" placeholder="Username"
					style="opacity: 1; background-color: rgb(255, 255, 255); background-position: initial initial; background-repeat: initial initial;">
				<input name="password" id="name" type="password"
					placeholder="Password"
					style="opacity: 1; background-color: rgb(255, 255, 255); background-position: initial initial; background-repeat: initial initial;">
				<button id="signupb" style="cursor: default;">Login</button>
			</form>
		</div>
	</div>

	<script src='http://codepen.io/assets/libs/fullpage/none.js'></script>
</body>
</html>