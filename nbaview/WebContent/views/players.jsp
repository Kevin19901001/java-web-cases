<%@ page contentType="text/html; charset=utf8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.nbaview.entity.Player, java.util.List" %>
<html>
	<head>
		<title>players</title>
		<link type="text/css" rel="stylesheet" href="/nbaview/css/header.css">
		<link type="text/css" rel="stylesheet" href="/nbaview/css/footer.css">
		<c:if test="${ playerList.size() == 0 }">
			<link type="text/css" rel="stylesheet" href="/nbaview/css/players_empty.css">
		</c:if>
		<c:if test="${ playerList.size() > 0 }">
			<link type="text/css" rel="stylesheet" href="/nbaview/css/players.css">
		</c:if>
		<script type="text/javascript" src="/nbaview/js/loged_in.js"></script>
	</head>
	<body>
		<%@ include file="header.jsp" %>
		<div>
			<c:if test="${ playerList.size() == 0 }">
				Sorry, there is no player now!
			</c:if>
			<c:if test="${ playerList.size() == 0 }">
				<c:forEach items="playerList" var="player">
					<div><a href="him"><img src="/nbaview/images/players/${ player.getUsername() }.jpg"></a></div>
				</c:forEach>
				<p><a>first</a><a>pre</a><a>1</a><a>2</a><a>3</a><a>next</a><a>last</a></p>
			</c:if>
		</div>
		<%@ include file="footer.jsp" %>
	</body>
</html>