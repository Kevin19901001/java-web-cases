<%@ page contentType="text/html; charset=utf8" %>
<html>
	<head>
		<title>add article</title>
		<link type="text/css" rel="stylesheet" href="/nbaview/css/header.css">
		<link type="text/css" rel="stylesheet" href="/nbaview/css/footer.css">
		<link type="text/css" rel="stylesheet" href="/nbaview/css/add_article.css">
		<script type="text/javascript" src="/nbaview/jquery/jquery-3.2.1.js"></script>
		<script type="text/javascript" src="/nbaview/js/loged_in.js"></script>
	</head>
	<body>
		<%@ include file="header.jsp" %>
		<div id="add">
			<h3 id="title"><%-- ${ article.title } --%></h3>
			<p id="content"></p>
			<input type="button" value="save" id="save">
		</div>
		<%@ include file="footer.jsp" %>
	</body>
</html>