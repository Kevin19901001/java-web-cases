<%@ page contentType="text/html; charset=utf8" %>
<html>
	<head>
		<title>signup</title>
		<link type="text/css" rel="stylesheet" href="/nbaview/css/header.css">
		<link type="text/css" rel="stylesheet" href="/nbaview/css/signup.css">
		<link type="text/css" rel="stylesheet" href="/nbaview/css/footer.css">
		<script type="text/javascript" src="/nbaview/jquery/jquery-3.2.1.js"></script>
		<script type="text/javascript" src="/nbaview/js/user_signup_validate.js"></script>
		<link type="text/css" rel="stylesheet" href="/nbaview/css/validate.css">
	</head>
	<body>
		<%@ include file="header.jsp" %>
		<form id="addUser" action="addUser" method="post">
			eamil:<input type="text" name="email" id="email" /><br><br>
			username:<input type="text" name="username" id="username" /><br><br>
			password:<input type="password" name="password" id="password" /><br><br>
			confirm:<input type="password" name="confirm" id="confirm" /><br><br>
			<input type="submit" value="signup" name="signup" id="signup" />
		</form>
		<%@ include file="footer.jsp" %>
	</body>
</html>