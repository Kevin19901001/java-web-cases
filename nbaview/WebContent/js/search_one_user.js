/**
 * Do 'delete, addManager, removeManager' operations for 'search_one_user_page'.
 * @author Kevin
 */
$(function(){

	/* Delete a user */
	$(".deleteUserOperation").click(function(){
		var username = $(this).attr("name");
		alert("delete user: " + username);
		$.ajax({
			url:'/nbaview/deleteUser',
			type:'post',
			dataType:'json',
			data:{ "username":username },
			success:function(result){
				if(result['isDeleted'] == 'yes'){
					alert("user "  + username + " has been deleted!")
					$("table tr").remove("#tr_" + username);
				}else{
					alert("for some reason, user " + username + " has not been deleted!");
				}
			}
		});
	});
	
	
	/* Add manager */
	$(".addManagerOperation").click(function(){
		var toBemanagerUsername = $(this).attr("name");
		var usernameIdSelector = "#" + toBemanagerUsername;
		var username = $(usernameIdSelector).text();
		var level = $(usernameIdSelector).next().next().next().text();
		$.ajax({
			url:'/nbaview/addManager',
			type:'post',
			data:{ "username":username },
			dataType:'json',
			success:function(result){
				if(result['isAdded'] == 'yes'){
					alert("user " + username + " has been manager!");
					$(usernameIdSelector).next().next().next().text(result['level']);
				}else{
					alert("for some reason, user " + username + " has not been manager!");
				}
			}
		});
	});
	
	
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
					var usernameSelector = "#" + username;
					$(usernameSelector).next().next().next().text("common");
				}else{
					alert("for some reason, user " + username + " has not been common!");
				}
			}
		});
	});
	
});