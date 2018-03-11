<%@ page contentType="text/html; charset=utf8" %>
<html>
<head>
<title>nba view</title>
<link type="text/css" rel="stylesheet" href="/nbaview/css/header.css">
<link type="text/css" rel="stylesheet" href="/nbaview/css/home.css">
<link type="text/css" rel="stylesheet" href="/nbaview/css/footer.css">
<script type="text/javascript" src="/nbaview/jquery/jquery-3.2.1.js"></script>
<script type="text/javascript" src="/nbaview/js/loged_in.js"></script>
</head>
<body>
	<%@ include file="header.jsp" %>
	<div class="Content">
		<div class="News">
			<p>First newses:</p>
		</div>
		<div class="Videos">
			<p>Newest videos:</p>
		</div>
	</div>
	<%@ include file="footer.jsp" %>
</body>
</html>