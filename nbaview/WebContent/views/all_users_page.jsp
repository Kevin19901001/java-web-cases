<%@ page contentType="text/html; charset=utf8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<title>my zone</title>
		<link type="text/css" rel="stylesheet" href="/nbaview/css/header.css">
		<link type="text/css" rel="stylesheet" href="/nbaview/css/footer.css">
		<script type="text/javascript" src="/nbaview/jquery/jquery-3.2.1.js"></script>
		<script type="text/javascript" src="/nbaview/js/loged_in.js"></script>
		<script type="text/javascript" src="/nbaview/js/all_users.js"></script>
		<script type="text/javascript" src="/nbaview/js/search_user.js"></script>
		<script type="text/javascript" src="/nbaview/js/search_one_user.js"></script>
		<link type="text/css" rel="stylesheet" href="/nbaview/css/all_users.css">
	</head>
	<body>
		<%@ include file="header.jsp" %>
		<div id="super">
			<div id="chosen">
				<a href="/nbaview/mine" id="all">all</a>
				<a href="/nbaview/showManagerUsers" id="managers">managers</a>
			</div>
			<%@ include file="search_user.jsp" %>
			<div id="userManagement">
				<%@ include file="all_users.jsp" %>
			</div>
		</div>
		<%@ include file="footer.jsp" %>
	</body>
</html>