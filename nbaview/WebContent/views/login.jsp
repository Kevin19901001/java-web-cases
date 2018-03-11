<%@ page contentType="text/html; charset=utf8" %>
<html>
	<head>
		<title>user login</title>
		<link rel="stylesheet" href="/nbaview/css/header.css">
		<link rel="stylesheet" href="/nbaview/css/login.css">
		<link rel="stylesheet" href="/nbaview/css/footer.css">
		<script type="text/javascript" src="/nbaview/jquery/jquery-3.2.1.js"></script>
		<script type="text/javascript" src="/nbaview/js/user_login_validate.js"></script>
		<link type="text/css" rel="stylesheet" href="/nbaview/css/validate.css">
	</head>
	<body>
		<%@ include file="header.jsp" %>
		<form id="loginForm" action="checkLogin" method="post">
    		username:<input type="text" name="username" id="username"><br><br>
    		password:<input type="password" name="password" id="password"><br><br>
    		<input type="submit" name="submit" value="login" id="login">
    	</form>
		<%@ include file="footer.jsp" %>
	</body>
</html>