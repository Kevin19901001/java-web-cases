<%@ page contentType="text/html; charset=utf8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<title>my zone</title>
		<link type="text/css" rel="stylesheet" href="/nbaview/css/header.css">
		<link type="text/css" rel="stylesheet" href="/nbaview/css/mine.css">
		<link type="text/css" rel="stylesheet" href="/nbaview/css/footer.css">
		<script type="text/javascript" src="/nbaview/jquery/jquery-3.2.1.js"></script>
		<script type="text/javascript" src="/nbaview/js/loged_in.js"></script>
		<script type="text/javascript" src="/nbaview/js/super_mine.js"></script>
	</head>
	<body>
		<%@ include file="header.jsp" %>
		<div id="super">
			<p>manage users</p>
			<div id="chosen">
				<a href="/nbaview/showAllUsers" id="all">all</a>
				<a href="/nbaview/showManagerUers" id="managers">managers</a>
				<a id="/nbaview/search" id="search"></a>
			</div>
			
			<div id="userManagement">
				
				
			</div>
		</div>
		<%@ include file="footer.jsp" %>
	</body>
</html>