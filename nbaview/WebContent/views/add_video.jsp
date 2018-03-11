<%@ page contentType="text/html; charset=utf8" %>
<html>
	<head>
		<title>add video</title>
		<link type="text/css" rel="stylesheet" href="/nbaview/css/header.css">
		<link type="text/css" rel="stylesheet" href="/nbaview/css/footer.css">
		<link type="text/css" rel="stylesheet" href="/nbaview/css/add_video.css">
		<script type="text/javascript" src="/nbaview/jquery/jquery-3.2.1.js"></script>
		<script type="text/javascript" src="/nbaview/js/loged_in.js"></script>
	</head>
	<body>
		<%@ include file="header.jsp" %>
		<div id="add">
			<h2 id="title"></h2>
			<p id="content"></p>
			<input type="button" value="save" id="save">
		</div>
		<%@ include file="footer.jsp" %>
	</body>
</html>