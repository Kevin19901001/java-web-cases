<%@ page contentType="text/html; charset=utf8" %>
<html>
	<head>
		<title>logout</title>
		<link type="text/css" rel="stylesheet" href="/nbaview/css/header.css">
		<link type="text/css" rel="stylesheet" href="/nbaview/css/footer.css">
		<link type="text/css" rel="stylesheet" href="/nbaview/css/players.css">
	</head>
	<body>
		<%@ include file="header.jsp" %>
		<div>logout</div>
		<% session.invalidate(); %>>
		<%@ include file="footer.jsp" %>
	</body>
</html>