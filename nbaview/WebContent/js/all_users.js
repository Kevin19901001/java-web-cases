/**
 * Do 'delete, addManager' operations for 'all_user_page'.
 * @author Kevin
 */
$(function(){

	/* Delete a user */
	$(".deleteUserOperation").click(function(){
		var username = $(this).attr("name");
		$.ajax({
			url:'/nbaview/deleteUser',
			type:'post',
			dataType:'json',
			data:{ "username":username },
			success:function(result){
				if(result['isDeleted'] == 'yes'){
					alert("user "  + username + " has been deleted!");
					var toBeDeletedRowSelector = "#tr_" + username;
					$("table tr").remove(toBeDeletedRowSelector);
					window.location.reload();
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
	
});