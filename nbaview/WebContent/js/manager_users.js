/**
 * Do 'removeManager' operation for 'manager_users_page'.
 * @author Kevin
 */
$(function(){
	
	/* Remove a manager */
	$(".removeManagerOperation").click(function(){
		var username = $(this).attr("name");
		$.ajax({
			url:'/nbaview/removeManager',
			type:'post',
			data:{ "username":username},
			dataType:'json',
			success:function(result){
				if(result['isRemoved'] == 'yes'){
					alert("user " + username + " has been common!");
					$("table tr").remove("#tr_" + username);
				}else{
					alert("for some reason, user " + username + " has not been common!");
				}
			}
		});
	});
	
});