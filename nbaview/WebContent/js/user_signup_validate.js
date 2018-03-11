/**
 * User info validator for user signing up.
 * @author Kevin
 * @since 2017-08-24
 */
$(function(){
	/* validate email */
	$("#email").bind("blur", function(){
		var emailText = $("#email").val();
		var localChecked = localValidateEmail(emailText);
		if (localChecked) {
			$.ajax({
				type:'POST',
				url:'/nbaview/checkEmail',
				data: { email:emailText },
				dataType:'json',
				success:function(data){
					if (data['textStatus'] == 'error') {
						$("#email").after("<span class='error' id='emailError'>This email has been used!</span>");
						alert("This email has been used!");
					} else {
						$("#email").after("<span class='success' id='emailSuccess'></span>");
						alert("This email can be used!");
					}
				}
			});
		}
	});
	
	
	/* validate username */
	$("#username").bind("blur", function(){
		var usernameText = $("#username").val();
		var localChecked = localValidateUsername(usernameText);
		if (localChecked) {
			$.ajax({
				type:'POST',
				url:'/nbaview/checkUsername',
				data: { username:usernameText },
				dataType:'json',
				success:function(data){
					if (data['textStatus'] == 'error') {
						$("#username").after("<span class='error' id='usernameError'>This username has been used!</span>");
						alert("This username has been used!");
					} else {
						$("#username").after("<span class='success' id='usernameSuccess'></span>");
						alert("This username can be used!");
					}
				}
			});
		}
	});
	
	
	/* validate password */
	$("#password").bind("blur", function(){
		var passwordText = $("#password").val();
		localValidatePassword(passwordText);
	});
	
	
	/* validate confirm */
	$("#confirm").bind("blur", function(){
		var passwordText = $("#password").val();
		var confirmText = $("#confirm").val();
		localValidateConfirm(passwordText, confirmText)
	});
	
	
	/* email focus */
	$("#email").bind("focus", function(){
		$("#emailError").replaceWith("<span></span>");
	});
	
	
	/* username focus */
	$("#username").bind("focus", function(){
		$("#usernameError").replaceWith("<span></span>");
	});
	
	
	/* password focus */
	$("#password").bind("focus", function(){
		$("#passwordError").replaceWith("<span></span>");
	});
	
	
	/* confirm focus */
	$("#confirm").bind("focus", function(){
		$("#confirmError").replaceWith("<span></span>");
	});
	
});


function localValidateEmail(emailText){
	// validate content
	if (emailText == "") {
		$("#email").after("<span class='error' id='emailError'>email can not be blank!</span>");
		return false;
	}
	
	var emailReg = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(\.[a-zA-Z0-9_-])+/;
	
	// validate format
	if (!(emailReg.test(emailText))) {
		$("#email").after("<span class='error' id='emailError'>please enter a valid email!</span>");
		return false;
	}
	
	return true;
}


function localValidateUsername(usernameText){
	if (usernameText.length > 16 || usernameText.length < 4) {
		$("#username").after("<span class='error' id='usernameError'>username's length must between 4 and 16!</span>");
		return false;
	}
	return true;
}


function localValidatePassword(passwordText){
	if (passwordText.length > 16 || passwordText.length < 8) {
		$("#password").after("<span class='error' id='passwordError'>password's length must between 8 and 16!</span>");
		return false;
	}
	return true;
}

function localValidateConfirm(passwordText, confirmText){
	if (passwordText != confirmText) {
		$("#confirm").after("<span class='error' id='confirmError'>twice passwords are not accordant!</span>");
	}
}