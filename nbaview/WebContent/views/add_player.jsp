<%@ page contentType="text/html; charset=utf8" %>
<html>
	<head>
		<title>add player</title>
		<link type="text/css" rel="stylesheet" href="/nbaview/css/header.css">
		<link type="text/css" rel="stylesheet" href="/nbaview/css/footer.css">
		<link type="text/css" rel="stylesheet" href="/nbaview/css/add_player.css">
		<script type="text/javascript" src="/nbaview/jquery/jquery-3.2.1.js"></script>
		<script type="text/javascript" src="/nbaview/js/loged_in.js"></script>
	</head>
	<body>
		<form action="savePlayer" method="post">
			<p>welocomr to add a player!</p>
			<p>the filed with * can not be blank!</p>
			Fist Name<input type="text" name="firstname" id="first name" class="playerInfo">
			Last Name<input type="text" name="lastname" id="lastname" class="playerInfo">
			Age<input type="text" name="age" id="age" class="playerInfo">
			Stature<input type="text" name="stature" id="stature" class="playerInfo">
			Weight<input type="text" name="weight" id="weight" class="playerInfo">
			City<input type="text" name="city" id="city" class="playerInfo">
			Team<input type="text" name="team" id="team" class="playerInfo">
			2kScore<input type="text" name="score" id="score" class="playerInfo">
			Nationality<input type="text" name="nationality" id="nationality" class="playerInfo">
			Contract<input type="text" name="contract" id="contract" class="playerInfo">
			Brief<input type="text" name="brief" id="brief" class="playerInfo">
			<input type="button" value="save" name="save" id="save">
		</form>
	</body>
</html>