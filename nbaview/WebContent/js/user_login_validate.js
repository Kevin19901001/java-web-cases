/**
 * To validate correct password and username for user loging in.
 * @author Kevin
 */
$(function(){

	$("#username").blur(function(){
		var username = $("#username").val(); 
		localValidateUsername(username);
	});
	
	
	$("#password").blur(function(){
		var password = $("#password").val();
		localValidatePassword(password);
	});
	
	
	$("#username").focus(function(){
		$("#span").remove("#usernameError");
		$("p").remove("#loginFailed");
		$("#usernameError").replaceWith("<span></span>");
	});
	
	
	$("#password").focus(function(){
		$("#span").remove("passwordError");
		$("p").remove("#loginFailed");
		$("#passwordError").replaceWith("<span></span>");
	});
	
});


function localValidateUsername(username){
	if (username == "") {
		$("#username").after("<span class='error' id='usernameError'>username can not be blank!</span>");
		return false;
	}
}


function localValidatePassword(password){
	if (password == "") {
		$("#password").after("<span class='error' id='passwordError'>password can not be blank!</span>");
	}
	return false;
}