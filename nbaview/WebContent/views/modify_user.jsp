<%@ page contentType="text/html; charset=utf8" %>
<html>
	<head>
		<title>modify user</title>
		<link type="text/css" rel="stylesheet" href="/nbaview/css/header.css">
		<link type="text/css" rel="stylesheet" href="/nbaview/css/footer.css">
		<link type="text/css" rel="stylesheet" href="/nbaview/css/modify_user.css">
		<script type="text/javascript" src="/nbaview/jquery/jquery-3.2.1.js"></script>
		<script type="text/javascript" src="/nbaview/js/loged_in.js"></script>
		<script type="text/javascript" src="/nbaview/js/modify_user.js"></script>
	</head>
	<body>
		<%@ include file="header.jsp" %>
		<div id="modify">
			<div id="info">
				<div class="line" id="fisrtLine">
					<p>username:<input type="text" class="userInfo" id="username" name="username" value=${ user.getUsername() }></p>
					<p>age:<input type="text" class="userInfo" id="age" name="age" value=${ user.getAge() }></p>
					<p>sex:<input type="text" class="userInfo" id="sex" name="sex" value=${ user.getSex() }></p>
				</div>
				<div class="line" id="secondLine">
					<p>email:<input type="text" class="userInfo" id="email" name="email" value=${ user.getEmail() }></p>
					<p>tel:<input type="text" class="userInfo" id="tel" name="tel" value=${ user.getTel() }></p>
					<p>job:<input type="text" class="userInfo" id="job" name="job" value=${ user.getJob() }></p>
				</div>
				<div class="line" id="thirdLine">
					<p>brief:<textarea rows="3" cols="50" class="userInfo" id="brief" name="brief">${ user.getBrief() }</textarea></p>
				</div>
				<div class="line" id="fourthLine">
					<input type="button" value="save" id="save">
				</div>
			</div>
		</div>
		<%@ include file="footer.jsp" %>
	</body>
</html>