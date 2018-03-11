<%@ page contentType="text/html; charset=utf8" %>
<html>
	<head>
		<title>my zone</title>
		<link type="text/css" rel="stylesheet" href="/nbaview/css/header.css">
		<link type="text/css" rel="stylesheet" href="/nbaview/css/mine.css">
		<link type="text/css" rel="stylesheet" href="/nbaview/css/footer.css">
		<script type="text/javascript" src="/nbaview/jquery/jquery-3.2.1.js"></script>
		<script type="text/javascript" src="/nbaview/js/loged_in.js"></script>
	</head>
	<body>
		<%@ include file="header.jsp" %>
		<div id="mine">
			<div id="info">
				<div class="line" id="firstLine">
					<p>username: ${ user.getUsername() }</p>
					<p>age: ${ user.getAge() }</p>
					<p>sex: ${ user.getSex() }</p>
				</div>
				<div class="line" id="secondLine">
					<p>email: ${ user.getEmail() }</p>
					<p>tel: ${ user.getTel() }</p>
				</div>
				<div class="line" id="thirdLine">
					<p>job: ${ user.getJob() }</p>
					<p>sign time: ${ user.getSignDate() }</p>
				</div>
				<div class="line" id="fourthLine">
					<p>brief: ${ user.getBrief() }</p>
				</div>
				<div class="line" id="fifthLine">
					<a href="modifyOwnInfo">modify</a>
				</div>
			</div>
			<div id="action">
				<a href="addAPlayer">add player</a>
				<a href="addANews">add news</a>
			</div>
		</div>
		<%@ include file="footer.jsp" %>
	</body>
</html>