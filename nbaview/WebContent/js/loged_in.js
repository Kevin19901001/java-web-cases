/**
 * To check if the user has loged in. If true, change 'signin' and 'login' links to 'mine' and 'home'.
 * @author Kevin
 */
$(function(){
	$.ajax({
		url:'/nbaview/checkLoged',
		type:'post',
		dataType:'json',
		success: function(data){
			if (data['login'] == 'true') {
				$("a[href='login']").replaceWith("<a href='mine'>mine</a>");
				$("a[href='signup']").replaceWith("<a href='/nbaview/'>home</a>");
			}
		}
	});
});