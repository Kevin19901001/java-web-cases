<%@ page contentType="text/html; charset=utf8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<title>my zone</title>
		<link type="text/css" rel="stylesheet" href="/nbaview/css/header.css">
		<link type="text/css" rel="stylesheet" href="/nbaview/css/footer.css">
		<script type="text/javascript" src="/nbaview/jquery/jquery-3.2.1.js"></script>
		<script type="text/javascript" src="/nbaview/js/loged_in.js"></script>
		<script type="text/javascript" src="/nbaview/js/manager_users.js"></script>
		<script type="text/javascript" src="/nbaview/js/search_user.js"></script>
		<script type="text/javascript" src="/nbaview/js/search_one_user.js"></script>
		<link type="text/css" rel="stylesheet" href="/nbaview/css/manager_users.css">
		<link type="text/css" rel="stylesheet" href="/nbaview/css/table.css">
		<link type="text/css" rel="stylesheet" href="/nbaview/css/chosen.css">
		<link type="text/css" rel="stylesheet" href="/nbaview/css/search_user.css">
	</head>
	<body>
		<%@ include file="header.jsp" %>
		<div id="super">
			<div id="chosen">
				<a href="/nbaview/showAllUsers" id="all">all</a>
				<a href="/nbaview/showManagerUsers" id="managers">managers</a>
			</div>
			<%@ include file="search_user.jsp" %>
			<div id="userManagement">
				<%@ include file="manager_users.jsp" %>
			</div>
		</div>
		<%@ include file="footer.jsp" %>
	</body>
</html>